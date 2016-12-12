package com.bwie.eventdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.bwie.eventdemo.events.FirstEvent;
import com.bwie.eventdemo.events.SecondEvent;
import com.bwie.eventdemo.events.ThirdEvent;

import de.greenrobot.event.EventBus;

public class MainActivity extends AppCompatActivity {

    private Button btn;
    private TextView tv;
    private EventBus eventBus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EventBus.getDefault().register(this);

        btn = (Button) findViewById(R.id.btn_try);

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(getApplicationContext(),
                        SecondActivity.class);
                startActivity(intent);
            }
        });
    }

    public void onEventMainThread(FirstEvent event) {

        Log.d("events", "onEventMainThread收到了消息：" + event.getMsg());
    }

    //SecondEvent接收函数一
    public void onEventMainThread(SecondEvent event) {

        Log.d("events", "onEventMainThread收到了消息：" + event.getMsg());
    }
    //SecondEvent接收函数二
    public void onEventBackgroundThread(SecondEvent event){
        Log.d("events", "onEventBackground收到了消息：" + event.getMsg());
    }
    //SecondEvent接收函数三
    public void onEventAsync(SecondEvent event){
        Log.d("events", "onEventAsync收到了消息：" + event.getMsg());
    }

    public void onEvent(ThirdEvent event) {
        Log.d("events", "OnEvent收到了消息：" + event.getMsg());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}