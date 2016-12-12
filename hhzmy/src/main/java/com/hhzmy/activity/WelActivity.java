package com.hhzmy.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.hhzmy.R;

import java.util.ArrayList;

public class WelActivity extends AppCompatActivity {

    private boolean flag;
    private ArrayList<View> viewList;
    private ArrayList<View> dotList;
    private ViewPager wel_vp;
    private int oldPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wel);

        SharedPreferences sp=getSharedPreferences("xxx", Context.MODE_PRIVATE);
        flag = sp.getBoolean("xxx",false);
        //进行判断
        if (flag){
            startActivity(new Intent(WelActivity.this,MainActivity.class));
            finish();
            return;
        }
        //初始数据
        initData();
        initView();
    }
    private void initData() {
        //页面数据集合
        viewList = new ArrayList<View>();
        //添加数据
        viewList.add(View.inflate(this, R.layout.wel_vp1, null));
        viewList.add(View.inflate(this, R.layout.wel_vp2, null));
        View view=View.inflate(this, R.layout.wel_vp3,null);
        //设置跳转监听
        view.findViewById(R.id.start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sp=getSharedPreferences("xxx", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=sp.edit();
                editor.putBoolean("xxx",true);
                editor.commit();

                startActivity(new Intent(WelActivity.this,MainActivity.class));
                finish();
            }
        });
        viewList.add(view);
        //圆点数据集合
        dotList =new ArrayList<View>();
        //添加圆点数据
        dotList.add(findViewById(R.id.wel_dot1));
        dotList.add(findViewById(R.id.wel_dot2));
        dotList.add(findViewById(R.id.wel_dot3));
    }

    private void initView() {
        //得到控件
        wel_vp =(ViewPager)findViewById(R.id.wel_vp);
        //设置适配器
        wel_vp.setAdapter(new WelPagerAdapter());
        //设置监听
        wel_vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                dotList.get(position).setBackgroundResource(R.drawable.dot_focus);
                dotList.get(oldPosition).setBackgroundResource(R.drawable.dot_normal);

                oldPosition=position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    class WelPagerAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return viewList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(viewList.get(position));
            return viewList.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(viewList.get(position));
        }
    }
}
