package com.hhzmy.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hhzmy.R;
import com.hhzmy.bean.ClassifyData;

import java.util.List;


/**
 * Created by PigGhost on 2016/11/22.
 */
public class MyRecyclerViewLeftAdapter extends RecyclerView.Adapter<MyRecyclerViewLeftAdapter.MyViewHolder>{
    private List<ClassifyData.RsBean> mlist;
    private Context context;

    public MyRecyclerViewLeftAdapter(List<ClassifyData.RsBean> mlist, Context context) {
        this.mlist = mlist;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.recyclerview_left, parent, false));

        return holder;
    }
    /**
     * 设置监听
     */
    public interface OnItemClickLitener{
        void onItemClick(View view, int positon);
        void onItemLongClick(View view, int position);
    }

    private OnItemClickLitener onItemClickLitener;

    public void setOnItemClickLitener(OnItemClickLitener onItemClickLitener){
        this.onItemClickLitener=onItemClickLitener;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        holder.tv.setText(mlist.get(position).dirName);

        //判断是否选中改变选中颜色
        if (mlist.get(position).ischeck){
            holder.tvimage.setVisibility(View.VISIBLE);
            holder.tv.setBackgroundResource(R.color.tabitem);
            holder.tv.setTextColor(0xFFF29400);
        }else{
            holder.tvimage.setVisibility(View.GONE);
            holder.tv.setBackgroundResource(R.color.tabwite);
            holder.tv.setTextColor(Color.BLACK);
        }

        //如果设置回调，则设置点击事件
        if(onItemClickLitener!=null){
            //设置点击
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos=holder.getLayoutPosition();
                    onItemClickLitener.onItemClick(holder.itemView,pos);
                }
            });
            //长按事件
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener()
            {

                @Override
                public boolean onLongClick(View view) {
                    int pos = holder.getLayoutPosition();
                    onItemClickLitener.onItemLongClick(holder.itemView, pos);
                    return false;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private final TextView tv;
        private final TextView tvimage;

        public MyViewHolder(View itemView) {
            super(itemView);

            tv = (TextView) itemView.findViewById(R.id.tv_recycle_line);
            tvimage = (TextView) itemView.findViewById(R.id.recycle_line_iamge);
        }
    }
}
