package com.hhzmy.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.google.gson.Gson;
import com.hhzmy.R;
import com.hhzmy.activity.ContentActivity;
import com.hhzmy.activity.ScanActivity;
import com.hhzmy.activity.TestActivity;
import com.hhzmy.adapter.MyInfantmomAdapterBottom;
import com.hhzmy.adapter.MyInfantmomAdapterTop;
import com.hhzmy.adapter.MyMenuAdapter;
import com.hhzmy.adapter.MyTsundereAdapter_1;
import com.hhzmy.adapter.MyTsundereAdapter_2;
import com.hhzmy.adapter.MyTsundereAdapter_3;
import com.hhzmy.bean.HomeData;
import com.hhzmy.httputils.OkHttp;
import com.hhzmy.view.MyGridView;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.io.IOException;
import java.util.List;

import okhttp3.Request;

public class HomeFragment extends Fragment {

    String url="http://mock.eoapi.cn/success/jSWAxchCQfuhI6SDlIgBKYbawjM3QIga";
    String url_img="http://image1.suning.cn/";
    private HomeData homeData;
    private List<HomeData.DataBean> homeDataList;
    private SliderLayout mSlidLayout;
    private View view;
    private MyMenuAdapter myMenuAdapter;
    private MyGridView mMenu;
    private LinearLayout mSeckillcontent;
    private ImageView mSeckillName;
    private MyGridView mTsundere_content_1;
    private MyGridView mTsundere_content_3;
    private MyGridView mTsundere_content_2;
    private MyTsundereAdapter_1 myTsundereAdapter_1;
    private MyTsundereAdapter_2 myTsundereAdapter_2;
    private MyTsundereAdapter_3 myTsundereAdapter_3;
    private ImageView mTsundere_name;
    private ImageView mInfantmom_name;
    private MyInfantmomAdapterTop myInfantmomAdapterTop;
    private MyGridView mInfantmom_content_top;
    private MyInfantmomAdapterBottom myInfantmomAdapterBottom;
    private MyGridView mInfantmom_content_bottom;
    private ImageView mMonShop_name;
    private LinearLayout mSpecialOffer_juyou;
    private ImageView mSpecialOffer_type_2;
    private LinearLayout mSpecialOffer_haiwai;
    private ImageView mSpecialOffer_type_1;
    private ImageView mSpecialOffer_name;
    private LinearLayout mSpecialOffer_shengqian;
    private ImageView mSpecialOffer_type_4;
    private LinearLayout mSpecialOffer_liangfan;
    private ImageView mSpecialOffer_type_3;
    private ImageView mMonShopType_1;
    private ImageView mMonShopType_2;
    private ImageView mMonShopType_3;
    private ImageView mMonShopType_4;
    private ImageView mMonShopType_5;
    private ImageView mSelect;
    private ImageView mHomeScan;
    private LinearLayout mHomeSearch;
    private ImageView mHomeMessage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_home,container,false);

        //获得控件
        initView();
        //头部控件监听
        initHeader();
        //获取首页数据
        initNetHomeData();

        return view;
    }

    //获得控件
    private void initView() {
        //头部控件
        mHomeScan = (ImageView) view.findViewById(R.id.home_scan);
        mHomeSearch = (LinearLayout) view.findViewById(R.id.home_search);
        mHomeMessage = (ImageView) view.findViewById(R.id.home_meseage);

        //得到控件
        mSeckillName=(ImageView)view.findViewById(R.id.home_miaosha_name);
        mSeckillcontent =(LinearLayout) view.findViewById(R.id.home_miaosha_content);

        mSpecialOffer_name = (ImageView) view.findViewById(R.id.home_zhuti_name);
        //洋货超值购
        mSpecialOffer_type_1 = (ImageView) view.findViewById(R.id.home_zhuti_type_1);
        mSpecialOffer_haiwai = (LinearLayout) view.findViewById(R.id.home_haiwai_content);
        //聚优 聚省聚会
        mSpecialOffer_type_2 = (ImageView) view.findViewById(R.id.home_zhuti_type_2);
        mSpecialOffer_juyou = (LinearLayout) view.findViewById(R.id.home_juhui_content);
        //加量不加价
        mSpecialOffer_type_3 = (ImageView) view.findViewById(R.id.home_zhuti_type_3);
        mSpecialOffer_liangfan = (LinearLayout) view.findViewById(R.id.home_liangfan_content);
        //省钱败好货
        mSpecialOffer_type_4 = (ImageView) view.findViewById(R.id.home_zhuti_type_4);
        mSpecialOffer_shengqian = (LinearLayout) view.findViewById(R.id.home_shengqian_content);
        //拼团名称
        mMonShop_name = (ImageView) view.findViewById(R.id.home_lama_name);
        //拼团类型
        mMonShopType_1 =(ImageView)view.findViewById(R.id.home_lama_content_1);
        mMonShopType_2 =(ImageView)view.findViewById(R.id.home_lama_content_2);
        mMonShopType_3 =(ImageView)view.findViewById(R.id.home_lama_content_3);
        mMonShopType_4 =(ImageView)view.findViewById(R.id.home_lama_content_4);
        mMonShopType_5 =(ImageView)view.findViewById(R.id.home_lama_content_5);
        //查看更多
        mSelect =(ImageView)view.findViewById(R.id.home_select_more);
    }

    private void initHeader() {
        mHomeScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), ScanActivity.class));
            }
        });

        mHomeSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        mHomeMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    //获取数据
    public void initNetHomeData() {

        OkHttp.getAsync(url,new OkHttp.DataCallBack() {

            @Override
            public void requestFailure(Request request, IOException e) {
            }

            @Override
            public void requestSuccess(String result) throws Exception {

                Gson gson=new Gson();
                HomeData homeData=gson.fromJson(result,HomeData.class);
                //数据源
                homeDataList=homeData.getData();

                //傲娇品牌
                initTsundere();

                //母婴专区
                initInfantmom();

                //辣妈拼团
                initMonShop();

                //查看更多
                initSelect();

                //轮播图
                initSlider();

                //轮播图下方菜单
                initHomeMenu();

                //主题特卖
                initSpecialOffer();

                //十点秒杀
                initseckill();

            }

            //查看更多
            private void initSelect() {
                ImageLoader.getInstance().displayImage(url_img+homeDataList.get(33).getTag().get(0).getPicUrl(),mSelect);
                mSelect.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(getActivity(), TestActivity.class));
                    }
                });
            }

            //辣妈拼团
            private void initMonShop() {
                //赋值
                ImageLoader.getInstance().displayImage(url_img+homeDataList.get(23).getTag().get(0).getPicUrl(),mMonShop_name);
                ImageLoader.getInstance().displayImage(url_img+homeDataList.get(24).getTag().get(0).getPicUrl(),mMonShopType_1);
                mMonShopType_1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(getActivity(), TestActivity.class));
                    }
                });
                ImageLoader.getInstance().displayImage(url_img+homeDataList.get(26).getTag().get(0).getPicUrl(),mMonShopType_2);
                mMonShopType_2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(getActivity(), TestActivity.class));
                    }
                });
                ImageLoader.getInstance().displayImage(url_img+homeDataList.get(28).getTag().get(0).getPicUrl(),mMonShopType_3);
                mMonShopType_3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(getActivity(), TestActivity.class));
                    }
                });
                ImageLoader.getInstance().displayImage(url_img+homeDataList.get(30).getTag().get(0).getPicUrl(),mMonShopType_4);
                mMonShopType_4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(getActivity(), TestActivity.class));
                    }
                });
                ImageLoader.getInstance().displayImage(url_img+homeDataList.get(32).getTag().get(0).getPicUrl(),mMonShopType_5);
                mMonShopType_5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(getActivity(), TestActivity.class));
                    }
                });
            }

            //主题特卖
            private void initSpecialOffer() {
                //赋值
                ImageLoader.getInstance().displayImage(url_img+homeDataList.get(13).getTag().get(0).getPicUrl(),mSpecialOffer_name);
                //赋值
                ImageLoader.getInstance().displayImage(url_img+homeDataList.get(14).getTag().get(0).getPicUrl(),mSpecialOffer_type_1);
                //循环添加内容
                for (int i=0;i<homeDataList.get(15).getTag().size();i++){
                    view =View.inflate(getActivity(), R.layout.home_zhuti_item,null);
                    ImageView mSpecialOffer_item_img= (ImageView) view.findViewById(R.id.home_zhuti_item_img);
                    ImageLoader.getInstance().displayImage(url_img+homeDataList.get(15).getTag().get(i).getPicUrl(),mSpecialOffer_item_img);
                    mSpecialOffer_haiwai.addView(view);
                }
                //海外标题监听
                mSpecialOffer_type_1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(getActivity(), TestActivity.class));
                    }
                });
                 //海外内容监听
                mSpecialOffer_haiwai.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(getActivity(), TestActivity.class));
                    }
                });

                //赋值
                ImageLoader.getInstance().displayImage(url_img+homeDataList.get(16).getTag().get(0).getPicUrl(),mSpecialOffer_type_2);
                //循环添加内容
                for (int i=0;i<homeDataList.get(17).getTag().size();i++){
                    view=View.inflate(getActivity(), R.layout.home_zhuti_item,null);
                    ImageView mSpecialOffer_item_img= (ImageView) view.findViewById(R.id.home_zhuti_item_img);
                    ImageLoader.getInstance().displayImage(url_img+homeDataList.get(17).getTag().get(i).getPicUrl(),mSpecialOffer_item_img);
                    mSpecialOffer_juyou.addView(view);
                }
                //聚优标题监听
                mSpecialOffer_type_2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(getActivity(), TestActivity.class));
                    }
                });
                //聚优内容监听
                mSpecialOffer_juyou.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(getActivity(), TestActivity.class));
                    }
                });

                //赋值
                ImageLoader.getInstance().displayImage(url_img+homeDataList.get(18).getTag().get(0).getPicUrl(), mSpecialOffer_type_3);
                //循环添加内容
                for (int i=0;i<homeDataList.get(19).getTag().size();i++){
                    view=View.inflate(getActivity(), R.layout.home_zhuti_item,null);
                    ImageView mSpecialOffer_item_img= (ImageView) view.findViewById(R.id.home_zhuti_item_img);
                    ImageLoader.getInstance().displayImage(url_img+homeDataList.get(19).getTag().get(i).getPicUrl(),mSpecialOffer_item_img);
                    mSpecialOffer_liangfan.addView(view);
                }
                //量贩标题监听
                mSpecialOffer_type_3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(getActivity(), TestActivity.class));
                    }
                });
                //量贩内容监听
                mSpecialOffer_liangfan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(getActivity(), TestActivity.class));
                    }
                });
                //赋值
                ImageLoader.getInstance().displayImage(url_img+homeDataList.get(20).getTag().get(0).getPicUrl(), mSpecialOffer_type_4);
                //循环添加内容
                for (int i=0;i<homeDataList.get(21).getTag().size();i++){
                    view=View.inflate(getActivity(), R.layout.home_zhuti_item,null);
                    ImageView mSpecialOffer_item_img= (ImageView) view.findViewById(R.id.home_zhuti_item_img);
                    ImageLoader.getInstance().displayImage(url_img+homeDataList.get(21).getTag().get(i).getPicUrl(),mSpecialOffer_item_img);
                    mSpecialOffer_shengqian.addView(view);
                }
                //省钱标题点击事件
                mSpecialOffer_type_4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(getActivity(), TestActivity.class));
                    }
                });
                //省钱内容点击事件
                mSpecialOffer_shengqian.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(getActivity(), TestActivity.class));
                    }
                });
            }

            //母婴专区
            private void initInfantmom() {
                //得到控件
                mInfantmom_name = (ImageView) view.findViewById(R.id.home_muying_name);
                //赋值
                ImageLoader.getInstance().displayImage(url_img+homeDataList.get(9).getTag().get(0).getPicUrl(),mInfantmom_name);
                //专区上部
                mInfantmom_content_top=(MyGridView)view.findViewById(R.id.home_muying_content_top);
                //得到适配器
                myInfantmomAdapterTop = new MyInfantmomAdapterTop(getActivity(),homeDataList);
                //设置适配器
                mInfantmom_content_top.setAdapter(myInfantmomAdapterTop);
                //母婴专区上部监听
                mInfantmom_content_top.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        startActivity(new Intent(getActivity(), TestActivity.class));
                    }
                });

                //专区下部
                mInfantmom_content_bottom =(MyGridView)view.findViewById(R.id.home_muying_content_bottom);
                myInfantmomAdapterBottom = new MyInfantmomAdapterBottom(getActivity(),homeDataList);
                mInfantmom_content_bottom.setAdapter(myInfantmomAdapterBottom);
                //母婴专区下部监听
                mInfantmom_content_bottom.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        startActivity(new Intent(getActivity(), TestActivity.class));
                    }
                });
            }

            //傲娇品牌
            private void initTsundere() {
                //得到控件
                mTsundere_name= (ImageView) view.findViewById(R.id.home_aojiao_name);
                //赋值
                ImageLoader.getInstance().displayImage(url_img+homeDataList.get(4).getTag().get(0).getPicUrl(),mTsundere_name);

                //得到控件
                mTsundere_content_1 =(MyGridView)view.findViewById(R.id.home_aojiao_content_1);
                //得到适配器
                myTsundereAdapter_1 = new MyTsundereAdapter_1(getActivity(),homeDataList);
                //设置适配器
                mTsundere_content_1.setAdapter(myTsundereAdapter_1);
                //傲娇品牌上部监听事件
                mTsundere_content_1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        startActivity(new Intent(getActivity(), TestActivity.class));
                    }
                });

                mTsundere_content_2 =(MyGridView)view.findViewById(R.id.home_aojiao_content_2);
                myTsundereAdapter_2 = new MyTsundereAdapter_2(getActivity(),homeDataList);
                mTsundere_content_2.setAdapter(myTsundereAdapter_2);
                //傲娇品牌中部监听事件
                mTsundere_content_2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        startActivity(new Intent(getActivity(), TestActivity.class));
                    }
                });

                mTsundere_content_3 =(MyGridView)view.findViewById(R.id.home_aojiao_content_3);
                myTsundereAdapter_3 = new MyTsundereAdapter_3(getActivity(),homeDataList);
                mTsundere_content_3.setAdapter(myTsundereAdapter_3);
                //傲娇品牌下部监听事件
                mTsundere_content_3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        startActivity(new Intent(getActivity(), TestActivity.class));
                    }
                });
            }

            //十点秒杀
            private void initseckill() {
                ImageView seckill_img;
                //循环赋值
                for (int i=0;i<homeDataList.get(2).getTag().size();i++){
                    if (i==0){
                        ImageLoader.getInstance().displayImage(url_img+homeDataList.get(2).getTag().get(0).getPicUrl(),mSeckillName);
                    }else{
                        view =View.inflate(getActivity(), R.layout.home_miaosha_item,null);
                        seckill_img= (ImageView) view.findViewById(R.id.home_miaosha_item_img);
                        ImageLoader.getInstance().displayImage(url_img+homeDataList.get(2).getTag().get(i).getPicUrl(),seckill_img);
                        mSeckillcontent.addView(view);
                    }
                }
                //秒杀监听事件
                mSeckillcontent.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(getActivity(), ContentActivity.class));
                    }
                });
            }

            //轮播图下方菜单
            private void initHomeMenu() {
                //得到控件
                mMenu = (MyGridView) view.findViewById(R.id.home_menu);
                //得到适配器
                myMenuAdapter = new MyMenuAdapter(getActivity(),homeDataList);
                //设置适配器
                mMenu.setAdapter(myMenuAdapter);
                //菜单按钮监听事件
                mMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        startActivity(new Intent(getActivity(), TestActivity.class));
                    }
                });
            }

            //轮播图
            private void initSlider() {
                //轮播控件
                mSlidLayout = (SliderLayout) view.findViewById(R.id.home_slider);

                //循环添加数据
                for (int i=0;i<homeDataList.get(0).getTag().size();i++){
                    TextSliderView textSliderView = new TextSliderView(view.getContext());
                    //设置图片及添加文字
                    textSliderView.description("红孩子").image(url_img+homeDataList.get(0).getTag().get(i).getPicUrl());
                    mSlidLayout.addSlider(textSliderView);
                    //圆点位置
                    mSlidLayout.setPresetIndicator(SliderLayout.PresetIndicators.Right_Bottom);
                    //动画样式
                    mSlidLayout.setPresetTransformer(SliderLayout.Transformer.Accordion);
                    //动画时间
                    mSlidLayout.setDuration(2000);
                    //轮播图监听事件
                    textSliderView.setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
                        @Override
                        public void onSliderClick(BaseSliderView slider) {
                            startActivity(new Intent(getActivity(), TestActivity.class));
                        }
                    });
                }
            }
        });
    }
}
