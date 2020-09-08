package com.example.tongpao.ui.discover.fragment;

import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tongpao.R;
import com.example.tongpao.adapter.discover.DiscoerSignAdapter;
import com.example.tongpao.base.BaseFragment;
import com.example.tongpao.bean.discover.DiscoverRankSignBean;
import com.example.tongpao.constract.discover.IRanksign;
import com.example.tongpao.presenter.discover.DiscoverRankSignPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

//排行 签到帮
public class Fragment_rank_sign extends BaseFragment<IRanksign.IRanksignPresenter> implements IRanksign.IRanksignView {
    @BindView(R.id.rv_ranksign)
    RecyclerView rvRanksign;
    private List<DiscoverRankSignBean.DataBean.SignTopBean.ListBean> list;
    private DiscoerSignAdapter adapter;

    @Override
    protected int getLayout() {
        return R.layout.fragment_discover_rank_sign;
    }

    @Override
    protected void initView(View view) {
        list = new ArrayList<>();
        adapter = new DiscoerSignAdapter(context);
        rvRanksign.setLayoutManager(new LinearLayoutManager(context));
        rvRanksign.setAdapter(adapter);
    }

    @Override
    protected IRanksign.IRanksignPresenter initPresenter() {
        return new DiscoverRankSignPresenter();
    }

    @Override
    protected void initData() {
        presneter.getIRanksignPresenter();
    }

    @Override
    public void getIRanksignReturn(DiscoverRankSignBean discoverRankSignBean) {
        adapter.setData(discoverRankSignBean.getData().getSignTop().getList());
    }
}
