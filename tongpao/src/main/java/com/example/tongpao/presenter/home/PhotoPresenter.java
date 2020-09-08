package com.example.tongpao.presenter.home;

import com.example.tongpao.base.BasePresenter;
import com.example.tongpao.bean.PhotoBean;
import com.example.tongpao.common.CommonSubscriber;
import com.example.tongpao.constract.home.IHome;
import com.example.tongpao.util.HttpUtil;
import com.example.tongpao.util.RxUtils;

public class PhotoPresenter extends BasePresenter<IHome.IPhotoView> implements IHome.IPhotoPresenter {
    @Override
    public void getPhoto(String url) {
        addSubscribe(HttpUtil.getInstance().getApiService()
                .getPhoto(url)
                .compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<PhotoBean>(view) {
                    @Override
                    public void onNext(PhotoBean photoBean) {
                        view.setPhoto(photoBean);
                    }
                }));
    }
}
