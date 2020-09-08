package com.example.tongpao.presenter.home;

import com.example.tongpao.base.BasePresenter;
import com.example.tongpao.bean.PerArticleBean;
import com.example.tongpao.bean.PerCommunityBean;
import com.example.tongpao.bean.PerInfoBean;
import com.example.tongpao.common.CommonSubscriber;
import com.example.tongpao.constract.home.IHome.IPerInfoPresenter;
import com.example.tongpao.constract.home.IHome.IPerInfoView;
import com.example.tongpao.util.HttpUtil;
import com.example.tongpao.util.RxUtils;

public class PerInfoPresenter extends BasePresenter<IPerInfoView> implements IPerInfoPresenter {
    @Override
    public void getPersonal(String url) {
        addSubscribe(HttpUtil.getInstance().getApiService().getPerInfo(url).compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<PerInfoBean>(view) {
                    @Override
                    public void onNext(PerInfoBean perInfoBean) {
                        view.setPersonal(perInfoBean);
                    }
                }));
    }

    @Override
    public void getCommunity(String url) {
        HttpUtil.getInstance().getApiService().getPerCommunity(url).compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<PerCommunityBean>(view) {
                    @Override
                    public void onNext(PerCommunityBean communityBean) {
                        view.setCommunity(communityBean);
                    }
                });
    }

    @Override
    public void getArticle(String url) {
        HttpUtil.getInstance().getApiService().getPerArticle(url).compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<PerArticleBean>(view) {
                    @Override
                    public void onNext(PerArticleBean articleBean) {
                        view.setArticle(articleBean);
                    }
                });

    }
}
