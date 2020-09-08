package com.example.tongpao.ui.home.homefragments;

import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tongpao.R;
import com.example.tongpao.adapter.InfoRewardAdapter;
import com.example.tongpao.base.BaseFragment;
import com.example.tongpao.bean.RewardBean;
import com.example.tongpao.constract.home.IHome;
import com.example.tongpao.presenter.home.RewardPresenter;

import butterknife.BindView;

public class RewardFragment extends BaseFragment<IHome.IRewardPresenter> implements IHome.IRewardView {
    @BindView(R.id.rcl_reward)
    RecyclerView rclReward;
    private InfoRewardAdapter infoRewardAdapter;

    @Override
    protected IHome.IRewardPresenter initPresenter() {
        return new RewardPresenter();
    }

    @Override
    protected void initData() {
        presneter.getReward("home/reward.json");
    }

    @Override
    protected void initView(View view) {
        rclReward.setLayoutManager(new LinearLayoutManager(context));
        infoRewardAdapter = new InfoRewardAdapter(context);
        rclReward.setAdapter(infoRewardAdapter);
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_reward;
    }

    @Override
    public void setReward(RewardBean rewardBean) {
        infoRewardAdapter.setData(rewardBean.getData().getList());
    }
}
