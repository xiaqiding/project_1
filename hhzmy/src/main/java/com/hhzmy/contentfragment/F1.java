package com.hhzmy.contentfragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hhzmy.R;
import com.hhzmy.activity.MapActivity;


/**
 * Created by huanhuan on 2016/11/16.
 */
public class F1 extends Fragment {
    private ViewPager vp1;
    private TextView tvtime1;
    private TextView tvtime2;
    private TextView tvtime3;
    private  long  time=400;
    private ImageView ditu;

    private TextView address;
    private String dizhi;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v1=inflater.inflate(R.layout.f1,null);



        tvtime1=(TextView)v1.findViewById(R.id.tvtime1);
        tvtime2=(TextView)v1. findViewById(R.id.tvtime2);
        tvtime3=(TextView)v1. findViewById(R.id.tvtime3);
        ditu=(ImageView)v1.findViewById(R.id.ditu_img);
        ditu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), MapActivity.class);
                startActivity(intent);
            }
        });
        address=(TextView)v1.findViewById(R.id.address);

        Intent intent1=getActivity().getIntent();


        if(intent1.hasExtra("heheda")){
            Bundle bundle=intent1.getExtras();
            dizhi=bundle.getString("heheda");
            address.setText(dizhi);
        }else {
            address.setText("山西省长治市襄垣县");
        }







        handler.postDelayed(runnable, 1000);

        return v1;
    }
    Handler handler = new Handler();
    Runnable runnable = new Runnable() {


        @Override
        public void run() {
            time--;
            String formatLongToTimeStr = formatLongToTimeStr(time);
            String[] split = formatLongToTimeStr.split("：");
            for (int i = 0; i < split.length; i++) {
                if(i==0){
                    tvtime1.setText(split[0]+"小时");
                }
                if(i==1){
                    tvtime2.setText(split[1]+"分钟");
                }
                if(i==2){
                    tvtime3.setText(split[2]+"秒");
                }

            }
            if(time>0){
                handler.postDelayed(this, 1000);
            }
        }
    };

    public  String formatLongToTimeStr(Long l) {
        int hour = 0;
        int minute = 0;
        int second = 0;
        second = l.intValue() ;
        if (second > 60) {
            minute = second / 60;         //取整   
            second = second % 60;         //取余
        }

        if (minute > 60) {
            hour = minute / 60;
            minute = minute % 60;
        }
        String strtime = hour+"："+minute+"："+second;
        return strtime;

    }
}
