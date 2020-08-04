package com.example.day01_8_1_1.base;

import com.example.day01_8_1_1.home.model.Model;

public abstract class BasePresenter<T extends BaseView> {
    public T iView;
    public Model model;

    public BasePresenter() {
        model = iniModel();
    }

    public void bindView(T view) {
        iView = view;
    }

    protected abstract Model iniModel();
    protected abstract void getData(String url);

}
