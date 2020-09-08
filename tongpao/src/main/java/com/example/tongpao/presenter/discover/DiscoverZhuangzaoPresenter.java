package com.example.tongpao.presenter.discover;


import com.example.tongpao.base.BasePresenter;
import com.example.tongpao.bean.discover.DiscoverZhuangzaoBean;
import com.example.tongpao.common.CommonSubscriber;
import com.example.tongpao.constract.discover.IZhuangzao;
import com.example.tongpao.util.HttpUtil;
import com.example.tongpao.util.RxUtils;

public class DiscoverZhuangzaoPresenter extends BasePresenter<IZhuangzao.IZhuangzaoView> implements IZhuangzao.IZhuangzaoPresenter {
    @Override
    public void getIZhuangzao() {
        addSubscribe(HttpUtil.getInstance().getApiService().getZhuangzao()
        .compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<DiscoverZhuangzaoBean>(view) {
                    @Override
                    public void onNext(DiscoverZhuangzaoBean discoverZhuangzaoBean) {
                        view.getIZhuangzaoReturn(discoverZhuangzaoBean);
                    }
                })
        );
    }
}
