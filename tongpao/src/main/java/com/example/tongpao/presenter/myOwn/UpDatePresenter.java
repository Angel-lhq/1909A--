package com.example.tongpao.presenter.myOwn;

import com.example.tongpao.base.BasePresenter;
import com.example.tongpao.bean.UserUpdateBean;
import com.example.tongpao.common.CommonSubscriber;
import com.example.tongpao.constract.myOwn.IMyOwn;
import com.example.tongpao.util.HttpUtil;
import com.example.tongpao.util.RxUtils;

import java.util.Map;

public class UpDatePresenter extends BasePresenter<IMyOwn.IUpDateView> implements IMyOwn.IUpDatePresenter {
    @Override
    public void upDate(Map<String,String> map) {
        addSubscribe(HttpUtil.getInstance()
                .getUserApi()
                .updateUserInfo(map)
                .compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<UserUpdateBean>(view) {
                    @Override
                    public void onNext(UserUpdateBean userUpdateBean) {
                        view.upDateReturn(userUpdateBean);
                    }
                }));
    }
}
