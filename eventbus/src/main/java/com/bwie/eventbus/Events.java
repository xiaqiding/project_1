package com.bwie.eventbus;

/**
 * Created by Administrator on 2016-12-12.
 */
public class Events {
    private String mMsg;
    public Events(String msg) {
        mMsg = msg;
    }
    public String getMsg(){
        return mMsg;
    }
}
