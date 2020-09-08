package com.example.exam8_25;

import android.Manifest;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.exam8_25.adapter.InfoVpAdapter;
import com.example.exam8_25.base.BaseActivity;
import com.example.exam8_25.constract.IHome;
import com.example.exam8_25.fragment.EmptyFragment;
import com.example.exam8_25.fragment.HomeFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    private InfoVpAdapter infoVpAdapter;

    @Override
    protected IHome.IHomePresenter initPresenter() {
        return null;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        ActivityCompat.requestPermissions(this,new String[]{
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.ACCESS_FINE_LOCATION
        },1);
        tabLayout = findViewById(R.id.tab);
        viewPager = findViewById(R.id.vp);
        List<Fragment> fragments = new ArrayList<>();
        HomeFragment homeFragment = new HomeFragment();
        fragments.add(new EmptyFragment());
        fragments.add(homeFragment);
        fragments.add(new EmptyFragment());
        fragments.add(new EmptyFragment());
        fragments.add(new EmptyFragment());
        fragments.add(new EmptyFragment());
        infoVpAdapter = new InfoVpAdapter(getSupportFragmentManager(), fragments);
        viewPager.setAdapter(infoVpAdapter);
        tabLayout.setupWithViewPager(this.viewPager);
        viewPager.setCurrentItem(1);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

}