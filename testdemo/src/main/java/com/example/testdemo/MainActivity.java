package com.example.testdemo;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.tabs.TabLayout;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements CommonTabPagerAdapter.TabPagerListener {

    private AppBarLayout mAppBar;
    private CollapsingToolbarLayout mCollapsingToolBar;
    private Toolbar mToolBar;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private CommonTabPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //当系统版本为4.4或者4.4以上时可以使用沉浸式状态栏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mAppBar = (AppBarLayout) findViewById(R.id.appBar);
        mCollapsingToolBar = (CollapsingToolbarLayout) findViewById(R.id.collapsingToolBar);
        mToolBar = (Toolbar) findViewById(R.id.toolBar);
        mTabLayout = (TabLayout) findViewById(R.id.tabLayout);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        setTitle("返回");
        mCollapsingToolBar.setTitle("返回");
        mCollapsingToolBar.setExpandedTitleColor(Color.parseColor("#00ffffff"));//设置还没收缩时状态下字体颜色
        mCollapsingToolBar.setCollapsedTitleTextColor(Color.WHITE);//设置收缩后Toolbar上字体的
        adapter = new CommonTabPagerAdapter(getSupportFragmentManager()
                , 4, Arrays.asList("美食", "电影", "玩乐", "评价"), this);
        adapter.setListener(this);
        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.setTabMode(TabLayout.MODE_FIXED);
    }

    @Override
    public Fragment getFragment(int position) {
        return DemoFragment.newInstance(position);
    }
}