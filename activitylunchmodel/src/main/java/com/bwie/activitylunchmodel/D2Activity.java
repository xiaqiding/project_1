package com.bwie.activitylunchmodel;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * 作用:
 * 作者:
 * 时间:
 */

public class D2Activity extends AppCompatActivity {

    TextView tv_text;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d1);

        tv_text = (TextView) findViewById(R.id.tv_text);
        tv_text.setText(this.toString() + "  taskId: " + getTaskId());

        Button btn_goD1 = (Button) findViewById(R.id.btn_goD1);
        btn_goD1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(D2Activity.this, D1Activity.class);
                startActivity(intent);
            }
        });
        Button btn_goD2 = (Button) findViewById(R.id.btn_goD2);
        btn_goD2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(D2Activity.this, D2Activity.class);
                startActivity(intent);
            }
        });
        Button btn_goD3 = (Button) findViewById(R.id.btn_goD3);
        btn_goD3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(D2Activity.this, D3Activity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("D2 call onDestory()");
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        tv_text.setText(this.toString() + "  taskId: " + getTaskId() + "\n" + "onNewIntent() called");
    }

}
