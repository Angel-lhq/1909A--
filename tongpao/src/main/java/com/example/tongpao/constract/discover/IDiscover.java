package com.example.tongpao.constract.discover;


import com.example.tongpao.base.IBasePresenter;
import com.example.tongpao.base.IBaseView;
import com.example.tongpao.bean.discover.DisCoverTopicBean;

public interface IDiscover {
    interface DiscoverView extends IBaseView {
        //热门数据
        void getTopicReturn(DisCoverTopicBean disCoverTopicBean);


    }
    interface DiscoerPresenter extends IBasePresenter<DiscoverView> {
        //热门数据
        void getTopic();

    }
}
