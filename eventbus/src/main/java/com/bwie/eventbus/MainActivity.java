package com.bwie.eventbus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import de.greenrobot.event.EventBus;

public class MainActivity extends AppCompatActivity {

    private TextView news;
    private Button jump;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //注册
        EventBus.getDefault().register(this);

        //得到控件
        news = (TextView) findViewById(R.id.mian_news);
        jump = (Button) findViewById(R.id.main_jump);
        //跳转
        jump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,JumpActivity.class));
            }
        });
    }
    public void onEventMainThread(Events event) {
        String msg = "onEventMainThread收到了消息：" + event.getMsg();
        news.setText(msg);
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
    //销毁
    @Override
    protected void onDestroy() {
        super.onDestroy();
        //反注册
        EventBus.getDefault().unregister(this);
    }
}
