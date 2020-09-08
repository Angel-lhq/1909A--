package com.example.tongpao.ui.discover.activity;

import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.tongpao.R;
import com.example.tongpao.base.BaseActivity;
import com.example.tongpao.constract.discover.IDiscover;
import com.example.tongpao.ui.discover.fragment.Fragment_rank_level;
import com.example.tongpao.ui.discover.fragment.Fragment_rank_money;
import com.example.tongpao.ui.discover.fragment.Fragment_rank_sign;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import butterknife.BindView;

public class DiscoverPaihangActivity extends BaseActivity<IDiscover.DiscoerPresenter> {

    @BindView(R.id.img_back)
    ImageView imgBack;
    @BindView(R.id.tab_paihang)
    TabLayout tabPaihang;
    @BindView(R.id.vp_paihang)
    ViewPager vpPaihang;
    private ArrayList<Fragment> fragments;
    private String[] tabs = {"土豪榜","等级榜","签到榜"};

    @Override
    protected void initData() {

    }

    @Override
    protected IDiscover.DiscoerPresenter initPresenter() {
        return null;
    }

    @Override
    protected void initView() {
        fragments = new ArrayList<>();
        fragments.add(new Fragment_rank_money());
        fragments.add(new Fragment_rank_level());
        fragments.add(new Fragment_rank_sign());

        //tab横向滚动
        tabPaihang.setTabMode(TabLayout.MODE_SCROLLABLE);
        //初始化vp
        vpPaihang.setAdapter(new MyAdapter(getSupportFragmentManager()));
        tabPaihang.setupWithViewPager(vpPaihang);


    }

    @Override
    protected int getLayout() {
        return R.layout.layout_paihang;
    }
    /**
     * viewpager的适配器
     */
    class MyAdapter extends FragmentPagerAdapter {
        public MyAdapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public Fragment getItem(int position) {
            return fragments.get( position );
        }
        @Override
        public int getCount() {
            return fragments.size();
        }
        //写出getPagertitle方法
        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return tabs[position];
        }
    }

}
