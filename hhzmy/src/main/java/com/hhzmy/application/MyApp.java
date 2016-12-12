package com.hhzmy.application;

import android.app.Application;
import android.content.Context;

import com.baidu.mapapi.SDKInitializer;
import com.hhzmy.R;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.memory.impl.UsingFreqLimitedMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * Created by Administrator on 2016-11-14.
 */
public class MyApp extends Application {
    static Context context;

    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        super.onCreate();
        context = getApplicationContext();
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .cacheInMemory(true).cacheOnDisk(true)
                .showImageForEmptyUri(R.mipmap.ic_launcher)
                .showImageOnFail(R.mipmap.ic_launcher)
                .showImageOnLoading(R.mipmap.ic_launcher).build();
        int sizeMax = (int) (Runtime.getRuntime().maxMemory() / 8);
        ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder(
                getApplicationContext()).defaultDisplayImageOptions(options)
                .diskCache(new UnlimitedDiskCache(getCacheDir()))
                .memoryCache(new UsingFreqLimitedMemoryCache(sizeMax)).build();
        ImageLoader.getInstance().init(configuration);

        SDKInitializer.initialize(getApplicationContext());

    }

    public static Context getAppliContext() {
        return context;
    }
}
