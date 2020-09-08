package com.example.tongpao.presenter.home;

import com.example.tongpao.base.BasePresenter;
import com.example.tongpao.bean.VideoBean;
import com.example.tongpao.common.CommonSubscriber;
import com.example.tongpao.constract.home.IHome;
import com.example.tongpao.util.HttpUtil;
import com.example.tongpao.util.RxUtils;

public class VideoPresenter extends BasePresenter<IHome.IVideoView> implements IHome.IVideoPresenter {
    @Override
    public void getVideo(String url) {
        addSubscribe(
                HttpUtil.getInstance()
                        .getApiService()
                        .getVideo(url)
                        .compose(RxUtils.rxScheduler())
                        .subscribeWith(new CommonSubscriber<VideoBean>(view) {
                            @Override
                            public void onNext(VideoBean videoBean) {
                                view.setVideo(videoBean);
                            }
                        })
        );
    }
}
