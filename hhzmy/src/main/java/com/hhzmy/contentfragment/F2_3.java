package com.hhzmy.contentfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.hhzmy.R;


/**
 * Created by huanhuan on 2016/11/17.
 */
public class F2_3 extends Fragment {
    private WebView wb3;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v3 = inflater.inflate(R.layout.f2_3, null);


        wb3 = (WebView) v3.findViewById(R.id.f2_3_web);
        wb3.loadUrl("http://product.suning.com/pds-web/product/graphicSaleApp/0000000000/102295661.html");
        return v3;
    }
}
