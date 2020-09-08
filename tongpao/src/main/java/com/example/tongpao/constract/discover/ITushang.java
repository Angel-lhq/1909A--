package com.example.tongpao.constract.discover;


import com.example.tongpao.base.IBasePresenter;
import com.example.tongpao.base.IBaseView;
import com.example.tongpao.bean.discover.DiscoverTushangBean;

public interface ITushang {
    interface getITushangView extends IBaseView {
        void getITushangReturn(DiscoverTushangBean discoverTushangBean);
    }
    interface getITushangPresenter extends IBasePresenter<getITushangView> {
        void getITushang();
    }
}
