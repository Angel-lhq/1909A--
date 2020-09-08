package com.example.tongpao.presenter.discover;

import com.example.tongpao.base.BasePresenter;
import com.example.tongpao.bean.discover.DiscoverRankMoneyBean;
import com.example.tongpao.common.CommonSubscriber;
import com.example.tongpao.constract.discover.IRankMoney;
import com.example.tongpao.util.HttpUtil;
import com.example.tongpao.util.RxUtils;

public class DiscoverRankMoneyPresenter extends BasePresenter<IRankMoney.IRankMoneyView> implements IRankMoney.IRankMoneyPresenter {
    @Override
    public void getIRankMoney() {
        addSubscribe(HttpUtil.getInstance().getApiService().getMoney()
        .compose(RxUtils.rxScheduler())
        .subscribeWith(new CommonSubscriber<DiscoverRankMoneyBean>(view) {
            @Override
            public void onNext(DiscoverRankMoneyBean discoverRankMoneyBean) {
                view.getIRankMoneyReturn(discoverRankMoneyBean);
            }
        }));
    }
}
