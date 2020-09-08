package com.example.tongpao.ui.discover.fragment;

import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tongpao.R;
import com.example.tongpao.adapter.discover.DiscoverTushangAdapter;
import com.example.tongpao.base.BaseFragment;
import com.example.tongpao.bean.discover.DiscoverTushangBean;
import com.example.tongpao.constract.discover.ITushang;
import com.example.tongpao.presenter.discover.DiscoverTushangPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class Fragment_tushang extends BaseFragment<ITushang.getITushangPresenter> implements ITushang.getITushangView {

    @BindView(R.id.rv_tushang)
    RecyclerView rvTushang;
    private List<DiscoverTushangBean.DataBean.ListBean> list;
    private DiscoverTushangAdapter adapter;

    @Override
    protected int getLayout() {
        return R.layout.fragment_discover_tushang;
    }

    @Override
    protected void initView(View view) {
        list = new ArrayList<>();
        adapter = new DiscoverTushangAdapter(context);
        rvTushang.setLayoutManager(new LinearLayoutManager(context));
        rvTushang.setAdapter(adapter);

    }

    @Override
    protected ITushang.getITushangPresenter initPresenter() {
        return new DiscoverTushangPresenter();
    }

    @Override
    protected void initData() {
        presneter.getITushang();
    }

    @Override
    public void getITushangReturn(DiscoverTushangBean discoverTushangBean) {
        adapter.setList(discoverTushangBean.getData().getList());
    }
}
