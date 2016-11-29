package com.bwie.fragmentalive;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * autour: 夏奇顶
 * date: 2016-11-29 14:36 
 * update: 2016-11-29
 */

public class TwoFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_two, null);

        TextView textView = (TextView) view.findViewById(R.id.textView);
        Bundle bundle_2=getArguments();
        textView.setText(bundle_2.getString("as"));

        return view;
    }

}
