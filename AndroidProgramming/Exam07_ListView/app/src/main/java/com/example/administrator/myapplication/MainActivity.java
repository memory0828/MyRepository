package com.example.administrator.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView lightList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lightList = (ListView)findViewById(R.id.lightList);
        fillItems();
    }

    public void fillItems(){

        List<Light> list = new ArrayList<>();
        list.add(new Light(R.drawable.light1, "인테리어 조명1", "거실등으로 사용하자"));
        list.add(new Light(R.drawable.light2, "인테리어 조명2", "거실등으로 사용하자"));
        list.add(new Light(R.drawable.light3, "인테리어 조명3", "거실등으로 사용하자"));
        list.add(new Light(R.drawable.light4, "인테리어 조명4", "거실등으로 사용하자"));
        list.add(new Light(R.drawable.light5, "인테리어 조명5", "거실등으로 사용하자"));
        list.add(new Light(R.drawable.light1, "인테리어 조명1", "거실등으로 사용하자"));
        list.add(new Light(R.drawable.light2, "인테리어 조명2", "거실등으로 사용하자"));
        list.add(new Light(R.drawable.light3, "인테리어 조명3", "거실등으로 사용하자"));
        list.add(new Light(R.drawable.light4, "인테리어 조명4", "거실등으로 사용하자"));
        list.add(new Light(R.drawable.light5, "인테리어 조명5", "거실등으로 사용하자"));


        LightAdapter lightAdapter = new LightAdapter(this); //this는 매인액티비티 객체임
        lightAdapter.setList(list);

        lightList.setAdapter(lightAdapter);

    }

}
