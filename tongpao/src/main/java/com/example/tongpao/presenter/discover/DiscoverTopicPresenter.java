package com.example.tongpao.presenter.discover;


import com.example.tongpao.base.BasePresenter;
import com.example.tongpao.bean.discover.DisCoverTopicBean;
import com.example.tongpao.common.CommonSubscriber;
import com.example.tongpao.constract.discover.IDiscover;
import com.example.tongpao.util.HttpUtil;
import com.example.tongpao.util.RxUtils;

public class DiscoverTopicPresenter extends BasePresenter<IDiscover.DiscoverView> implements IDiscover.DiscoerPresenter {
    @Override
    public void getTopic() {
        addSubscribe(HttpUtil.getInstance().getApiService().getDiscoverTopic()

                .compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<DisCoverTopicBean>(view){

                    @Override
                    public void onNext(DisCoverTopicBean disCoverTopicBean) {
                        view.getTopicReturn(disCoverTopicBean);
                    }
                }));
    }
}
