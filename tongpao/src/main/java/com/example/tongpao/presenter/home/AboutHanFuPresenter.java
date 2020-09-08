package com.example.tongpao.presenter.home;

import com.example.tongpao.base.BasePresenter;
import com.example.tongpao.bean.AboutHanFuBean;
import com.example.tongpao.common.CommonSubscriber;
import com.example.tongpao.constract.home.IHome;
import com.example.tongpao.util.HttpUtil;
import com.example.tongpao.util.RxUtils;

public class AboutHanFuPresenter extends BasePresenter<IHome.IAboutHanFuView> implements IHome.IAboutHanFuPresenter {
    @Override
    public void getAboutHanFu(String url) {
        addSubscribe(HttpUtil.getInstance()
                .getApiService()
                .getAboutHanFu(url)
                .compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<AboutHanFuBean>(view) {
                    @Override
                    public void onNext(AboutHanFuBean aboutHanFuBean) {
                        view.setAboutHanFu(aboutHanFuBean);
                    }
                }));
    }
}
