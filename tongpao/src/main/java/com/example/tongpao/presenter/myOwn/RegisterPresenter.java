package com.example.tongpao.presenter.myOwn;

import com.example.tongpao.base.BasePresenter;
import com.example.tongpao.bean.UserRegisterBean;
import com.example.tongpao.common.CommonSubscriber;
import com.example.tongpao.constract.myOwn.IMyOwn;
import com.example.tongpao.util.HttpUtil;
import com.example.tongpao.util.RxUtils;

import java.util.Map;

public class RegisterPresenter extends BasePresenter<IMyOwn.IRegisterView> implements IMyOwn.IRegisterPresenter {
    @Override
    public void register(Map<String, String> map) {
        addSubscribe(HttpUtil.getInstance()
                .getUserApi()
                .register(map)
                .compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<UserRegisterBean>(view) {
                    @Override
                    public void onNext(UserRegisterBean userRegisterBean) {
                        view.registerReturn(userRegisterBean);
                    }
                }));
    }
}
