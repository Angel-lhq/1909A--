package com.example.day01_8_1_homework;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private FrameLayout mFrameLayout;
    private TabLayout mTabLayout;
    private TextView mTvToolbar;
    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mTvToolbar = (TextView) findViewById(R.id.tv_toolbar);
        mFrameLayout = (FrameLayout) findViewById(R.id.frameLayout);
        mTabLayout = (TabLayout) findViewById(R.id.tabLayout);

        mToolbar.setTitle("");
        mTvToolbar.setText("首页");
        setSupportActionBar(mToolbar);

        List<String> titles = new ArrayList<>();
        titles.add("首页");
        titles.add("发现");
        titles.add("商城");
        titles.add("我的");

        HomeFragment homeFragment = new HomeFragment();
        FoundFragment foundFragment = new FoundFragment();
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(homeFragment);
        fragments.add(foundFragment);
        fragments.add(homeFragment);
        fragments.add(homeFragment);
        mTabLayout.addTab(mTabLayout.newTab().setCustomView(getView(titles.get(0), R.drawable.iv_home_selector)));
        mTabLayout.addTab(mTabLayout.newTab().setCustomView(getView(titles.get(1), R.drawable.iv_comrade_selector)));
        mTabLayout.addTab(mTabLayout.newTab().setCustomView(getView(titles.get(2), R.drawable.iv_interact_selector)));
        mTabLayout.addTab(mTabLayout.newTab().setCustomView(getView(titles.get(3), R.drawable.iv_mine_selector)));

        manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.frameLayout,homeFragment).commit();

        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                manager.beginTransaction()
                        .replace(R.id.frameLayout,fragments.get(position))
                        .commit();
                mTvToolbar.setText(titles.get(position));
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private View getView(String title, int icon) {
        View inflate = LayoutInflater.from(this).inflate(R.layout.layout_tab_item, null);
        ImageView img_icon = inflate.findViewById(R.id.img_icon);
        TextView tv_title = inflate.findViewById(R.id.tv_title);
        img_icon.setBackgroundResource(icon);
        tv_title.setText(title);
        return inflate;
    }
}