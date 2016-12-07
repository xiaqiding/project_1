package com.bwie.myumtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private ImageView img_qq;
    private ImageView img_wechat;
    private ImageView img_sina;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        img_qq = (ImageView) findViewById(R.id.login_qq);
        img_qq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UMShareAPI mShareAPI = UMShareAPI.get( MainActivity.this );
                mShareAPI.getPlatformInfo(MainActivity.this, SHARE_MEDIA.QQ, umAuthListener);

            }
        });

        img_wechat = (ImageView) findViewById(R.id.login_wechat);
        img_wechat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UMShareAPI mShareAPI = UMShareAPI.get( MainActivity.this );
                mShareAPI.getPlatformInfo(MainActivity.this, SHARE_MEDIA.WEIXIN, umAuthListener);
            }
        });

        img_sina = (ImageView) findViewById(R.id.login_sina);
        img_sina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UMShareAPI mShareAPI = UMShareAPI.get( MainActivity.this );
                mShareAPI.getPlatformInfo(MainActivity.this, SHARE_MEDIA.SINA, umAuthListener);
                System.out.println("=============");
            }
        });
    }

    private UMAuthListener umAuthListener = new UMAuthListener() {
        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
            Toast.makeText(getApplicationContext(), "Authorize succeed", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {
            Toast.makeText( getApplicationContext(), "Authorize fail", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            Toast.makeText( getApplicationContext(), "Authorize cancel", Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }

}
