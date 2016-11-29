package com.bwie.myfragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/**
 * autour: 夏奇顶
 * date: 2016-11-29 10:34 
 * update: 2016-11-29
 */

public class ExampleFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("ExampleFragment---onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        System.out.println("ExampleFragment--onCreateView");
        return inflater.inflate(R.layout.fragment_example, container, false);
    }

    @Override
    public void onPause() {
        super.onPause();
        System.out.println("ExampleFragment--onPause");
    }

    @Override
    public void onResume() {
        super.onResume();
        System.out.println("ExampleFragment--onResume");
    }

    @Override
    public void onStop() {
        super.onStop();
        System.out.println("ExampleFragment--onStop");
    }
}
