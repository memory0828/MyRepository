package com.example.administrator.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
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

public class MainActivity extends AppCompatActivity {
    private ListView lightList;
    private ImageView imageLarge;
    private LightAdapter lightAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //이미지를 클랙했을 때 큰그림 나타나도록 하는 이벤트 처리(★이벤트 처리 방법2 번째 방식) ----------------
        imageLarge = (ImageView)findViewById(R.id.imageLarge);
        lightList = (ListView) findViewById(R.id.lightList);
        lightList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final Light light = (Light) lightAdapter.getItem(position);

                AsyncTask<Void, Void, Bitmap> asyncTask = new AsyncTask<Void, Void, Bitmap>() {
                    @Override
                    protected Bitmap doInBackground(Void... params) {
                        return getBitmap(light.getImageLargeFileName());
                    }

                    @Override
                    protected void onPostExecute(Bitmap bitmap) {
                        imageLarge.setImageBitmap(bitmap); //보여주고 끝내는 방법( 메모리에 부담없이 )
                    }
                };
                asyncTask.execute();
            }
        });
        //--------------------------------------------------------------------------------------------------------

        //testAnsyncTask1(); //AsyncTask 수행 테스트
        fillItems(); //데이터를 만드는 부분 호출
    }

    public void testAnsyncTask1() {
        ///////////// AsyncTask 수행 테스트 ////////////////
        //Void : 제너릭타입으로 어떻한 데이터도 받지 않겠다는 표현으로 소문자(void)는 클래스타입도 아닌 인터페이스 타입도 아님으로, Void(하나의참조타입)을 넣어줌
        Log.i("mylog", "thread1:" + Thread.currentThread().getName()); //현재실행하고있는 스레드 이름 출력( 메인스레드가 실행중이라 나옴 )
        AsyncTask<String, Integer, String> asyncTask = new AsyncTask<String, Integer, String>() {
            //이 AsyncTask<첫번째(Void), 두번째(Void), 세번쨰(Void)>에서
            //첫번쨰 타입파라미터 : AsyncTask에 어떤 파마리터를 넘길때 그 타입을 결정함 ( 이건 asyncTask.execute(..)로 실행할 때 전달됨 )
            //                      즉, 첫번쨰 타입파라미터을 String로 정의하면 asyncTask.execute();을 할때 asyncTask.execute(이곳); 에 지정한 타입의 값을 넣어서 전달이 가능하며, 이것은 결국 doInBackground(Void... params)에 파라미터값으로 전달되기 때문에 이곳의 타입까지 영향을 줌
            //두번쨰 타입파라미터 : 작업이 진행되고 있을 때 publishProgress()를 호출할 때 publishProgress(...)이렇게 매개값으로 전달될 타입을 결정지음
            //세번째 타입파라미터 : 세번 째 타입파라미터(Void)는 doInBackground에서 리턴타입을 결정짓고 이 리턴타입이 onPostExecute로 전달되기 때문에 결론적으로 이곳의 파라미터의 타입을 결정지음

            @Override
            //실행순서1. 제일 먼저 실행됨
            protected String doInBackground(String... params) {
                //★UI변경 코드 올수없음( 작업 스레드가 수행 )
                //백그라운드에서 실행하는 메소드
                Log.i("mylog", "thread2:" + Thread.currentThread().getName()); //현재실행하고있는 스레드 이름 출력 ( 작업 스레드가 실행중이라 나옴 )
                Log.i("mylog", "thread2:" + params[0]); //asyncTask.execute( ?? )으로 넘어온 파라미터 출력
                //publishProgress(); //onProgressUpdate 호출하는 거(이런식으로 진행사하 중간에 넘김 ㅋ)
                Log.i("mylog", "thread2:" + params[1]); //asyncTask.execute( ?? )으로 넘어온 파라미터 출력
                //publishProgress(); //onProgressUpdate 호출하는 거(이런식으로 진행사하 중간에 넘김 ㅋ)
                Log.i("mylog", "thread2:" + params[2]); //asyncTask.execute( ?? )으로 넘어온 파라미터 출력
                //publishProgress(); //onProgressUpdate 호출하는 거(이런식으로 진행사하 중간에 넘김 ㅋ)

                for (int i = 1; i <= 100; i++) {
                    if (i == 1) {
                        publishProgress(1); //onProgressUpdate 호출하는 거
                    } else if (i == 50) {
                        publishProgress(50); //onProgressUpdate 호출하는 거
                    } else if (i == 100) {
                        publishProgress(100); //onProgressUpdate 호출하는 거
                    }
                }

                return "작업스레드결과";
            }

            @Override
            //(선택)실행순서2. 중간에 publishProgress 호출 되면 실행됨
            protected void onProgressUpdate(Integer... values) {
                //★UI변경 코드 가능( 메인스레드가 수행 )
                //작업스레드가 작업하고있는 작업의 경과(상태 스레드 바처럼 작업의 상황을 보여주는 역할)
                //지혼자서는 실행이 안되고, 평상시에는 실행안되다가 doInBackground안에서 이넘을 실행해달라는 요청이 들어왔을 경우 실행됨

                Log.i("mylog", "thread3:" + Thread.currentThread().getName()); //현재실행하고있는 스레드 이름 출력 ( 메인스레드가 실행중이라 나옴 )
                Log.i("mylog", "thread3:" + "작업진행정도" + values[0]); //publishProgress() 에서 (..)으로 넘긴값 출력
            }


            @Override
            //실행순서3. doInBackground->다음 실행 되거나, doInBackground->onProgressUpdate->다음 실행됨
            protected void onPostExecute(String aVoid) {
                //★UI변경 코드 가능( 메인스레드가 수행 )
                //뭐뭐(작업)이 끝났을 때 여기를 실행해준다? 뭐가끝났을때? 앞에 doInBackground(..){...} 작업이 끝났을 때!
                /* 이게 왜 필요하나? 작업스레드에서 처리한 내용에 따라 ui변경작업이 필요할 경우 있는데,
                   이럴 때 ui는 메인스레드가 관장함으로 이 메소드를 통해 메인스레드에서 처리하도록 해줌
                /* 그래서 Void doInBackground(Void... params) { .. }의 리턴인 void가
                   void onPostExecute(Void aVoid) { .. } 에서 aVoid으로 파라미터값으로 넘어옴
                 */

                Log.i("mylog", "thread4:" + Thread.currentThread().getName()); //현재실행하고있는 스레드 이름 출력 ( 메인스레드가 실행중이라 나옴 )
                Log.i("mylog", "thread4:" + aVoid); //doInBackground에서 리턴한 값이 이 곳 파라미터로 넘어와서 그 값 출력
            }
        };
        asyncTask.execute("실행매개값1", "실행매개값2", "실행매개값3");
    }

    public void fillItems() {
        AsyncTask<Void, Void, List<Light>> asyncTask = new AsyncTask<Void, Void, List<Light>>() {
            @Override
            protected List<Light> doInBackground(Void... params) {
                List<Light> list = null;
                try {
                    //========== HTTP 통신 코드 ================================================
                    URL url = new URL("http://192.168.0.30:8080/myandroid/lightlist");
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
                        list = parseJson(strJson);
                        //==============================================================
                    }else {
                        Log.i("mylog", "http서버랑 통신이 뭔가 문제있는 상태");
                    }
                    conn.disconnect(); //연결을 끊어라
                    //========== HTTP 통신 코드 / 종료 ===========================================
                } catch (Exception e) {
                    Log.i("mylog", e.getMessage());
                }
                return list;
            }

            @Override
            protected void onPostExecute(List<Light> lights) {
                // ---------- 메인스레드에서 실행되는 코드
                lightAdapter = new LightAdapter(MainActivity.this);
                lightAdapter.setList(lights); //어뎁터를 만들고 데이터 셋팅함 list->로컬변수가 익명객체안에서 사용되기때문에 final특성을 추가해줌
                lightList.setAdapter(lightAdapter);
                imageLarge.setImageBitmap(lights.get(0).getImageLarge());
                // -----------------------------------------
            }
        };
        asyncTask.execute();
    }

    private List<Light> parseJson(String strJson) {
        ////////////////////////
        // 파싱 데이터 얻기
        ////////////////////////
        //1.strJson 으로 넘어오는 문자열이 {로 시작하는 거면 JSONObject 파싱
        //JSONObject jsonObject = new JSONObject(); //파싱코드

        //2.★strJson으로 넘어오는 문자열이 [로 시작하는 ( 배열로 시작하면 ) JSONArray 파싱
        //여기선 strJson이 [ 시작해서 ] 끝나는 식으로 넘어오고 10개의 데이터( { 로시작, }로 끝나는것들 )가 넘어옴
        List<Light> list = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(strJson); //파싱코드
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i); // {}인 데이터들을 얻는 부분
                Light light = new Light();
                light.setImage(getBitmap(jsonObject.getString("image")));
                if(i==0) {
                    light.setImageLarge(getBitmap(jsonObject.getString("imageLarge")));
                }
                light.setImageFileName(jsonObject.getString("image"));
                light.setImageLargeFileName(jsonObject.getString("imageLarge"));
                light.setTitle(jsonObject.getString("title"));
                light.setContent(jsonObject.getString("content"));
                list.add(light);

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
