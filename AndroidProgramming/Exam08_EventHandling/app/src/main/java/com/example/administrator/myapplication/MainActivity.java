package com.example.administrator.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView lightList;

    private List<Light> list; //데이터를 만드는 부분에서 초기화(사용하는 데이터 배열)
    private ImageView imageLarge;

    // ★이벤트 처리 방법2_1 -------------------
    private Button button2; //button2는 자바코드로 이벤트 처리를 하고 싶어서 이렇게 하는거임
    //--------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lightList = (ListView)findViewById(R.id.lightList);

        //이미지를 클랙했을 때 큰그림 나타나도록 하는 이벤트 처리(★이벤트 처리 방법2 번째 방식) ----------------
        imageLarge = (ImageView)findViewById(R.id.imageLarge);
        lightList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Light light = list.get(position);
                imageLarge.setImageResource(light.getImageLarge());
            }
        });
        //--------------------------------------------------------------------------------------------------------

        // ★이벤트 처리 방법2_2 -----------------
        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(onClickListener); //onClickListener는 클릭이되는 것을 경청(클릭이 되나 안되나~)하는 놈
        /*위 방법을 이렇게 간단하게 쓸수있음( 이렇게 하면 밖에 있는 관련 필드 없애도 됨)
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });*/
        //--------------------------------------------

        fillItems(); //데이터를 만드는 부분 호출
    }

    // ★이벤트 처리 방법2_3 -----------------
    // 위에서 사용한 onClickListener 를 선언(OnClickListener 구현객체)하는 부분
    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class); //여기서 this만하면 익명객체인 View.OnClickListener을 가르킴으로, 바깥객체인 MainActivity.this로 지정해준다
            //-> Intent : 의도(~하고 싶다), 니가 하고 싶은게 뭐냐~ 즉, button1이 클릭됐을때, 뭔가 하고싶다
            //-> 현재화면(this)을 이 클래스(SecondActivity.class)의 화면으로 바꾸고싶다
            //-> 안드로이드에서 뭔가 하고싶을 때 반드시 위와같이 의도를 작성하고 그것을 안드로이드에 전달(아래)할 필요가있다
            startActivity(intent); //의도 전달
        }
    };
    //--------------------------------------------

    public void fillItems(){
        //데이터를 만드는 부분
        list = new ArrayList<>();
        list.add(new Light(R.drawable.light1, R.drawable.light1_large, "인테리어 조명1", "거실 등으로 사용하자. 검색은 테두리와 백열등의 조화가 보기 좋습니다"));
        list.add(new Light(R.drawable.light2, R.drawable.light2_large, "인테리어 조명2", "욕실 등으로 사용하자. 검색은 테두리와 백열등의 조화가 보기 좋습니다"));
        list.add(new Light(R.drawable.light3, R.drawable.light3_large, "인테리어 조명3", "현관 등으로 사용하자. 검색은 테두리와 백열등의 조화가 보기 좋습니다"));
        list.add(new Light(R.drawable.light4, R.drawable.light4_large, "인테리어 조명4", "서재 등으로 사용하자. 검색은 테두리와 백열등의 조화가 보기 좋습니다"));
        list.add(new Light(R.drawable.light5, R.drawable.light5_large, "인테리어 조명5", "큰방 등으로 사용하자. 검색은 테두리와 백열등의 조화가 보기 좋습니다"));
        list.add(new Light(R.drawable.light1, R.drawable.light1_large, "인테리어 조명1", "작은방 등으로 사용하자. 검색은 테두리와 백열등의 조화가 보기 좋습니다"));
        list.add(new Light(R.drawable.light2, R.drawable.light2_large, "인테리어 조명2", "외부 등으로 사용하자. 검색은 테두리와 백열등의 조화가 보기 좋습니다"));
        list.add(new Light(R.drawable.light3, R.drawable.light3_large, "인테리어 조명3", "거실 등으로 사용하자. 검색은 테두리와 백열등의 조화가 보기 좋습니다"));
        list.add(new Light(R.drawable.light4, R.drawable.light4_large, "인테리어 조명4", "욕실 등으로 사용하자. 검색은 테두리와 백열등의 조화가 보기 좋습니다"));
        list.add(new Light(R.drawable.light5, R.drawable.light5_large, "인테리어 조명5", "현관 등으로 사용하자. 검색은 테두리와 백열등의 조화가 보기 좋습니다"));


        LightAdapter lightAdapter = new LightAdapter(this); //this는 매인액티비티 객체임
        lightAdapter.setList(list);

        lightList.setAdapter(lightAdapter);

    }

    // ★이벤트 처리 방법1
    public void onClickButton1(View view) { //View view에는 현재 이벤트가 발생된 객체 ( 예) button1 )가 들어옴 / 왜 view인가? 모든 화면에 나타나는 요소는 View를 상속받기 때문에 뭐가 클릭된지 모르기 때문에 그걸 받기 위해서 View이다!
        ////////////////////////////
        // 이벤트 핸들러 사용
        ////////////////////////////
        Intent intent = new Intent(this, SecondActivity.class);
        //-> Intent : 의도(~하고 싶다), 니가 하고 싶은게 뭐냐~ 즉, button1이 클릭됐을때, 뭔가 하고싶다
        //-> 현재화면(this)을 이 클래스(SecondActivity.class)의 화면으로 바꾸고싶다
        //-> 안드로이드에서 뭔가 하고싶을 때 반드시 위와같이 의도를 작성하고 그것을 안드로이드에 전달(아래)할 필요가있다
        startActivity(intent); //의도 전달
    }



}
