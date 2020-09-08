package com.example.tongpao.presenter.home;

import com.example.tongpao.base.BasePresenter;
import com.example.tongpao.bean.AboutHanFuDetailBean;
import com.example.tongpao.common.CommonSubscriber;
import com.example.tongpao.constract.home.IHome;
import com.example.tongpao.util.HttpUtil;
import com.example.tongpao.util.RxUtils;

public class AboutHanFuDetailPresenter extends BasePresenter<IHome.IAboutHanFuDetailView> implements IHome.IAboutHanFuDetailPresenter {
    @Override
    public void getAboutHanFuDetail(String url) {
        addSubscribe(HttpUtil.getInstance()
                .getApiService()
                .getAboutHanFuDetail(url)
                .compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<AboutHanFuDetailBean>(view) {
                    @Override
                    public void onNext(AboutHanFuDetailBean aboutHanFuDetailBean) {
                        view.setAboutHanFuDetail(aboutHanFuDetailBean);
                    }
                }));
    }
}
