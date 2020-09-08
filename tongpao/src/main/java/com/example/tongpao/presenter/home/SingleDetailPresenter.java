package com.example.tongpao.presenter.home;

import com.example.tongpao.base.BasePresenter;
import com.example.tongpao.bean.SingleDetailBean;
import com.example.tongpao.common.CommonSubscriber;
import com.example.tongpao.constract.home.IHome;
import com.example.tongpao.util.HttpUtil;
import com.example.tongpao.util.RxUtils;

public class SingleDetailPresenter extends BasePresenter<IHome.ISingleDetailView> implements IHome.ISingleDetailPresenter {
    @Override
    public void getSingleDetail(String url) {
        addSubscribe(HttpUtil.getInstance()
                .getApiService()
                .getSingleDetail(url)
                .compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<SingleDetailBean>(view) {
                    @Override
                    public void onNext(SingleDetailBean singleDetailBean) {
                        view.setSingleDetail(singleDetailBean);
                    }
                }));
    }
}
