package com.bwie.myfragment;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;


public class MainActivity extends FragmentActivity {

    private Button btn1;
    private Button btn2;
    private Button btn3;
    private FragmentManager fragmentManager;
    private ExampleFragment Efragment;
    private NewFragment Nfragment;
    private Button btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findView();

        setListeners();

        //获得管理类对象
        fragmentManager = getSupportFragmentManager();
    }

    private void findView() {
        btn1 =(Button)findViewById(R.id.btn1);
        btn2 =(Button)findViewById(R.id.btn2);
        btn3 =(Button)findViewById(R.id.btn3);
        btn4 =(Button)findViewById(R.id.btn4);
    }

    //设置监听
    private void setListeners() {
        //第一个按钮，增加一个ExampleFragment
        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //加入ExampleFragment
                Efragment = new ExampleFragment();
                //开启事务
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                //添加碎片
                fragmentTransaction.add(R.id.activity_main,Efragment);
                //退回任务栈（一般不用）
                fragmentTransaction.addToBackStack(null);
                //提交
                fragmentTransaction.commit();
            }
        });
        //第二个按钮，用一个NewFragment替换前面增加的那个fragment
        btn2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Nfragment = new NewFragment();
                //开启事务
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                //替换
                fragmentTransaction.replace(R.id.activity_main,Nfragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        //第三个按钮，移除fragment
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.remove(Nfragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        //第四个按钮，隐藏fragment
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.hide(Nfragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
    }

}
