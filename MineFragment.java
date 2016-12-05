package com.hhzmy.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hhzmy.R;
import com.hhzmy.activity.RegisterActivity;

import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MineFragment extends Fragment {

    private Button btn_login=null;
    private Button btn_register;
    private EditText edit_phoneNum=null;
    private TextWatcher phoneTextWatcher;
    private String phoneNumber=null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_mine, container, false);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //手机号输入框
        edit_phoneNum = (EditText) getView().findViewById(R.id.mine_inputNum);
        //登录按钮   页面跳转
        btn_login = (Button) getView().findViewById(R.id.mine_login);
        btn_login.setEnabled(false); //设置按钮不可按
        //注册按钮  页面跳转
        btn_register = (Button) getView().findViewById(R.id.mine_register);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), RegisterActivity.class));
            }
        });

        //判断手机号是否正确
        phoneTextWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                phoneNumber=edit_phoneNum.getText().toString();
                if (isPhoneNumberValib(phoneNumber)==true){
                    btn_login.setEnabled(true);
                }else{
                    btn_login.setEnabled(false);
                    Toast.makeText(getActivity(),"手机号有误，重新输入",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };
        edit_phoneNum.addTextChangedListener(phoneTextWatcher);
    }
    /**
     * 检查字符串是否为电话号码的方法,并返回true or false的判断值
     */
    public static boolean isPhoneNumberValib(String phoneNumber){
        boolean isValib=false;
        /** 可接受的电话格式有:
         * ^//(? : 可以使用 "(" 作为开头
         * (//d{3}): 紧接着三个数字
         * //)? : 可以使用")"接续
         * [- ]? : 在上述格式后可以使用具选择性的 "-".
         * (//d{3}) : 再紧接着三个数字
         * [- ]? : 可以使用具选择性的 "-" 接续.
         * (//d{5})$: 以五个数字结束.
         * 可以比较下列数字格式:
         * (123)456-7890, 123-456-7890, 1234567890, (123)-456-7890
         * ^//(?(//d{3})//)?[- ]?(//d{3})[- ]?(//d{5})$
         */
        String expression="^//(?(//d{3})//)?[- ]?(//d{3})[- ]?(//d{5})$";

        /** 可接受的电话格式有:
         * ^//(? : 可以使用 "(" 作为开头
         * (//d{3}): 紧接着三个数字
         * //)? : 可以使用")"接续
         * [- ]? : 在上述格式后可以使用具选择性的 "-".
         * (//d{4}) : 再紧接着四个数字
         * [- ]? : 可以使用具选择性的 "-" 接续.
         * (//d{4})$: 以四个数字结束.
         * 可以比较下列数字格式:
         * (02)3456-7890, 02-3456-7890, 0234567890, (02)-3456-7890
         */
        String expression2 = "^//(?(//d{3})//)?[- ]?(//d{4})[- ]?(//d{4})$";

        CharSequence inputstr=phoneNumber;
        /*创建Pattern*/
        Pattern pattern=Pattern.compile(expression);
         /*将Pattern 以参数传入Matcher作Regular expression*/
        Matcher matcher=pattern.matcher(inputstr);
         /*创建Pattern2*/
        Pattern pattern2 = Pattern.compile(expression2);
        /*将Pattern2 以参数传入Matcher2作Regular expression*/
        Matcher matcher2 = pattern2.matcher(inputstr);
        if (matcher.matches()){
            isValib=true;
        }
        return isValib;
    }
}
