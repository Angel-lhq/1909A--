package com.example.tongpao.presenter.home;

import com.example.tongpao.base.BasePresenter;
import com.example.tongpao.bean.SquareBean;
import com.example.tongpao.common.CommonSubscriber;
import com.example.tongpao.constract.home.IHome;
import com.example.tongpao.util.HttpUtil;
import com.example.tongpao.util.RxUtils;

public class SquarePresenter extends BasePresenter<IHome.ISquareView> implements IHome.ISquarePresenter {
    @Override
    public void getSquare(String url) {
        addSubscribe(HttpUtil.getInstance()
                .getApiService()
                .getSqare(url)
                .compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<SquareBean>(view) {
                    @Override
                    public void onNext(SquareBean squareBean) {
                        view.setSquare(squareBean);
                    }
                })
        );
    }
}
