package com.example.administrator.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private LinearLayout itemContainer;
    private LayoutInflater layoutInflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        itemContainer = (LinearLayout)findViewById(R.id.itemContainer);
        layoutInflater = getLayoutInflater();

        fillItems();

    }

    public void fillItems(){
        int[] arrImage = {
                R.drawable.food01,
                R.drawable.food02,
                R.drawable.food03,
                R.drawable.food04,
                R.drawable.food05
        };
        String[] arrPirce = {
                "30,000 Won",
                "50,000 Won",
                "20,000 Won",
                "10,000 Won",
                "30,000 Won",
        };
        String[] arrTitle = {
                "맛있는 음식1",
                "맛있는 음식2",
                "맛있는 음식3",
                "맛있는 음식4",
                "맛있는 음식5"
        };
        String[] arrContent = {
                "간식으로 사용하자",
                "외식등으로 사용하자",
                "저녁으로 사용하자",
                "점심으로 사용하자",
                "아침으로 사용하자"
        };

        for(int i=0; i<5; i++) {
            //1. 인플레이션(Inplation) xml파일 내용을 객체화
            LinearLayout itemLayout = (LinearLayout) layoutInflater.inflate(R.layout.food_item,null);
            //itemLayout 에 저장되는 내용은 뷰그룹임~

            //2. 인플레이션한 객체에 데이타 셋팅(Data Setting)
            ImageView foodImage = (ImageView) itemLayout.findViewById(R.id.foodImage);
            foodImage.setImageResource(arrImage[i]);

            TextView foodTitle = (TextView) itemLayout.findViewById(R.id.foodTitle);
            foodTitle.setText(arrTitle[i]);
            TextView foodPrice = (TextView) itemLayout.findViewById(R.id.foodPrice);
            foodPrice.setText(arrPirce[i]);
            TextView foodContent = (TextView) itemLayout.findViewById(R.id.foodContent);
            foodContent.setText(arrContent[i]);

            //3. intemContainer의 내부 객체로 추가
            itemContainer.addView(itemLayout);
        }
    }
}
