package com.example.tongpao;

import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.example.tongpao.adapter.WelcomeVpAdapter;
import com.example.tongpao.base.BaseActivity;
import com.example.tongpao.base.IBasePresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class WelcomeActivity extends BaseActivity {

    @BindView(R.id.vp)
    ViewPager vp;
    private SharedPreferences share;

    @Override
    protected IBasePresenter initPresenter() {
        return null;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        share = getSharedPreferences("share", 0);
        boolean isFirst = share.getBoolean("isFirst", true);
        if (isFirst){
            View view1 = LayoutInflater.from(this).inflate(R.layout.layout_welcome1, null);
            ImageView imgWelcomeBg1 = view1.findViewById(R.id.img_welcome_bg);
            Glide.with(this).load("https://p2.ssl.qhimgs1.com/sdr/400__/t01ae67e14fbe13d4f2.jpg").into(imgWelcomeBg1);
            View view2 = LayoutInflater.from(this).inflate(R.layout.layout_welcome1, null);
            ImageView imgWelcomeBg2 = view2.findViewById(R.id.img_welcome_bg);
            Glide.with(this).load("http://hbimg.huabanimg.com/df879f18c0375a14d58d25ecf6824f727542801a98aa-Ff8Vbg_fw236").into(imgWelcomeBg2);
            View view3 = LayoutInflater.from(this).inflate(R.layout.layout_welcome1, null);
            ImageView imgWelcomeBg3 = view3.findViewById(R.id.img_welcome_bg);
            Glide.with(this).load("https://p2.ssl.qhimgs1.com/sdr/400__/t01d069a1c0553631d8.png").into(imgWelcomeBg3);
            TextView tvInto = view3.findViewById(R.id.tv_into);
            tvInto.setVisibility(View.VISIBLE);
            tvInto.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    share.edit().putBoolean("isFirst",false).commit();
                    startActivity(new Intent(WelcomeActivity.this,MainActivity.class));
                    finish();
                }
            });
            List<View> views = new ArrayList<>();
            views.add(view1);
            views.add(view2);
            views.add(view3);
            WelcomeVpAdapter welcomeVpAdapter = new WelcomeVpAdapter(views);
            vp.setAdapter(welcomeVpAdapter);
        }else {
            startActivity(new Intent(this,MainActivity.class));
            finish();
        }

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_welcome;
    }
}