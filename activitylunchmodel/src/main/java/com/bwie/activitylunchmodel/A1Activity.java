package com.bwie.activitylunchmodel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class A1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a1);

        TextView tv_text = (TextView) findViewById(R.id.tv_text);
        tv_text.setText(this.toString());

        Button btn_goA1 = (Button) findViewById(R.id.btn_goA1);

        btn_goA1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(A1Activity.this, A1Activity.class);
                startActivity(intent);
            }
        });
    }
}
