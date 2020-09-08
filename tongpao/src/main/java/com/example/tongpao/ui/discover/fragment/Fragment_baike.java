package com.example.tongpao.ui.discover.fragment;

import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tongpao.R;
import com.example.tongpao.adapter.discover.DiscoverBaikeAdapter;
import com.example.tongpao.base.BaseFragment;
import com.example.tongpao.bean.discover.DiscoverBaikeBean;
import com.example.tongpao.constract.discover.IBaike;
import com.example.tongpao.presenter.discover.DiscoverBaikePresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class Fragment_baike extends BaseFragment<IBaike.IBaikePresenter> implements IBaike.IBaikeView {
    @BindView(R.id.rv_baike)
    RecyclerView rvBaike;
    private List<DiscoverBaikeBean.DataBean.ListBean> list;
    private DiscoverBaikeAdapter adapter;

    @Override
    protected int getLayout() {
        return R.layout.fragment_discover_baike;
    }

    @Override
    protected void initView(View view) {
        list = new ArrayList<>();
        adapter = new DiscoverBaikeAdapter(context);
        rvBaike.setLayoutManager(new LinearLayoutManager(context));
        rvBaike.setAdapter(adapter);
    }

    @Override
    protected IBaike.IBaikePresenter initPresenter() {
        return new DiscoverBaikePresenter();
    }

    @Override
    protected void initData() {
        presneter.getIbaike();
    }

    @Override
    public void getIBaikeReturn(DiscoverBaikeBean discoverBaikeBean) {
        adapter.setList(discoverBaikeBean.getData().getList());
    }
}
