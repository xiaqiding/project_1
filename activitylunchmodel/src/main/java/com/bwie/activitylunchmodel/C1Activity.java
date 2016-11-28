package com.bwie.activitylunchmodel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class C1Activity extends AppCompatActivity {

    TextView tv_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c1);

        tv_text = (TextView) findViewById(R.id.tv_text);
        tv_text.setText(this.toString() + "  taskId: " + getTaskId());

        Button btn_goC1 = (Button) findViewById(R.id.btn_goC1);
        btn_goC1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(C1Activity.this, C1Activity.class);
                startActivity(intent);
            }
        });
        Button btn_goC2 = (Button) findViewById(R.id.btn_goC2);
        btn_goC2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(C1Activity.this, C2Activity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("C1 call onDestory()");
    }

}
