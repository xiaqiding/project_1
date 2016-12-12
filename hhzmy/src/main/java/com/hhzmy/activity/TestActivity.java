package com.hhzmy.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.hhzmy.R;

public class TestActivity extends AppCompatActivity {

    private WebView wv_test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        wv_test = (WebView)findViewById(R.id.test_wv);

        wv_test.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);

        String htmlData ="";

        htmlData = htmlData.replaceAll("&", "");
        htmlData = htmlData.replaceAll("quot;", "\"");
        htmlData = htmlData.replaceAll("lt;", "<");
        htmlData = htmlData.replaceAll("gt;", ">");

        wv_test.loadDataWithBaseURL(null,htmlData,"text/html","utf-8",null);
        //return view;
    }
}
