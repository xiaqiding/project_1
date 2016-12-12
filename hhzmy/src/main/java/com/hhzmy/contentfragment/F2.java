package com.hhzmy.contentfragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hhzmy.R;


/**
 * Created by huanhuan on 2016/11/16.
 */
public class F2 extends Fragment {


    public static Fragment[] fragments;
    public static TextView[] textViews;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v2 = inflater.inflate(R.layout.f2, container, false);
        getFragment();
        textViews = new TextView[3];
        textViews[0] = (TextView) v2.findViewById(R.id.tuwen);
        textViews[1] = (TextView) v2.findViewById(R.id.canshu);
        textViews[2] = (TextView) v2.findViewById(R.id.baochuang);
        textViews[0].setTextColor(Color.BLUE);

//foot点击事件
        textViews[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViews[0].setTextColor(Color.BLUE);
                textViews[1].setTextColor(Color.BLACK);
                textViews[2].setTextColor(Color.BLACK);
                getChildFragmentManager().beginTransaction().hide(fragments[1]).hide(fragments[2])
                        .show(fragments[0]).commit();
            }
        });
        textViews[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViews[0].setTextColor(Color.BLACK);
                textViews[1].setTextColor(Color.BLUE);
                textViews[2].setTextColor(Color.BLACK);
                getChildFragmentManager().beginTransaction().hide(fragments[0]).hide(fragments[2])
                        .show(fragments[1]).commit();
            }
        });
        textViews[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViews[0].setTextColor(Color.BLACK);
                textViews[1].setTextColor(Color.BLACK);
                textViews[2].setTextColor(Color.BLUE);
                getChildFragmentManager().beginTransaction().hide(fragments[0]).hide(fragments[1])
                        .show(fragments[2]).commit();
            }
        });

        return v2;
    }

    private void getFragment() {

        //得到Fragment
        fragments = new Fragment[3];
        fragments[0] = getChildFragmentManager().findFragmentById(R.id.one_xq);
        fragments[1] = getChildFragmentManager().findFragmentById(R.id.two_xq);
        fragments[2] = getChildFragmentManager().findFragmentById(R.id.three_xq);
        //显示第一个Fragment
        getChildFragmentManager().beginTransaction().hide(fragments[1]).hide(fragments[2])
                .show(fragments[0]).commit();
    }
}
