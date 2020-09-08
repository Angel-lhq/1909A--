package com.example.tongpao.presenter.discover;


import com.example.tongpao.base.BasePresenter;
import com.example.tongpao.bean.discover.DiscoverBaikeBean;
import com.example.tongpao.common.CommonSubscriber;
import com.example.tongpao.constract.discover.IBaike;
import com.example.tongpao.util.HttpUtil;
import com.example.tongpao.util.RxUtils;

public class DiscoverBaikePresenter extends BasePresenter<IBaike.IBaikeView> implements IBaike.IBaikePresenter {
    @Override
    public void getIbaike() {
        addSubscribe(HttpUtil.getInstance().getApiService().getBaike()
        .compose(RxUtils.rxScheduler())
        .subscribeWith(new CommonSubscriber<DiscoverBaikeBean>(view) {
            @Override
            public void onNext(DiscoverBaikeBean discoverBaikeBean) {
                view.getIBaikeReturn(discoverBaikeBean);
            }
        }));
    }
}
