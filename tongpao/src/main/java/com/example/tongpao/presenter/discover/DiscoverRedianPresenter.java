package com.example.tongpao.presenter.discover;


import com.example.tongpao.base.BasePresenter;
import com.example.tongpao.bean.discover.DiscoverRedianBean;
import com.example.tongpao.common.CommonSubscriber;
import com.example.tongpao.constract.discover.IRedian;
import com.example.tongpao.util.HttpUtil;
import com.example.tongpao.util.RxUtils;

public class DiscoverRedianPresenter extends BasePresenter<IRedian.IRedianiew> implements IRedian.IRedianPresenter {
    @Override
    public void getIRedian() {
        addSubscribe(HttpUtil.getInstance().getApiService().getRedian()
                .compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<DiscoverRedianBean>(view){
                    @Override
                    public void onNext(DiscoverRedianBean discoverRedianBean) {
                        view.getIredianReturn(discoverRedianBean);
                    }
                }));
    }
}
