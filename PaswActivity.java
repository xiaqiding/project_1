package com.hhzmy.third;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hhzmy.main.R;

public class PaswActivity extends AppCompatActivity {

    private CheckBox choss;
    private String pass_wors;
    private EditText pass_et;
    private ImageView img_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pasw);
        //返回
        img_back = (ImageView) findViewById(R.id.pasw_back);
        img_back.setOnClickListener(new View.OnClickListener() {
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
        //密码
        pass_et = (EditText) findViewById(R.id.pass_et);
        pass_wors = pass_et.getText().toString().trim();

        choss = (CheckBox) findViewById(R.id.choss);
        choss.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    //如果选中，显示密码
                    pass_et.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    //否则隐藏密码
                    pass_et.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });




        //提交
        Button commit= (Button) findViewById(R.id.commit);
        commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PaswActivity.this,"提交",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
