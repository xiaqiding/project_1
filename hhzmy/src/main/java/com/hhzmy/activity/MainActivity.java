package com.hhzmy.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;

import com.hhzmy.R;
import com.hhzmy.bean.Tab;
import com.hhzmy.fragment.ClassifyFragment;
import com.hhzmy.fragment.HomeFragment;
import com.hhzmy.fragment.MineFragment;
import com.hhzmy.fragment.ShopFragment;
import com.hhzmy.widget.FragmentTabHost;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private LayoutInflater mInflater;
    private FragmentTabHost mTabHost;
    List<Tab> mTabs=new ArrayList<Tab>(4);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //底部按钮
        initTab();
    }
    private void initTab() {
        //底部按钮数据
        Tab tab_home=new Tab(R.string.home, R.drawable.selector_icon_home, HomeFragment.class);
        Tab tab_classify=new Tab(R.string.classify, R.drawable.selector_icon_classify, ClassifyFragment.class);
        Tab tab_shop=new Tab(R.string.shop, R.drawable.selector_icon_shop, ShopFragment.class);
        Tab tab_mine=new Tab(R.string.mine, R.drawable.selector_icon_mine, MineFragment.class);
        //将数据加入到集合
        mTabs.add(tab_home);
        mTabs.add(tab_classify);
        mTabs.add(tab_shop);
        mTabs.add(tab_mine);

        mInflater=LayoutInflater.from(this);
        mTabHost= (FragmentTabHost) this.findViewById(android.R.id.tabhost);
        mTabHost.setup(this,getSupportFragmentManager(), R.id.real_tabcontent);
        //利用循环加入数据
        for (Tab tab:mTabs) {
            TabHost.TabSpec tabSpec = mTabHost.newTabSpec(getString(tab.getIcon()));

            tabSpec.setIndicator(buildIndicator(tab));

            mTabHost.addTab(tabSpec, tab.getFragment(), null);
        }
        //去掉分隔线
        mTabHost.getTabWidget().setShowDividers(LinearLayout.SHOW_DIVIDER_NONE);
        //设置默认
        mTabHost.setCurrentTab(0);
    }

    private View buildIndicator(Tab tab){
        View view=mInflater.inflate(R.layout.tab_indicator,null);
        ImageView img= (ImageView) view.findViewById(R.id.icon_tab);
        //TextView text= (TextView) view.findViewById(R.id.txt_indicator);

        img.setBackgroundResource(tab.getIcon());
        //text.setText(tab.getTitle());

        return view;
    }
}
