package com.example.day04_8_4_1.presenter;

import com.example.day04_8_4_1.base.BasePresenter;
import com.example.day04_8_4_1.bean.TongPaoBean;
import com.example.day04_8_4_1.common.CommonSubscriber;
import com.example.day04_8_4_1.util.HttpUtil;
import com.example.day04_8_4_1.util.RxUtils;
import com.example.day04_8_4_1.view.IMain;

public class PresenterMain extends BasePresenter<IMain.IView> implements IMain.IPresenter {

    @Override
    public void getData(String url) {
        addSubscribe(HttpUtil.getInstance()
                .getApiService()
                .getData(url)
                .compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<TongPaoBean>(view) {
            @Override
            public void onNext(TongPaoBean tongPaoBean) {
                view.setData(tongPaoBean);
            }
        }));
    }
}
