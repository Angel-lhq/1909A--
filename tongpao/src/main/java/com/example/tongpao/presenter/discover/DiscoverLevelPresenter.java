package com.example.tongpao.presenter.discover;

import com.example.tongpao.base.BasePresenter;
import com.example.tongpao.bean.discover.DiscoverranklevelBean;
import com.example.tongpao.common.CommonSubscriber;
import com.example.tongpao.constract.discover.ILevel;
import com.example.tongpao.util.HttpUtil;
import com.example.tongpao.util.RxUtils;

public class DiscoverLevelPresenter extends BasePresenter<ILevel.ILeveliew> implements ILevel.ILevelPresenter  {
    @Override
    public void getLevel() {
        addSubscribe(HttpUtil.getInstance().getApiService().getLevel()
                .compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<DiscoverranklevelBean>(view){
                    @Override
                    public void onNext(DiscoverranklevelBean discoverranklevelBean) {
                        view.getLevelReturn(discoverranklevelBean);
                    }
                }));
    }
}
