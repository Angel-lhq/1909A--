package com.example.day04_8_4_1.view;

import com.example.day04_8_4_1.base.IBasePresenter;
import com.example.day04_8_4_1.base.IBaseView;

public interface IMain {
    public interface IView<T> extends IBaseView{
        void setData(T t);
    }
    public interface IPresenter extends IBasePresenter<IView> {
        void getData(String url);
    }
}
