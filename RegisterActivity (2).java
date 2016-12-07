package com.hhzmy.third;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hhzmy.main.R;

/**
 * 注册页面
 * */
public class RegisterActivity extends AppCompatActivity {

    private EditText input_phone;
    private ImageView img_back;
    private Button btn_next;
    private String phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        img_back = (ImageView) findViewById(R.id.regieter_back);
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        //手机号空格
        //input_phone.addTextChangedListener(new PhoneTextWatcher(input_phone));
        //判断手机号
        if (phone ==null){
            Toast.makeText(RegisterActivity.this,"手机号不为空",Toast.LENGTH_SHORT).show();
        }else if(phone.length()<=11&& phone.length()>0){
            Toast.makeText(RegisterActivity.this,"手机号为11位数",Toast.LENGTH_SHORT).show();
        }

        //手机号取消
        final ImageView phone_cancel= (ImageView) findViewById(R.id.phoneNum_clear);
        phone_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //清空
                input_phone.getText().clear();
            }
        });
        //选择框
       CheckBox box= (CheckBox) findViewById(R.id.register_box);
        box.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

            }
        });

        TextView content= (TextView) findViewById(R.id.tv_content);
        String text=content.getText().toString().trim();
        //图文混排
        SpannableStringBuilder ssb=new SpannableStringBuilder(text);
        //加颜色
        ssb.setSpan(new ForegroundColorSpan(Color.parseColor("#f7f006")),2,9,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        //下划线
        ssb.setSpan(new UnderlineSpan(), 2, 9,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //下划线
        ssb.setSpan(new UnderlineSpan(), 11, 15,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //加颜色
        ssb.setSpan(new ForegroundColorSpan(Color.parseColor("#f7f006")),11,15,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        content.setText(ssb);
        //下一步
        btn_next = (Button) findViewById(R.id.register_next);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this,PaswActivity.class));

                //手机号
                input_phone = (EditText) findViewById(R.id.register_inputNum);
                phone = input_phone.getText().toString().trim();


                cn.smssdk.SMSSDK.initSDK(RegisterActivity.this, "19a1dfb34900e", "afd2cd716a3c44ea4d16010f8df066f9");
                cn.smssdk.SMSSDK.getVerificationCode("86", phone);

                Log.d("??????????", phone);


            }
        });

    }
}
