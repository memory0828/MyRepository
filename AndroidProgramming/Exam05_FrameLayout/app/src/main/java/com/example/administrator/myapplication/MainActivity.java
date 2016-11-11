package com.example.administrator.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    private LinearLayout frame1;
    private LinearLayout frame2;
    private LinearLayout frame3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frame1 = (LinearLayout)findViewById(R.id.frame1); //findViewById() : id로 뷰를 찾겠다(id로 객체 찾기), 하지만 찾은게 무슨 타입인지는 판단못함 그래서 리턴타입은 View타입으로 리턴함 + 여기다가 캐스팅을 써서 객체를 이렇게 사용하게됨
        frame2 = (LinearLayout)findViewById(R.id.frame2); //findViewById() : id로 뷰를 찾겠다(id로 객체 찾기), 하지만 찾은게 무슨 타입인지는 판단못함 그래서 리턴타입은 View타입으로 리턴함 + 여기다가 캐스팅을 써서 객체를 이렇게 사용하게됨
        frame3 = (LinearLayout)findViewById(R.id.frame3); //findViewById() : id로 뷰를 찾겠다(id로 객체 찾기), 하지만 찾은게 무슨 타입인지는 판단못함 그래서 리턴타입은 View타입으로 리턴함 + 여기다가 캐스팅을 써서 객체를 이렇게 사용하게됨
    }

    public void onClickFrame1(View view){ //view는 이벤트할때 설명
        frame1.setVisibility(View.VISIBLE); //활성화(보이게)
        frame2.setVisibility(View.INVISIBLE); //비활성화(안보이게)
        frame3.setVisibility(View.INVISIBLE); //비활성화(안보이게)
    }

    public void onClickFrame2(View view){ //view는 이벤트할때 설명
        frame1.setVisibility(View.INVISIBLE);
        frame2.setVisibility(View.VISIBLE);
        frame3.setVisibility(View.INVISIBLE);
    }

    public void onClickFrame3(View view){ //view는 이벤트할때 설명
        frame1.setVisibility(View.INVISIBLE);
        frame2.setVisibility(View.INVISIBLE);
        frame3.setVisibility(View.VISIBLE);
    }

}
