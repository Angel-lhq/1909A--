package com.example.tongpao.presenter.discover;

import com.example.tongpao.base.BasePresenter;
import com.example.tongpao.bean.discover.DiscoverRankSignBean;
import com.example.tongpao.common.CommonSubscriber;
import com.example.tongpao.constract.discover.IRanksign;
import com.example.tongpao.util.HttpUtil;
import com.example.tongpao.util.RxUtils;

public class DiscoverRankSignPresenter extends BasePresenter<IRanksign.IRanksignView> implements IRanksign.IRanksignPresenter {
    @Override
    public void getIRanksignPresenter() {
        addSubscribe(HttpUtil.getInstance().getApiService().getSign()
        .compose(RxUtils.rxScheduler())
        .subscribeWith(new CommonSubscriber<DiscoverRankSignBean>(view) {
            @Override
            public void onNext(DiscoverRankSignBean discoverRankSignBean) {
                view.getIRanksignReturn(discoverRankSignBean);
            }
        }));
    }
}
