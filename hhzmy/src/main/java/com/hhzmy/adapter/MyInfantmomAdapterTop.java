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
 * Created by Administrator on 2016-11-16.
 */
public class MyInfantmomAdapterTop extends BaseAdapter {

    String url_img="http://image1.suning.cn/";

    private Context context;
    private List<HomeData.DataBean> homeDataList;

    public MyInfantmomAdapterTop(Context context, List<HomeData.DataBean> homeDataList) {
        this.context = context;
        this.homeDataList = homeDataList;
    }

    @Override
    public int getCount() {
        return homeDataList.get(10).getTag().size();
    }

    @Override
    public Object getItem(int i) {
        return homeDataList.get(10).getTag().get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder vh=null;
        if (view==null){
            view=View.inflate(context, R.layout.home_muying_item,null);
            vh=new ViewHolder();
            vh.infantmom_img= (ImageView) view.findViewById(R.id.home_muying_item_img);
            view.setTag(vh);
        }else {
            vh= (ViewHolder) view.getTag();
        }

        ImageLoader.getInstance().displayImage(url_img+homeDataList.get(10).getTag().get(i).getPicUrl(),vh.infantmom_img);
        return view;
    }

    class ViewHolder{
        ImageView infantmom_img;
    }
}
