package com.bwie.eventdemo.events;

public class FirstEvent {

	private String mMsg;
	public FirstEvent(String msg) {
		mMsg = msg;
	}
	public String getMsg(){
		return mMsg;
	}
}
