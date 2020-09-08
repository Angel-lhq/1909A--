package com.example.mallshop.presenters.home;

import com.example.mallshop.base.BasePresenter;
import com.example.mallshop.bean.home.ContentBean;
import com.example.mallshop.common.CommonSubscriber;
import com.example.mallshop.constract.home.IHome;
import com.example.mallshop.utils.HttpUtil;
import com.example.mallshop.utils.RxUtils;

public class HomeContentPresenter extends BasePresenter<IHome.IHomeContentView> implements IHome.IHomeContentPresenter {
    @Override
    public void getContent(String url) {
        addSubscribe(HttpUtil.getInstance()
                .getApiService()
                .getContent(url)
                .compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<ContentBean>(view) {
                    @Override
                    public void onNext(ContentBean contentBean) {
                        view.setContent(contentBean);
                    }
                }));
    }
}
