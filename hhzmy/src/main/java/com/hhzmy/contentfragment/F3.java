package com.hhzmy.contentfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hhzmy.R;


/**
 * Created by huanhuan on 2016/11/16.
 */
public class F3 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v3=inflater.inflate(R.layout.f3,null);
        return v3;
    }
}
