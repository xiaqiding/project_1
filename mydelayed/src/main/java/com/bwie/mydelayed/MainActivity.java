package com.bwie.mydelayed;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = (ImageView) findViewById(R.id.img);
        //变大
        ScaleAnimation anim=new ScaleAnimation(0,1,0,1);
        //时间
        anim.setDuration(5000);
        img.setAnimation(anim);
        //延迟
        img.postDelayed(new Runnable() {
            @Override
            public void run() {
                //消失
                img.setVisibility(View.GONE);
                //销毁
                MainActivity.this.finish();
            }
        },5000);

    }
}
