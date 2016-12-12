package com.bwie.eventdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.bwie.eventdemo.events.FirstEvent;
import com.bwie.eventdemo.events.SecondEvent;
import com.bwie.eventdemo.events.ThirdEvent;

import de.greenrobot.event.EventBus;

public class SecondActivity extends AppCompatActivity {

    private Button btn_FirstEvent, btn_SecondEvent, btn_ThirdEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        btn_FirstEvent = (Button) findViewById(R.id.btn_first_event);
        btn_SecondEvent = (Button) findViewById(R.id.btn_second_event);
        btn_ThirdEvent = (Button) findViewById(R.id.btn_third_event);

        btn_FirstEvent.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new FirstEvent("FirstEvent btn clicked"));
            }
        });

        btn_SecondEvent.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new SecondEvent("SecondEvent btn clicked"));
            }
        });

        btn_ThirdEvent.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new ThirdEvent("ThirdEvent btn clicked"));

            }
        });

    }
}
