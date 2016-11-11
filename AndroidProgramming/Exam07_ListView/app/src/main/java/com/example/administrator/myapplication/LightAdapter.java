package com.example.administrator.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class LightAdapter extends BaseAdapter { //BaseAdapter는 추상메소다가 있는 추상 클래스
    private List<Light> list;

    public void setList(List<Light> list) {
        //데이터 세터주입~(데이터를 외부에서 받겠다~~~)
        this.list = list;
    }

    @Override
    public int getCount(){
        //항목수가 몇개인지 리턴
        return list.size();
    }

    @Override
    public Object getItem(int position)
    {
        //int position인 위치에 해당하는 데이터를 리턴해라 (= 배열인덱스 )
        return list.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        //int position인 인덱스 위치에 있는 데이터의 식별번호가 무엇이냐~
        //다른 것들과 식별한수있는 고유번호!
        //고유아이디가있는 데이터( 예) 게시판의 bno )와 아이디가 없는 데이터가 있을수있는데,
        //여기선 다른 것들과 식별할 수 있는 데이터가 없기때문에, 그냥 인덱스값으로 처리 즉
        //int position인 인덱스값이 고유식별번호로 생각하고 이걸리턴하자!

        return position;
    }



    // ==== public View getView(int position, View convertView, ViewGroup parent) 이 메소드 기능 구현을 위한 것들 =======
    // ■ light_item.xml에 있는 걸 객체화 시키기(인플레이션) 위해서 필요한 요소들

    //private MainActivity mainActivity;  //아래 layoutInflater을 위한것 방법1의 것
    private Context context;            //아래 layoutInflater을 위한것 방법2의 것
    private LayoutInflater layoutInflater;  //public View getView(..)에서 사용할것

    //방법1. 이건 메인 엑티비티에서만 쓸수있는 방법( ... 범용성이 없다)
    /*
    public LightAdapter(MainActivity mainActivity){
        this.mainActivity = mainActivity;
        layoutInflater = this.mainActivity.getLayoutInflater();
    }
    */
    //방법2. 이건 모든 엑티비티에서 다 쓸수 있는 방법
    public LightAdapter(Context context){
        //Context는 화면을 구성하기위한 여러가지 정보를 가지고 있는 객체(화면 자체는 액티비티인데, 그 화면이 만들어지기위해서 다양한 정보를 가진 객체)
        //Context는 매인액티비티의 부모임~
        //생성자로 주입받음
        this.context = context;
        layoutInflater = LayoutInflater.from(context); //이렇게 살짝 방법바꿔서 얻게됨
    }

    // =================================================================================================================== //

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        //light_item.xml에 있는 것을 인플레이션해서 Light 데이터를 셋팅하고 리턴해주는 메소드
        //View convertView : light_item.xml를 가지로 인플레이션 한거, 최초 처음 인플레이션을 만드는 동안에는 null이 들어오고, 추후 재사용할게 발생하면 그 인플레이션한게 들어옴
        //ViewGroup parent : 대상이 되는 리스트뷰

        //■ 재사용할수있는 객체가 들어오면 인플레이션을 할 필요없고
        //   null이들어오면 처음 생성단계니깐 인플레이션으로 만들어서 써야함

        //즉, null이 들어오면 처음 생선단계니깐 인플레이션을 해야하는 상태인거고
        //    null이 아니면 값이 들어왔다는거는 재사용할게 있다는 거니 바로 데이터 셋팅으로 들어가면 됨
        if(convertView == null){
            //inplation 인플레이션
            convertView = layoutInflater.inflate(R.layout.light_item, null); //인플레이션
        }

        //데이터 셋팅 data setting
        Light light = list.get(position); //데이터
        ImageView lightImage = (ImageView) convertView.findViewById(R.id.lightImage);
        lightImage.setImageResource(light.getImage());

        TextView lightTitle = (TextView) convertView.findViewById(R.id.lightTitle);
        lightTitle.setText(light.getTitle());

        TextView lightContent = (TextView) convertView.findViewById(R.id.lightContent);
        lightContent.setText(light.getContent());

        return convertView;
    }
}
