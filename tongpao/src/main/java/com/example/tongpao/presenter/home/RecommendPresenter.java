package com.example.tongpao.presenter.home;

import com.example.tongpao.base.BasePresenter;
import com.example.tongpao.bean.BannerBean;
import com.example.tongpao.bean.HotTopicBean;
import com.example.tongpao.bean.RecommendBean;
import com.example.tongpao.common.CommonSubscriber;
import com.example.tongpao.constract.home.IHome;
import com.example.tongpao.constract.home.IHome.IRecommendPresenter;
import com.example.tongpao.util.HttpUtil;
import com.example.tongpao.util.RxUtils;

public class RecommendPresenter extends BasePresenter<IHome.IRecommendView> implements IRecommendPresenter {
    @Override
    public void getBanner(String url) {
        addSubscribe(HttpUtil.getInstance().getApiService().getBanner(url).compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<BannerBean>(view) {
                    @Override
                    public void onNext(BannerBean bannerBean) {
                        view.setBanner(bannerBean);
                    }
                }));
    }

    @Override
    public void getRecommend(String url) {
        addSubscribe(HttpUtil.getInstance().getApiService().getRecommend(url).compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<RecommendBean>(view) {
                    @Override
                    public void onNext(RecommendBean recommendBean) {
                        view.setRecommend(recommendBean);
                    }
                }));
    }

    @Override
    public void getHotUser(String url) {

    }

    @Override
    public void getHotTopic(String url) {
        addSubscribe(HttpUtil.getInstance().getApiService().getHotTopic(url).compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<HotTopicBean>(view) {
                    @Override
                    public void onNext(HotTopicBean hotTopicBean) {
                        view.setHotTopic(hotTopicBean);
                    }
                }));
    }
}
