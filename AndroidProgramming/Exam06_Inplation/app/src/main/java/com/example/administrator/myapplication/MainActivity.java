package com.example.administrator.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private LinearLayout itemContainer;
    private LayoutInflater layoutInflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemContainer = (LinearLayout)findViewById(R.id.itemContainer);
        layoutInflater = getLayoutInflater();

        fillItems();
    }

    public void fillItems(){
        int[] arrImage = {
                R.drawable.light1,
                R.drawable.light2,
                R.drawable.light3,
                R.drawable.light4,
                R.drawable.light5
        };
        String[] arrTitle = {
                "인테리어 조명1",
                "인테리어 조명2",
                "인테리어 조명3",
                "인테리어 조명4",
                "인테리어 조명5"
        };
        String[] arrContent = {
                "거실등으로 사용하자",
                "욕실등으로 사용하자",
                "자녀방등으로 사용하자",
                "현관등으로 사용하자",
                "외부등으로 사용하자"
        };

        for(int i=0; i<5; i++) {
            //1. 인플레이션(Inplation) xml파일 내용을 객체화
            LinearLayout itemLayout = (LinearLayout) layoutInflater.inflate(R.layout.light_item, null); //객체화시키는것
            //itemLayout 에 저장되는 내용은 뷰그룹임~

            //2. 인플레이션한 객체에 데이타 셋팅(Data Setting)
            ImageView liteImage = (ImageView) itemLayout.findViewById(R.id.lightImage);
            liteImage.setImageResource(arrImage[i]);
            TextView liteTitle = (TextView) itemLayout.findViewById(R.id.lightTitle);
            liteTitle.setText(arrTitle[i]);
            TextView liteContent = (TextView) itemLayout.findViewById(R.id.lightContent);
            liteContent.setText(arrContent[i]);

            //3. intemContainer의 내부 객체로 추가
            itemContainer.addView(itemLayout);
        }


    }

}
