package com.hhzmy.fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hhzmy.R;

public class ContentTwoFragment extends Fragment {

    public static Fragment[] fragments;
    public static TextView[] textViews;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_content_two, container, false);

        getFragment();

        textViews=new TextView[3];
        textViews[0]=(TextView)view.findViewById(R.id.goods_img_content);
        textViews[1]=(TextView)view.findViewById(R.id.goods_parameter_content);
        textViews[2]=(TextView)view.findViewById(R.id.goods_aftersele_content);
        textViews[0].setTextColor(Color.BLUE);

        textViews[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textViews[0].setTextColor(Color.BLUE);
                textViews[1].setTextColor(Color.BLACK);
                textViews[2].setTextColor(Color.BLACK);
                getChildFragmentManager().beginTransaction().hide(fragments[1]).hide(fragments[2]).show(fragments[0]).commit();
            }
        });

        textViews[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textViews[0].setTextColor(Color.BLACK);
                textViews[1].setTextColor(Color.BLUE);
                textViews[2].setTextColor(Color.BLACK);
                getChildFragmentManager().beginTransaction().hide(fragments[0]).hide(fragments[2]).show(fragments[1]).commit();
            }
        });

        textViews[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViews[0].setTextColor(Color.BLACK);
                textViews[1].setTextColor(Color.BLACK);
                textViews[2].setTextColor(Color.BLUE);
                getChildFragmentManager().beginTransaction().hide(fragments[0]).hide(fragments[1]).show(fragments[2]).commit();
            }
        });
        return view;
    }

    private void getFragment() {
        //得到Fragment
        fragments=new Fragment[3];
        fragments[0]=getChildFragmentManager().findFragmentById(R.id.goods_img_content_fr);
        fragments[1]=getChildFragmentManager().findFragmentById(R.id.goods_parameter_content_fr);
        fragments[2]=getChildFragmentManager().findFragmentById(R.id.goods_aftersele_content_fr);

        //显示第一个fragment
        getChildFragmentManager().beginTransaction().hide(fragments[1]).hide(fragments[2]).show(fragments[0]).commit();
    }

}
