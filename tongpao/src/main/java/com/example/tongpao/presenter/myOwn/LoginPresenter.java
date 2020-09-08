package com.example.tongpao.presenter.myOwn;

import com.example.tongpao.base.BasePresenter;
import com.example.tongpao.bean.UserLoginBean;
import com.example.tongpao.common.CommonSubscriber;
import com.example.tongpao.constract.myOwn.IMyOwn;
import com.example.tongpao.util.HttpUtil;
import com.example.tongpao.util.RxUtils;

import java.util.Map;

public class LoginPresenter extends BasePresenter<IMyOwn.ILoginView> implements IMyOwn.ILoginPresenter {
    @Override
    public void login(Map<String, String> map) {
        addSubscribe(HttpUtil.getInstance().getUserApi()
                .login(map)
                .compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<UserLoginBean>(view) {
                    @Override
                    public void onNext(UserLoginBean userLoginBean) {
                        view.loginReturn(userLoginBean);
                    }
                }));
    }
}
