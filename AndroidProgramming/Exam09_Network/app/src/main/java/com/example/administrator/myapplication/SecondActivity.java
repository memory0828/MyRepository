package com.example.administrator.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadFactory;

public class SecondActivity extends AppCompatActivity {
    private ListView foodList;
    private ImageView imageLarge;
    private FoodAdapter foodAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        //이미지를 클랙했을 때 큰그림 나타나도록 하는 이벤트 처리(★이벤트 처리 방법2 번째 방식) ----------------
        imageLarge = (ImageView)findViewById(R.id.imageLarge);

        foodList = (ListView) findViewById(R.id.foodList);

        foodList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final Food food = (Food) foodAdapter.getItem(position);
                Thread thread = new Thread() {
                    @Override
                    public void run() {
                        final Bitmap bitmap = getBitmap(food.getImageLargeFileName());
                        imageLarge.post(new Runnable() {
                            @Override
                            public void run() {
                                imageLarge.setImageBitmap(bitmap); //보여주고 끝내는 방법( 메모리에 부담없이 )
                            }
                        });
                    }
                };
                thread.start();
            }
        });
        //--------------------------------------------------------------------------------------------------------

        fillItems(); //데이터를 만드는 부분 호출
    }

    public void fillItems() {
        //========== HTTP 통신 코드 ================================================
        // 스레드는 필수(이거 없으면 에러가 나버림)
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    URL url = new URL("http://192.168.0.30:8080/myandroid/foodlist");
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.connect(); //연결을 해라
                    //if(conn.getResponseCode() == HttpURLConnection.HTTP_OK) { //HttpURLConnection.HTTP_OK 는 200을 뜻함 ( 아래 코드랑 같은 역할 )
                    //// 응답이 정상적으로 왔을 경우
                    if (conn.getResponseCode() == 200) {
                        /*응답 Http 헤더행에
                        404 :  요청경로가 잘못됐을떄
                        500 : 서버가 잘못됬을때
                        ★200 : 정상응답 -> 정상응답일 경우 본문행에 json데이터가 들어가있다*/
                        // 본문행을 읽기 위해서
                        //1
                        InputStream is = conn.getInputStream();
                        //2
                        Reader reader = new InputStreamReader(is);
                        //3. BufferedReader 성능향상을 위해 달아줌
                        BufferedReader br = new BufferedReader(reader);
                        String strJson = "";
                        while (true) {
                            String data = br.readLine(); //readline 한줄 전체를 읽기( jSon 데이터의 한줄 씩 읽어들임)
                            if (data == null) break; //더이상 읽을 데이터가 없으면 break로 빠져나고
                            strJson += data; //읽은 데이터가 있으면 strJson에 저장함
                        }
                        br.close();
                        reader.close();
                        is.close();


                        //========== json 파싱 데이터 얻는 방법 ========================
                        //응답온 내용 로고로 보기
                        Log.i("mylog", strJson);
                        final List<Food> list = parseJson(strJson);
                        // ---------- 메인스레드에서 실행되는 코드
                        foodList.post(new Runnable() { //foodList라는 위젯(main스레드가 만든 view 중 하나)을 post 메소드를 통해 메인스레드가 실행할 수 있도록 넘기는데 이때 new Runnable() {..}라는 객체를 넘기고 이안에 있는 것을 main스레드에서 실행해다오 뜻 / 왜 이렇게하면 화면에 있는 자원을 써야하기때문에 메인스레드에서 사용해야함
                            @Override
                            public void run() {
                                foodAdapter = new FoodAdapter(SecondActivity.this);
                                foodAdapter.setList(list); //어뎁터를 만들고 데이터 셋팅함 list->로컬변수가 익명객체안에서 사용되기때문에 final특성을 추가해줌
                                foodList.setAdapter(foodAdapter);
                                imageLarge.setImageBitmap(list.get(0).getImageLarge());
                            }
                        });
                        // -----------------------------------------
                        //===============================================================

                    }
                    conn.disconnect(); //연결을 끊어라
                } catch (Exception e) {
                    Log.i("mylog", e.getMessage());
                }
            }
        };
        thread.start();
        //★이렇게 메인스레드는 빠르게 이 스레드를 실행하고 다른 일을 해야함(만약 메인스레드가 네트워크 통신까지 담당하면 에러다!)
        //==========================================================================
    }

    private List<Food> parseJson(String strJson) {
        ////////////////////////
        // 파싱 데이터 얻기
        ////////////////////////
        //1.strJson 으로 넘어오는 문자열이 {로 시작하는 거면 JSONObject 파싱
        //JSONObject jsonObject = new JSONObject(); //파싱코드

        //2.★strJson으로 넘어오는 문자열이 [로 시작하는 ( 배열로 시작하면 ) JSONArray 파싱
        //여기선 strJson이 [ 시작해서 ] 끝나는 식으로 넘어오고 10개의 데이터( { 로시작, }로 끝나는것들 )가 넘어옴
        List<Food> list = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(strJson); //파싱코드
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i); // {}인 데이터들을 얻는 부분
                Food food = new Food();
                food.setImage(getBitmap(jsonObject.getString("image")));
                if(i==0) {
                    food.setImageLarge(getBitmap(jsonObject.getString("imageLarge")));
                }
                food.setImageFileName(jsonObject.getString("image"));
                food.setImageLargeFileName(jsonObject.getString("imageLarge"));
                food.setTitle(jsonObject.getString("title"));
                food.setPrice(jsonObject.getString("price"));
                food.setContent(jsonObject.getString("content"));
                list.add(food);

            }
        } catch (JSONException e) {
            Log.i("mylog", e.getMessage());
        }

        return list;

    }

    public Bitmap getBitmap(String fileName) {
        Bitmap bitmap = null;
        try {
            URL url = new URL("http://192.168.0.30:8080/myandroid/getImage?fileName=" + fileName);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.connect(); //연결을 해라

            if (conn.getResponseCode() == 200) {
                InputStream is = conn.getInputStream();
                bitmap = BitmapFactory.decodeStream(is); //인풋스트림만 알면 비트맵을 막바로 알수있음
            }
            conn.disconnect();

        } catch (Exception e) {
            Log.i("mylog", e.getMessage());
        }

        return bitmap;
    }


}
