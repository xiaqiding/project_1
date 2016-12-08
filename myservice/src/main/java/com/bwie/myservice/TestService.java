package com.bwie.myservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Administrator on 2016-12-08.
 */
public class TestService extends Service {

    @Override
    public void onCreate() {

        Log.i("Log", "TestService -> onCreate: Thread ID:"+Thread.currentThread().getId());
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("Log", "TestService -> onStartCommand,startId"+startId+",Thread ID:"+Thread.currentThread().getId());

        return START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {

        Log.i("Log", "TestService -> onBind, Thread ID:"+Thread.currentThread().getId());
        return null;
    }

    @Override
    public void onDestroy() {
        Log.i("Log", "TestService -> onDestroy, Thread ID:"+Thread.currentThread().getId());
        super.onDestroy();
    }
}
