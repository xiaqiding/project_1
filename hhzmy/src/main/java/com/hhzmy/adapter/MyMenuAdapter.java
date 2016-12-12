package com.hhzmy.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hhzmy.R;
import com.hhzmy.bean.HomeData;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by Administrator on 2016-11-15.
 */
public class MyMenuAdapter extends BaseAdapter {

    String url_img="http://image1.suning.cn/";

    private Context context;
    private List<HomeData.DataBean> homeDataList;

    public MyMenuAdapter(Context context, List<HomeData.DataBean> homeDataList) {
        this.context = context;
        this.homeDataList = homeDataList;
    }

    @Override
    public int getCount() {
        return homeDataList.get(1).getTag().size();
    }

    @Override
    public Object getItem(int i) {
        return homeDataList.get(1).getTag().get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder vh=null;
        if (view==null){
            view=View.inflate(context, R.layout.home_menu_item,null);
            vh=new ViewHolder();
            vh.menu_img= (ImageView) view.findViewById(R.id.home_menu_item_img);
            vh.menu_name= (TextView) view.findViewById(R.id.home_menu_item_name);
            view.setTag(vh);
        }else {
            vh= (ViewHolder) view.getTag();
        }

        ImageLoader.getInstance().displayImage(url_img+homeDataList.get(1).getTag().get(i).getPicUrl(),vh.menu_img);
        vh.menu_name.setText(homeDataList.get(1).getTag().get(i).getElementName());
        return view;
    }

    class ViewHolder{
        ImageView menu_img;
        TextView menu_name;
    }
}
