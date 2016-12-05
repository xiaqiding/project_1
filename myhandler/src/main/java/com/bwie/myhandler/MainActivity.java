package com.bwie.myhandler;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
/**
 * autour: 夏奇顶
 * date: 2016-12-02 20:35
 * update: 2016-12-02
 */


public class MainActivity extends AppCompatActivity {

    private ProgressBar progress_bar = null;
    private Button start = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progress_bar = (ProgressBar) findViewById(R.id.progress_bar);
        start = (Button) findViewById(R.id.start);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //让进度条显示出来
                progress_bar.setVisibility(View.VISIBLE);
                //将线程加入到handler的线程队列中
                update_progress_bar.post(update_thread);
            }
        });
    }

    Handler update_progress_bar=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            //super.handleMessage(msg);
            //显示进度条
            progress_bar.setProgress(msg.arg1);
            //重新把进程加入到进程队列中
            update_progress_bar.post(update_thread);
        }
    };

    Runnable update_thread=new Runnable() {
        int i=0;
        @Override
        public void run() {
            i+=10;
            //获得消息
            Message msg=update_progress_bar.obtainMessage();
            //给arg1参数赋值
            msg.arg1=i;
            try {
                //设置延时
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //把消息发送到消息队列中
            update_progress_bar.sendMessage(msg);
            if (i==200){
                //把线程从线程队列中移除
                update_progress_bar.removeCallbacks(update_thread);
            }
        }
    };
}
