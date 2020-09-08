package com.example.tongpao.ui.discover.fragment;


import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tongpao.R;
import com.example.tongpao.adapter.discover.DiscoverZhuangzaoAdapter;
import com.example.tongpao.base.BaseFragment;
import com.example.tongpao.bean.discover.DiscoverZhuangzaoBean;
import com.example.tongpao.constract.discover.IZhuangzao;
import com.example.tongpao.presenter.discover.DiscoverZhuangzaoPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

//妆造
public class Fragment_zhuangzao extends BaseFragment<IZhuangzao.IZhuangzaoPresenter> implements IZhuangzao.IZhuangzaoView {
    @BindView(R.id.rv_zhuangzao)
    RecyclerView rvZhuangzao;
    private List<DiscoverZhuangzaoBean.DataBean.ListBean> list;
    private DiscoverZhuangzaoAdapter adapter;

    @Override
    protected int getLayout() {
        return R.layout.fragment_discover_zhuangzao;
    }

    @Override
    protected void initView(View view) {
        list = new ArrayList<>();
        adapter = new DiscoverZhuangzaoAdapter(context);
        rvZhuangzao.setLayoutManager(new LinearLayoutManager(context));
        rvZhuangzao.setAdapter(adapter);
    }

    @Override
    protected IZhuangzao.IZhuangzaoPresenter initPresenter() {
        return new DiscoverZhuangzaoPresenter();
    }

    @Override
    protected void initData() {
        presneter.getIZhuangzao();
    }

    @Override
    public void getIZhuangzaoReturn(DiscoverZhuangzaoBean discoverZhuangzaoBean) {
        adapter.setList(discoverZhuangzaoBean.getData().getList());
    }
}
