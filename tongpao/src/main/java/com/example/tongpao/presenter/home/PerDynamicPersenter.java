package com.example.tongpao.presenter.home;

import com.example.tongpao.base.BasePresenter;
import com.example.tongpao.bean.PerDynamicStateBean;
import com.example.tongpao.common.CommonSubscriber;
import com.example.tongpao.constract.home.IHome;
import com.example.tongpao.util.HttpUtil;
import com.example.tongpao.util.RxUtils;

public class PerDynamicPersenter extends BasePresenter<IHome.IPerDynamicView> implements IHome.IPerDynamicPresenter {
    @Override
    public void getDynamic(String url) {
        HttpUtil.getInstance().getApiService().getPerDynamic(url)
                .compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<PerDynamicStateBean>(view) {
                    @Override
                    public void onNext(PerDynamicStateBean perDynamicStateBean) {
                        view.setDynamic(perDynamicStateBean);
                    }
                });
    }
}
