package com.example.tongpao.constract.discover;


import com.example.tongpao.base.IBasePresenter;
import com.example.tongpao.base.IBaseView;
import com.example.tongpao.bean.discover.DiscoverRedianBean;

public interface IRedian{
    interface IRedianiew extends IBaseView {
        //热点数据
        void getIredianReturn(DiscoverRedianBean discoverRedianBean);
    }
    interface IRedianPresenter extends IBasePresenter<IRedianiew> {
        void getIRedian();
    }
}
