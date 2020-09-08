package com.example.tongpao.ui.home;

import android.view.View;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.tongpao.R;
import com.example.tongpao.base.BaseFragment;
import com.example.tongpao.constract.home.IHome;
import com.example.tongpao.ui.home.homefragments.ArticleFragment;
import com.example.tongpao.ui.home.homefragments.FollowFragment;
import com.example.tongpao.ui.home.homefragments.PhotoFragment;
import com.example.tongpao.ui.home.homefragments.RecommendFragment;
import com.example.tongpao.ui.home.homefragments.RewardFragment;
import com.example.tongpao.ui.home.homefragments.SquareFragment;
import com.example.tongpao.ui.home.homefragments.VideoFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class HomeFragment extends BaseFragment {

    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.vp)
    ViewPager vp;

    private String[] titles = {"关注","推荐","广场","视频","摄影","知识文章","悬赏"};
    private List<Fragment> fragments;

    @Override
    protected IHome.IPresenter initPresenter() {
        return null;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View view) {
        fragments = new ArrayList<>();
        fragments.add(new FollowFragment());
        fragments.add(new RecommendFragment());
        fragments.add(new SquareFragment());
        fragments.add(new VideoFragment());
        fragments.add(new PhotoFragment());
        fragments.add(new ArticleFragment());
        fragments.add(new RewardFragment());

        vp.setAdapter(new MyAdapter(getFragmentManager()));
        tab.setupWithViewPager(vp);
        tab.getTabAt(1).select();
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_home;
    }

    /**
     * viewpager的适配器m
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
            return titles[position];
        }
    }
}