package com.bwie.countzero;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mGetCodeBtn;// 倒计时按钮  
    private Intent mIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        initView();
    }

    /**
     * 初始化视图
     */
    private void initView() {
        //得到按钮
        mGetCodeBtn= (Button) findViewById(R.id.get_code_btn);
        //
        RegisterCodeTimerService.setHandler(mCodeHandler);

        mIntent=new Intent(MainActivity.this,RegisterCodeTimerService.class);
        //设置监听
        mGetCodeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mGetCodeBtn.setEnabled(false);
                startService(mIntent);
            }
        });
    }
    /*
     倒计时Handler
     */
    Handler mCodeHandler = new Handler() {
        public void handleMessage(Message msg) {
            if (msg.what == RegisterCodeTimer.IN_RUNNING) {// 正在倒计时
                mGetCodeBtn.setText(msg.obj.toString());
            } else if (msg.what == RegisterCodeTimer.END_RUNNING) {// 完成倒计时
                mGetCodeBtn.setEnabled(true);
                mGetCodeBtn.setText(msg.obj.toString());
            }
        }
    };
    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        stopService(mIntent);
    }
}
