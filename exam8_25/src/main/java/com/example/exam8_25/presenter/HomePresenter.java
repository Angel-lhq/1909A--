package com.example.exam8_25.presenter;

import com.example.exam8_25.base.BasePresenter;
import com.example.exam8_25.bean.HotPostBean;
import com.example.exam8_25.bean.HotTopicBean;
import com.example.exam8_25.bean.HotUserBean;
import com.example.exam8_25.common.CommonSubscriber;
import com.example.exam8_25.constract.IHome;
import com.example.exam8_25.util.HttpUtil;
import com.example.exam8_25.util.RxUtils;

public class HomePresenter extends BasePresenter<IHome.IHomeView> implements IHome.IHomePresenter {
    @Override
    public void getHotTopic(String url) {
        addSubscribe(HttpUtil.getInstance()
                .getApiService()
                .getHotTopic(url)
                .compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<HotTopicBean>(view) {
                    @Override
                    public void onNext(HotTopicBean hotTopicBean) {
                        view.setHotTopic(hotTopicBean);
                    }
                }));
    }

    @Override
    public void getHotPost(String url) {
        addSubscribe(HttpUtil.getInstance()
                .getApiService()
                .getHotPost(url)
                .compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<HotPostBean>(view) {
                    @Override
                    public void onNext(HotPostBean hotPostBean) {
                        view.setHotPost(hotPostBean);
                    }
                }));
    }

    @Override
    public void getHotUser(String url) {
        addSubscribe(HttpUtil.getInstance()
                .getApiService()
                .getHotUser(url)
                .compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<HotUserBean>(view) {
                    @Override
                    public void onNext(HotUserBean hotUserBean) {
                        view.setHotUser(hotUserBean);
                    }
                }));
    }
}
