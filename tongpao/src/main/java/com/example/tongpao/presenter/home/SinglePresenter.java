package com.example.tongpao.presenter.home;

import com.example.tongpao.base.BasePresenter;
import com.example.tongpao.bean.SingleBean;
import com.example.tongpao.common.CommonSubscriber;
import com.example.tongpao.constract.home.IHome;
import com.example.tongpao.util.HttpUtil;
import com.example.tongpao.util.RxUtils;

public class SinglePresenter extends BasePresenter<IHome.ISingleView> implements IHome.ISinglePresenter {
    @Override
    public void getSingle(String url) {
        addSubscribe(
                HttpUtil.getInstance()
                        .getApiService()
                        .getSingle(url)
                        .compose(RxUtils.rxScheduler())
                        .subscribeWith(new CommonSubscriber<SingleBean>(view) {
                            @Override
                            public void onNext(SingleBean singleBean) {
                                view.setSingle(singleBean);
                            }
                        }));
    }
}
