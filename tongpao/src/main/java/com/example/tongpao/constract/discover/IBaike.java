package com.example.tongpao.constract.discover;


import com.example.tongpao.base.IBasePresenter;
import com.example.tongpao.base.IBaseView;
import com.example.tongpao.bean.discover.DiscoverBaikeBean;

public interface IBaike {
    interface IBaikeView extends IBaseView {
        void getIBaikeReturn(DiscoverBaikeBean discoverBaikeBean);
    }
    interface IBaikePresenter extends IBasePresenter<IBaikeView> {
        void getIbaike();
    }
}
