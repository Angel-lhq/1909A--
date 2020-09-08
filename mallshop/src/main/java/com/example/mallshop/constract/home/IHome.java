package com.example.mallshop.constract.home;

import com.example.mallshop.base.IBasePresenter;
import com.example.mallshop.base.IBaseView;
import com.example.mallshop.bean.home.ContentBean;

public interface IHome {
    interface IHomeContentView extends IBaseView{
        void setContent(ContentBean contentBean);
    }
    interface IHomeContentPresenter extends IBasePresenter<IHomeContentView>{
        void getContent(String url);
    }
}
