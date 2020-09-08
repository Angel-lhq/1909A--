package com.example.tongpao.presenter.home;

import com.example.tongpao.base.BasePresenter;
import com.example.tongpao.bean.RewardBean;
import com.example.tongpao.common.CommonSubscriber;
import com.example.tongpao.constract.home.IHome;
import com.example.tongpao.util.HttpUtil;
import com.example.tongpao.util.RxUtils;

public class RewardPresenter extends BasePresenter<IHome.IRewardView> implements IHome.IRewardPresenter {
    @Override
    public void getReward(String url) {
        addSubscribe(
                HttpUtil.getInstance()
                        .getApiService()
                        .getReward(url)
                        .compose(RxUtils.rxScheduler())
                        .subscribeWith(new CommonSubscriber<RewardBean>(view) {
                            @Override
                            public void onNext(RewardBean rewardBean) {
                                view.setReward(rewardBean);
                            }
                        })
        );
    }
}
