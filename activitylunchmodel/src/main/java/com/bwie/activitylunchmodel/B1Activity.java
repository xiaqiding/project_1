package com.bwie.activitylunchmodel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class B1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b1);
        TextView tv_text = (TextView) findViewById(R.id.tv_text);
        tv_text.setText(this.toString());

        Button btn_goB1 = (Button) findViewById(R.id.btn_goB1);

        btn_goB1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(B1Activity.this, B1Activity.class);
                startActivity(intent);
            }
        });

        Button btn_goB2 = (Button) findViewById(R.id.btn_goB2);
        btn_goB2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(B1Activity.this, B2Activity.class);
                startActivity(intent);
            }
        });
    }
}
