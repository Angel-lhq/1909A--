package com.example.day02_8_2_1_homework;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.day02_8_2_1_homework.adapter.InfoVpAdapter;
import com.example.day02_8_2_1_homework.fragment.HomeFragment;
import com.example.day02_8_2_1_homework.fragment.MineFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private TabLayout mTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        mTabLayout = (TabLayout) findViewById(R.id.tabLayout);

        HomeFragment homeFragment = new HomeFragment();
        MineFragment mineFragment = new MineFragment();
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(homeFragment);
        fragments.add(mineFragment);
        InfoVpAdapter infoVpAdapter = new InfoVpAdapter(getSupportFragmentManager(), fragments);
        mViewPager.setAdapter(infoVpAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.getTabAt(0).setCustomView(getView("首页",R.drawable.home_selector));
        mTabLayout.getTabAt(1).setCustomView(getView("我的",R.drawable.mine_selector));
    }

    private View getView(String title, int icon) {
        View inflate = LayoutInflater.from(this).inflate(R.layout.layout_tab_item, null);
        ImageView tab_item_img = inflate.findViewById(R.id.tab_item_img);
        TextView tab_item_title = inflate.findViewById(R.id.tab_item_title);
        tab_item_img.setBackgroundResource(icon);
        tab_item_title.setText(title);
        return inflate;
    }
}