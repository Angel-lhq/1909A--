package com.example.day01_8_1_1.home.contract;

import com.example.day01_8_1_1.base.BaseView;
import com.example.day01_8_1_1.home.bean.GirlBean;

public interface Contract {

    interface IView extends BaseView {
        void setData(GirlBean girlBean);
    }
    interface IPresenter {
    }
    interface IModel {
    }
}
