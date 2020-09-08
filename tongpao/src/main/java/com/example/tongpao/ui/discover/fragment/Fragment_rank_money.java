package com.example.tongpao.ui.discover.fragment;

import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tongpao.R;
import com.example.tongpao.adapter.discover.DiscoerMoneyAdapter;
import com.example.tongpao.base.BaseFragment;
import com.example.tongpao.bean.discover.DiscoverRankMoneyBean;
import com.example.tongpao.constract.discover.IRankMoney;
import com.example.tongpao.presenter.discover.DiscoverRankMoneyPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

//排行 土豪帮
public class Fragment_rank_money extends BaseFragment<IRankMoney.IRankMoneyPresenter> implements IRankMoney.IRankMoneyView {
    @BindView(R.id.rv_rankmoney)
    RecyclerView rvRankmoney;
    private List<DiscoverRankMoneyBean.DataBean.TongQianTopBean.ListBean> list;
    private DiscoerMoneyAdapter adapter;

    @Override
    protected int getLayout() {
        return R.layout.fragment_discover_rank_money;
    }

    @Override
    protected void initView(View view) {
        list = new ArrayList<>();
        adapter = new DiscoerMoneyAdapter(context);
        rvRankmoney.setLayoutManager(new LinearLayoutManager(context));
        rvRankmoney.setAdapter(adapter);
    }

    @Override
    protected IRankMoney.IRankMoneyPresenter initPresenter() {
        return new DiscoverRankMoneyPresenter();
    }

    @Override
    protected void initData() {
        presneter.getIRankMoney();
    }

    @Override
    public void getIRankMoneyReturn(DiscoverRankMoneyBean discoverRankMoneyBean) {
        adapter.setData(discoverRankMoneyBean.getData().getTongQianTop().getList());
    }
}
