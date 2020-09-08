package com.example.tongpao.presenter.discover;

import com.example.tongpao.base.BasePresenter;
import com.example.tongpao.bean.discover.NearByBean;
import com.example.tongpao.bean.discover.RoommateBean;
import com.example.tongpao.common.CommonSubscriber;
import com.example.tongpao.constract.discover.IFind;
import com.example.tongpao.util.HttpUtil;
import com.example.tongpao.util.RxUtils;

public class RoommatePresenter extends BasePresenter<IFind.DisView> implements IFind.DisPresenter {
    @Override
    public void getRoommateData() {
        addSubscribe(
                HttpUtil.getInstance().getApiService().getRoommate()
                        .compose(RxUtils.rxScheduler())
                        .subscribeWith(new CommonSubscriber<RoommateBean>(view) {
                            @Override
                            public void onNext(RoommateBean roommateBean) {
                                view.getRoommateReturn(roommateBean);
                            }
                        })
        );
    }

    @Override
    public void getNearByData() {
        addSubscribe(
                HttpUtil.getInstance().getApiService().getNearBeanData()
                        .compose(RxUtils.rxScheduler())
                        .subscribeWith(new CommonSubscriber<NearByBean>(view) {
                            @Override
                            public void onNext(NearByBean nearByBean) {
                                view.getNearByReturn(nearByBean);
                            }
                        })
        );
    }
}
