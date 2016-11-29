package com.bwie.fragmentalive;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = getSupportFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();

        OneFragment oneFragment=new OneFragment();
        Bundle bundle_1=new Bundle();
        bundle_1.putString("as","Activity发送给OneFragment的数据");
        oneFragment.setArguments(bundle_1);
        transaction.replace(R.id.left,oneFragment,"left");

        TwoFragment twoFragment=new TwoFragment();
        Bundle bundle_2=new Bundle();
        bundle_2.putString("as","Activity发送给TwoFragment的数据");
        twoFragment.setArguments(bundle_2);
        transaction.replace(R.id.right,twoFragment,"right");

        transaction.commit();
    }
}
