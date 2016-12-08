package com.bwie.myservice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("Log", "Thread ID: " + Thread.currentThread().getId());

        Log.i("Log", "before test startService");

        //启动service
        Intent intent_1=new Intent(this,TestService.class);
        startService(intent_1);

        Intent intent_2=new Intent(this,TestService.class);
        startService(intent_2);

        Intent intent_3=new Intent(this,TestService.class);
        startService(intent_3);

        //停止service
        Intent intent_4=new Intent(this,TestService.class);
        stopService(intent_4);

        //再次启动service
        Intent intent_5 = new Intent(this, TestService.class);
        startService(intent_5);

        Log.i("Log", "after test startService");
    }
}
