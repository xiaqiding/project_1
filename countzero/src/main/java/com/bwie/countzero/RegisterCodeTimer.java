package com.bwie.countzero;

import android.os.CountDownTimer;
import android.os.Handler;

/**
 * Created by Administrator on 2016-12-08.
 *  注册验证码计时器
 */
public class RegisterCodeTimer extends CountDownTimer{

    private static Handler mHandler;
    public static final int IN_RUNNING = 1001;
    public static int END_RUNNING = 1002;

    /**
     millisInFuture // 倒计时的时长
     countDownInterval // 间隔时间
     handler // 通知进度的Handler
     */

    public RegisterCodeTimer(long millisInFuture, long countDownInterval, Handler handler) {
        super(millisInFuture, countDownInterval);
        mHandler=handler;
    }

    //onTick(Long millisUntilFinished)中的代码是你倒计时开始时要做的事情，
    // 参数millisUntilFinished是完成的时间。
    @Override
    public void onTick(long l) {
        if (mHandler!=null){
            mHandler.obtainMessage(IN_RUNNING, (l/1000)+"s 后重发").sendToTarget();
        }
    }

    //结束
    //onFinish()中的代码是计时器结束的时候要做的事情；
    @Override
    public void onFinish() {
        if (mHandler!=null){
            mHandler.obtainMessage(END_RUNNING,"重发").sendToTarget();
        }
    }
}
