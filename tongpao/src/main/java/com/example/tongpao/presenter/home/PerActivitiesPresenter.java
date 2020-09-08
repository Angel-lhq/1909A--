package com.example.tongpao.presenter.home;

import com.example.tongpao.base.BasePresenter;
import com.example.tongpao.bean.PerActiviesBean;
import com.example.tongpao.common.CommonSubscriber;
import com.example.tongpao.constract.home.IHome;
import com.example.tongpao.util.HttpUtil;
import com.example.tongpao.util.RxUtils;

public class PerActivitiesPresenter extends BasePresenter<IHome.IPerActivitiesView> implements IHome.IPerActivitiesPresenter {
    @Override
    public void getActivities(String url) {
        addSubscribe(HttpUtil.getInstance().getApiService().getPerActivities(url).compose(RxUtils.rxScheduler()).subscribeWith(new CommonSubscriber<PerActiviesBean>(view) {
            @Override
            public void onNext(PerActiviesBean perCommunityBean) {
                view.setActivities(perCommunityBean);
            }
        }));
    }
}
