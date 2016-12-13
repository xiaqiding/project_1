package com.bwie.myphotos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewTreeObserver;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private int mImageThumbSize;
    private int mImageThumbSpacing;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageThumbSize = getResources().getDimensionPixelSize(
                R.dimen.image_thumbnail_size);
        mImageThumbSpacing = getResources().getDimensionPixelSize(
                R.dimen.image_thumbnail_spacing);

        //得到控件
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        //布局大小一致  利于优化
        mRecyclerView.setHasFixedSize(true);
        //创建布局管理器
        GridLayoutManager manager = new GridLayoutManager(this, 3);
        //设置布局管理器
        mRecyclerView.setLayoutManager(manager);
        //得到适配器
        myAdapter = new MyAdapter(MainActivity.this, Images.imageThumbUrls, mRecyclerView);
        //设置适配器
        mRecyclerView.setAdapter(myAdapter);

        mRecyclerView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                final int numColumns = (int) Math.floor(mRecyclerView.getWidth() / (mImageThumbSize + mImageThumbSpacing));
                if (numColumns > 0) {
                    int columnWidth = (mRecyclerView.getWidth() / numColumns) - mImageThumbSpacing;
                    myAdapter.setItemHeight(columnWidth);
                    mRecyclerView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        myAdapter.fluchCache();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 退出程序时结束所有的下载任务
        myAdapter.cancelAllTasks();
    }

}
