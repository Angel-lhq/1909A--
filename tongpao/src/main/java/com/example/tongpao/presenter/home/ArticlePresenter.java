package com.example.tongpao.presenter.home;

import com.example.tongpao.base.BasePresenter;
import com.example.tongpao.bean.ArticleBean;
import com.example.tongpao.common.CommonSubscriber;
import com.example.tongpao.constract.home.IHome;
import com.example.tongpao.util.HttpUtil;
import com.example.tongpao.util.RxUtils;

public class ArticlePresenter extends BasePresenter<IHome.IArticleView> implements IHome.IArticlePresenter {
    @Override
    public void getArticle(String url) {
        addSubscribe(HttpUtil.getInstance().getApiService()
                .getArticle(url)
                .compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<ArticleBean>(view) {
                    @Override
                    public void onNext(ArticleBean articleBean) {
                        view.setArticle(articleBean);
                    }
                }));
    }
}
