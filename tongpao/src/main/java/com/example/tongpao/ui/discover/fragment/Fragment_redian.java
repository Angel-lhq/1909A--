package com.example.tongpao.ui.discover.fragment;


import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tongpao.R;
import com.example.tongpao.adapter.discover.DiscoverRedianAdapter;
import com.example.tongpao.base.BaseFragment;
import com.example.tongpao.bean.discover.DiscoverRedianBean;
import com.example.tongpao.constract.discover.IRedian;
import com.example.tongpao.presenter.discover.DiscoverRedianPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

//热点
public class Fragment_redian extends BaseFragment<IRedian.IRedianPresenter> implements IRedian.IRedianiew {
    @BindView(R.id.rv_redian)
    RecyclerView rvRedian;
    private List<DiscoverRedianBean.DataBean.ListBean> list;
    private DiscoverRedianAdapter adapter;

    @Override
    protected int getLayout() {
        return R.layout.fragment_discover_redian;
    }

    @Override
    protected void initView(View view) {
        list = new ArrayList<>();
        adapter = new DiscoverRedianAdapter(context);
        rvRedian.setLayoutManager(new LinearLayoutManager(context));
        rvRedian.setAdapter(adapter);
    }

    @Override
    protected IRedian.IRedianPresenter initPresenter() {
        return new DiscoverRedianPresenter();
    }

    @Override
    protected void initData() {
        presneter.getIRedian();
    }

    @Override
    public void getIredianReturn(DiscoverRedianBean discoverRedianBean) {
        adapter.setList(discoverRedianBean.getData().getList());
    }
}
