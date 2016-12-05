package com.hhzmy.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.hhzmy.R;

public class PassWordActivity extends AppCompatActivity {

    private RadioButton choss;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pass_word);
        //返回
        ImageView iv_back_passw= (ImageView) findViewById(R.id.iv_back_passw);
        iv_back_passw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });



        //用来接收手机号
        TextView mess= (TextView) findViewById(R.id.mess);
        mess.setText("短信验证码已经发送至");
        //验证码
        EditText yzm_et= (EditText) findViewById(R.id.yzm_et);
        String yzMa=yzm_et.getText().toString().trim();
        //秒数
        TextView seconds= (TextView) findViewById(R.id.seconds);
        seconds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        choss = (RadioButton) findViewById(R.id.choss);
        choss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //choss.setBackgroundResource(R.mipmap.icon_hidden);
            }
        });


        //密码
        EditText pass_et= (EditText) findViewById(R.id.pass_et);
        String pass_wors=pass_et.getText().toString().trim();
        //提交
        Button commit= (Button) findViewById(R.id.commit);
        commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




                Toast.makeText(PassWordActivity.this,"提交",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
