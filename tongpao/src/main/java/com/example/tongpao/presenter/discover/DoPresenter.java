package com.example.tongpao.presenter.discover;

import com.example.tongpao.base.BasePresenter;
import com.example.tongpao.bean.discover.AssociationBean;
import com.example.tongpao.common.CommonSubscriber;
import com.example.tongpao.constract.discover.IFind;
import com.example.tongpao.util.HttpUtil;
import com.example.tongpao.util.RxUtils;

public class DoPresenter extends BasePresenter<IFind.DoView> implements IFind.DoPresenter {
    @Override
    public void getAssociation() {
        addSubscribe(
                HttpUtil.getInstance().getApiService().getAssociationData()
                        .compose(RxUtils.rxScheduler())
                        .subscribeWith(new CommonSubscriber<AssociationBean>(view) {
                            @Override
                            public void onNext(AssociationBean associationBean) {
                                view.getAssociationReturn(associationBean);
                            }
                        })
        );
    }
}
