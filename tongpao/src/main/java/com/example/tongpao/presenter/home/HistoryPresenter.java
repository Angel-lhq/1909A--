package com.example.tongpao.presenter.home;

import com.example.tongpao.base.BasePresenter;
import com.example.tongpao.bean.HistoryBean;
import com.example.tongpao.common.CommonSubscriber;
import com.example.tongpao.constract.home.IHome;
import com.example.tongpao.util.HttpUtil;
import com.example.tongpao.util.RxUtils;

public class HistoryPresenter extends BasePresenter<IHome.IHistoryView> implements IHome.IHistoryPresenter {
    @Override
    public void getHistory(String url) {
        addSubscribe(HttpUtil.getInstance()
                .getApiService()
                .getHistory(url)
                .compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<HistoryBean>(view) {
                    @Override
                    public void onNext(HistoryBean historyBean) {
                        view.setHistory(historyBean);
                    }
                }));
    }
}
