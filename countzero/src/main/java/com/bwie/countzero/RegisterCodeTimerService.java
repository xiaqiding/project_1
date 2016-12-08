package com.bwie.countzero;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by Administrator on 2016-12-08.
 *  注册验证码计时服务
 *  使用了RegisterCodeTimerService来完成倒计时，这样就算页面跳转了也不会停止倒计时
 */
public class RegisterCodeTimerService extends Service {

    private static Handler mHandler;
    private static RegisterCodeTimer mCodeTimer;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        mCodeTimer=new RegisterCodeTimer(60000, 1000, mHandler);
        mCodeTimer.start();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public static void setHandler(Handler handler) {
        mHandler = handler;
    }
}
