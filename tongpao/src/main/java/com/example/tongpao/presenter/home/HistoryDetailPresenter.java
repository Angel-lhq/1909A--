package com.example.tongpao.presenter.home;

import com.example.tongpao.base.BasePresenter;
import com.example.tongpao.bean.HistoryDetailBean;
import com.example.tongpao.common.CommonSubscriber;
import com.example.tongpao.constract.home.IHome;
import com.example.tongpao.util.HttpUtil;
import com.example.tongpao.util.RxUtils;

public class HistoryDetailPresenter extends BasePresenter<IHome.IHistoryDetailView> implements IHome.IHistoryDetailPresenter {
    @Override
    public void getHistoryDetail(String url) {
        addSubscribe(HttpUtil.getInstance()
                .getApiService()
                .getHistoryDetail(url)
                .compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<HistoryDetailBean>(view) {
                    @Override
                    public void onNext(HistoryDetailBean historyDetailBean) {
                        view.setHistoryDetail(historyDetailBean);
                    }
                }));
    }
}
