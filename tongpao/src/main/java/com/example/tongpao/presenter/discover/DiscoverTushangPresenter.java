package com.example.tongpao.presenter.discover;

import com.example.tongpao.base.BasePresenter;
import com.example.tongpao.bean.discover.DiscoverTushangBean;
import com.example.tongpao.common.CommonSubscriber;
import com.example.tongpao.constract.discover.ITushang;
import com.example.tongpao.util.HttpUtil;
import com.example.tongpao.util.RxUtils;

public class DiscoverTushangPresenter extends BasePresenter<ITushang.getITushangView> implements ITushang.getITushangPresenter {
    @Override
    public void getITushang() {
        addSubscribe(HttpUtil.getInstance().getApiService().getTushang()
                .compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<DiscoverTushangBean>(view){
                    @Override
                    public void onNext(DiscoverTushangBean discoverTushangBean) {
                        view.getITushangReturn(discoverTushangBean);
                    }
                }));
    }
}
