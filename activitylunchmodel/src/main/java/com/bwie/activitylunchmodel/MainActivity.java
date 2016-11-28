package com.bwie.activitylunchmodel;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * autour: 夏奇顶
 * date: 2016-11-28 19:03 
 * update: 2016-11-28
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Activity activity;
    private Button btn_standard;
    private Button btn_singleTop;
    private Button btn_singleTask;
    private Button btn_singleInstance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activity=this;

        findViews();
    }

    private void findViews() {
        btn_standard = (Button) findViewById(R.id.btn_standard);
        btn_singleTop = (Button) findViewById(R.id.btn_singleTop);
        btn_singleTask = (Button) findViewById(R.id.btn_singleTask);
        btn_singleInstance = (Button) findViewById(R.id.btn_singleInstance);

        btn_standard.setOnClickListener(this);
        btn_singleTop.setOnClickListener(this);
        btn_singleTask.setOnClickListener(this);
        btn_singleInstance.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.btn_standard:
                Intent standardIntent = new Intent(activity, A1Activity.class);
                startActivity(standardIntent);
                break;
            case R.id.btn_singleTop:
                Intent singleTopIntent = new Intent(activity, B1Activity.class);
                startActivity(singleTopIntent);
                break;
            case R.id.btn_singleTask:
                Intent singleTaskIntent = new Intent(activity, C1Activity.class);
                startActivity(singleTaskIntent);
                break;
            case R.id.btn_singleInstance:
                Intent singleInstanceIntent = new Intent(activity, D1Activity.class);
                startActivity(singleInstanceIntent);
                break;
        }
    }
}
