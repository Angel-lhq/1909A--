package com.example.exam8_25.constract;

import com.example.exam8_25.base.IBasePresenter;
import com.example.exam8_25.base.IBaseView;
import com.example.exam8_25.bean.HotPostBean;
import com.example.exam8_25.bean.HotTopicBean;
import com.example.exam8_25.bean.HotUserBean;

public interface IHome {
    interface IHomeView extends IBaseView {
        void setHotTopic(HotTopicBean hotTopicBean);
        void setHotPost(HotPostBean hotPostBean);
        void setHotUser(HotUserBean hotUserBean);
    }
    interface IHomePresenter extends IBasePresenter<IHomeView> {
        void getHotTopic(String url);
        void getHotPost(String url);
        void getHotUser(String url);
    }
}
