package com.example.administrator.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;


public class MainActivity extends AppCompatActivity {  //하위 호환성 안드로이드 4.0.3까지 지원하는 하위호환성을 위해서 extends AppCompatActivity 로 상속받는다
    //activity_main.xml와 MainActivity.java 두파일에 의해서 하나의 화면이 만들어짐
    //activity_main.xml 파일해석하고 보여주는 모든 기능은 MainActivity.java에서 수행한다

    //1-1. onCreate 화면이 생성될때
    //화면에서 사용되는 객체들을 초기화할때 이걸 주로 사용
    //예) 화면이 생성되는거
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //protected가 붙었다해서 특별한 제한사항이 있는건아니다...
        //매개변수인 Bundle savedInstanceState 이건 거의 사용할 일 없음
        super.onCreate(savedInstanceState); //부모에 있는 매소드를 재정의했지만 부모에 있는 onCreate가 반드시 실행이 되야 하기 때문에 호출함

        //activity_main.xml의 내용을 해석해서 넣어야하는데 이렇게
        //R.layout 에서 R은 옆에보면 res를 가르키고 layout은 그안의 layout을 가르킨다 그리고 xml확장 면을 뺀 activity_main을 넣어서
        //R.layout.activity_main 이렇게 입력 처리해서 식별번호 처리를 하도록 해서 넘겨준다 setContentView( 이안에 ) 넘겨준다
        //setContentView은 화면내용을 구성해주는 역할을 수행하는데 activity_main.xml안에 설정된 것들을 객체화하는 것
        setContentView(R.layout.activity_main);

        //즉 이렇게 클래스하나당 xml파일이 연결되어 있다
        /* 클래스 MainActivity 에 기본 생성자가 있지만 그안에 아무것도 없다
         * 대신 화면을 구성하는 모든 코드는 onCreate메소드에 모든 코드가 다들어있어~
         * 그리고 이 onCreate는 어떤 객체가 생성될때 자동으로 실행된다~
         * onCreate는 생성부터 시작해서 자동으로 후출되는 메소드~ 이런 메소드들 객체의 라이프사이클 매소드
         * on : ~~~할때~
         * -> onCreate() 는 화면이 생성될떄~
         * -> onDestroy() 는 화면이 파괴될 때~
         * ... 기타등등
         * 그래서 이런 라이프사이클 메소드를 잘알아서 알맞는 코드를 넣자!
        */
        //System.out.println("라이프사이클 메소드 : 화면이 생성될 떄");
        Log.i("mylog", "라이프사이클 메소드 : 화면이 생성될 떄");

    }

    //1-2. onStart 화면이 생성되고 사용자에게 보여줄 만만의 준비가 되있는 상태에서 실행됨
    //어떤 서비스를 실행할 목적의 소스들을 작성을 많이 함
    //예) 음악을 시작 코드
    @Override
    protected void onStart() {
        super.onStart();
        Log.i("mylog", "onStart()");
    }

    //1-3
    //사용자가 사용할 때 (어떤 화면을 사용할때) 그 때 실행해야할 코드들
    //이상태가 되면 사용자가 사용할 준비가 완전히 끝난거
    @Override
    protected void onResume() {
        super.onResume();
        Log.i("mylog", "onResume()");
    }

    // ======================================================================================================

    //2-1 화면이 없어질때
    //사용자가 당장 화면을 사용할수없는 상태가 되면
    //사용자가 어떤 행위를 했을 떄 잠시 일시적으로 멈춰야할 코드가 있을때
    @Override
    protected void onPause() {
        super.onPause();
        Log.i("mylog", "onPause()");
    }

    //2-2.
    @Override
    protected void onStop() {
        super.onStop();
        Log.i("mylog", "onStop()");
    }

    //2-3.
    //서비스를 중지하고 화면을 파괴해야할 때
    @Override
    protected void onDestroy() {
        super.onDestroy();
        //System.out.println("라이프사이클 메소드 : 화면이 파괴될 떄")
        Log.i("mylog", "onDestroy()");
        Log.i("mylog", "라이프사이클 메소드 : 화면이 파괴될 떄");
    }



    public void onClickBtnSecond(View view){
        Log.i("mylog", "onClickBtnSecond()");
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    public void onClickBtnThird(View view) {
        Log.i("mylog", "onClickBtnThird()");
        Intent intent = new Intent(this, ThirdActivity.class);
        startActivity(intent);

    }

}
