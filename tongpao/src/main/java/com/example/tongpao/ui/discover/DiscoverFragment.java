package com.example.tongpao.ui.discover;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.tongpao.R;
import com.example.tongpao.adapter.discover.DiscoverTopicAdapter;
import com.example.tongpao.base.BaseFragment;
import com.example.tongpao.bean.discover.DisCoverTopicBean;
import com.example.tongpao.constract.discover.IDiscover;
import com.example.tongpao.presenter.discover.DiscoverTopicPresenter;
import com.example.tongpao.ui.discover.activity.DiscoverAssociationActivity;
import com.example.tongpao.ui.discover.activity.DiscoverPaihangActivity;
import com.example.tongpao.ui.discover.activity.RoommateActivity;
import com.example.tongpao.ui.discover.fragment.Fragment_baike;
import com.example.tongpao.ui.discover.fragment.Fragment_redian;
import com.example.tongpao.ui.discover.fragment.Fragment_tushang;
import com.example.tongpao.ui.discover.fragment.Fragment_zhuangzao;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class DiscoverFragment extends BaseFragment<IDiscover.DiscoerPresenter> implements IDiscover.DiscoverView {


    @BindView(R.id.tv_paozi)
    TextView tvPaozi;
    @BindView(R.id.tv_shetuan)
    TextView tvShetuan;
    @BindView(R.id.tv_paihang)
    TextView tvPaihang;
    @BindView(R.id.ll_one)
    LinearLayout llOne;
    @BindView(R.id.ll_two)
    LinearLayout llTwo;
    @BindView(R.id.rv_topic)
    RecyclerView rvTopic;
    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.vp)
    ViewPager vp;
    @BindView(R.id.cb)
    CollapsingToolbarLayout cb;
    @BindView(R.id.appbar)
    AppBarLayout appbar;
    @BindView(R.id.txt_title)
    TextView txtTitle;
    private List<DisCoverTopicBean.DataBean> topicBean;
    private DiscoverTopicAdapter topicAdapter;
    private String[] tabs = {"热点", "妆教", "图赏", "百科"};
    private ArrayList<Fragment> fragments;

    @Override
    protected int getLayout() {
        return R.layout.fragment_discover;
    }

    @Override
    protected void initView(View view) {

        //热门活动
        topicBean = new ArrayList();
        topicAdapter = new DiscoverTopicAdapter(context);
        LinearLayoutManager linearLayout = new LinearLayoutManager(context);
        linearLayout.setOrientation(LinearLayoutManager.HORIZONTAL);
        rvTopic.setLayoutManager(linearLayout);
        rvTopic.setAdapter(topicAdapter);
        fragments = new ArrayList<>();
        fragments.add(new Fragment_redian());
        fragments.add(new Fragment_zhuangzao());
        fragments.add(new Fragment_tushang());
        fragments.add(new Fragment_baike());

        //tab横向滚动
        tab.setTabMode(TabLayout.MODE_SCROLLABLE);
        //初始化vp
        vp.setAdapter(new MyAdapter(getChildFragmentManager()));
        tab.setupWithViewPager(vp);

    }
    @OnClick({R.id.tv_paozi, R.id.tv_shetuan, R.id.tv_paihang})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_paozi:
                startActivity(new Intent(context, RoommateActivity.class));
                break;
            case R.id.tv_shetuan:
                //点击社团跳转到相应的页面
                Intent intent1 = new Intent(context, DiscoverAssociationActivity.class);
                startActivity(intent1);
                break;
            case R.id.tv_paihang:
                //点击排行榜跳转到相应排行榜界面
                Intent intent = new Intent(context, DiscoverPaihangActivity.class);
                startActivity(intent);
                break;
        }
    }
    @Override
    protected IDiscover.DiscoerPresenter initPresenter() {
        return new DiscoverTopicPresenter();
    }

    @Override
    protected void initData() {
        //热门活动
        presneter.getTopic();
    }

    //热门活动
    @Override
    public void getTopicReturn(DisCoverTopicBean disCoverTopicBean) {
        Log.d(TAG, "getTopicReturn: " + disCoverTopicBean.getData().toString());
        topicAdapter.setData(disCoverTopicBean.getData());
    }

    private static final String TAG = "DiscoverFragment";

    /**
     * viewpager的适配器
     */
    class MyAdapter extends FragmentPagerAdapter {
        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
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