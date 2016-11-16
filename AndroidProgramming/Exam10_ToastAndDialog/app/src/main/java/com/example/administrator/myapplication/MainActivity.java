package com.example.administrator.myapplication;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickShowToast(View view){
        ////////////////////
        //토스트 띄우기
        ////////////////////
        //매소드 체인지 : 이걸 먼저 호출하고 이거 리턴 객체의 show()를 호출한다
        Toast
             .makeText(this, "나는 토스트입니다", Toast.LENGTH_SHORT) //<- 이거할 때 쥐의사항 세미콜롬(;)을 여기서 쓰면 안됨
                .show();
        /* 메소드 체인지로 실행한건 이거와 똑같은 코드
        Toast toast = Toast.makeText(this, "나는 토스트입니다", Toast.LENGTH_SHORT);
        toast.show(); */

    }
    public void onClickShowMessageDialog(View view){
        ////////////////////
        //메시지 다이얼로그 띄우기
        ////////////////////
        //메소드 체인지
        new AlertDialog.Builder(this)
                .setIcon(R.mipmap.ic_launcher)
                    .setTitle("알림")
                        .setMessage("오늘은 수요일일입니다\n안녕하세요")
                            .setPositiveButton("확인", null)
                                .show();

    }

    public void onClickShowYesNoDialog(View view) {
        ////////////////////
        //물어보는 메시지 다이얼로그 띄우기
        ////////////////////
        //메소드 체인지
        new AlertDialog.Builder(this)
                .setIcon(R.mipmap.ic_launcher)
                    .setTitle("알림")
                        .setMessage("종료하시겠습니까?")
                            .setPositiveButton("아니오", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Toast
                                        .makeText(MainActivity.this, "아니오 선택", Toast.LENGTH_SHORT)
                                            .show();
                                }
                            })
                                .setNegativeButton("예", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Toast
                                            .makeText(MainActivity.this, "예 선택", Toast.LENGTH_SHORT)
                                                .show();
                                    }
                                })
                                    .show();
    }

    public void onClickShowCustomDialog(View view){
        ////////////////////
        //커스텀 다이얼로그 띄우기
        ////////////////////
        //메소드 체인지
        View content = getLayoutInflater().inflate(R.layout.light_dialog, null);
        Button btnOk = (Button) content.findViewById(R.id.btnOk);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast
                    .makeText(MainActivity.this, "확인일 선택", Toast.LENGTH_SHORT)
                        .show();
            }
        });
        new AlertDialog.Builder(this)
                .setIcon(R.mipmap.ic_launcher)
                    .setTitle("알림")
                        .setView(content)
                            .show();

    }

}
