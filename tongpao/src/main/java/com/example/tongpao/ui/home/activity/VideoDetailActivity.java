package com.example.tongpao.ui.home.activity;

import android.content.Intent;
import android.text.TextUtils;

import androidx.viewpager2.widget.ViewPager2;

import com.example.tongpao.R;
import com.example.tongpao.adapter.InfoVideoPlayAdapter;
import com.example.tongpao.base.BaseActivity;
import com.example.tongpao.base.IBasePresenter;
import com.example.tongpao.bean.VideoBean;
import com.google.gson.Gson;

import butterknife.BindView;
import cn.jzvd.JzvdStd;


public class VideoDetailActivity extends BaseActivity {
    @BindView(R.id.viewPager2)
    ViewPager2 viewPager2;
    private VideoBean videoBean;
    private InfoVideoPlayAdapter infoVideoPlayAdapter;

    @Override
    protected IBasePresenter initPresenter() {
        return null;
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        String videodata = intent.getStringExtra("videodata");
        int posi = intent.getIntExtra("posi", 0);
        if (!TextUtils.isEmpty(videodata)){
            videoBean = new Gson().fromJson(videodata, VideoBean.class);
            infoVideoPlayAdapter.setData(videoBean.getData().getList());
            if (posi > 0){
                viewPager2.setCurrentItem(posi);
            }
        }
    }

    @Override
    protected void initView() {
        infoVideoPlayAdapter = new InfoVideoPlayAdapter(this);
        viewPager2.setAdapter(infoVideoPlayAdapter);
        //监听滑动
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                infoVideoPlayAdapter.playVideo();
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        JzvdStd.releaseAllVideos();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_video_detail;
    }
}
