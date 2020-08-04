package com.example.day01_8_1_1;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day01_8_1_1.base.BaseActivity;
import com.example.day01_8_1_1.home.adapter.InfoAdapter;
import com.example.day01_8_1_1.home.bean.GirlBean;
import com.example.day01_8_1_1.home.contract.Contract;
import com.example.day01_8_1_1.home.presenter.Presenter;

import java.util.List;

public class MainActivity extends BaseActivity<Presenter> implements Contract.IView {

    private RecyclerView tv;
    private InfoAdapter infoAdapter;

    @Override
    protected void initData() {
        mPresenter.getData("https://gank.io/api/data/%E7%A6%8F%E5%88%A9/20/2");
    }

    @Override
    protected Presenter initPresenter() {
        return new Presenter();
    }

    @Override
    protected void initView() {
        tv = findViewById(R.id.tv);
        tv.setLayoutManager(new LinearLayoutManager(this));
        tv.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        infoAdapter = new InfoAdapter(this);
        tv.setAdapter(infoAdapter);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    private static final String TAG = "llhhqq";

    @Override
    public void setData(GirlBean girlBean) {
        List<GirlBean.ResultsBean> results = girlBean.getResults();
        infoAdapter.setList(results);
    }
}