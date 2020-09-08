package com.example.tongpao.ui.discover.fragment;

import android.util.Log;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tongpao.R;
import com.example.tongpao.adapter.discover.DiscoerLevelAdapter;
import com.example.tongpao.base.BaseFragment;
import com.example.tongpao.bean.discover.DiscoverranklevelBean;
import com.example.tongpao.constract.discover.ILevel;
import com.example.tongpao.presenter.discover.DiscoverLevelPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

//排行 等级榜
public class Fragment_rank_level extends BaseFragment<ILevel.ILevelPresenter> implements ILevel.ILeveliew {

    @BindView(R.id.rv_level)
    RecyclerView rvLevel;
    private List<DiscoverranklevelBean.DataBean.ExpTopBean.ListBean> list;
    private DiscoerLevelAdapter adapter;

    @Override
    protected int getLayout() {
        return R.layout.fragment_discover_rank_level;
    }

    @Override
    protected void initView(View view) {
        list = new ArrayList<>();
        adapter = new DiscoerLevelAdapter(context);
        rvLevel.setLayoutManager(new LinearLayoutManager(context));
        rvLevel.setAdapter(adapter);
    }

    @Override
    protected ILevel.ILevelPresenter initPresenter() {
        return new DiscoverLevelPresenter();
    }

    @Override
    protected void initData() {
        presneter.getLevel();
    }

    @Override
    public void getLevelReturn(DiscoverranklevelBean discoverranklevelBean) {
        Log.d(TAG, "getLevelReturn: "+discoverranklevelBean.toString());
        adapter.setData(discoverranklevelBean.getData().getExpTop().getList());

    }

    private static final String TAG = "Fragment_rank_level";
}
