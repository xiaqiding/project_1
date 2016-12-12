package com.hhzmy.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.hhzmy.R;
import com.hhzmy.bean.HomeData;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by Administrator on 2016-11-15.
 */
public class MyTsundereAdapter_2 extends BaseAdapter {

    String url_img="http://image1.suning.cn/";

    Context context;
    List<HomeData.DataBean> homeDataList;

    public MyTsundereAdapter_2(Context context, List<HomeData.DataBean> homeDataList) {
        this.context = context;
        this.homeDataList = homeDataList;
    }

    @Override
    public int getCount() {
        return homeDataList.get(6).getTag().size();
    }

    @Override
    public Object getItem(int i) {
        return homeDataList.get(6).getTag().get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder vh=null;
        if (view==null){
            view=View.inflate(context, R.layout.home_aojiao_item,null);
            vh=new ViewHolder();
            vh.tsundere_img= (ImageView) view.findViewById(R.id.home_aojiao_item_img);
            view.setTag(vh);
        }else{
            vh= (ViewHolder) view.getTag();
        }

        ImageLoader.getInstance().displayImage(url_img+homeDataList.get(6).getTag().get(i).getPicUrl(),vh.tsundere_img);
        return view;
    }

    class ViewHolder{
        ImageView tsundere_img;
    }
}
