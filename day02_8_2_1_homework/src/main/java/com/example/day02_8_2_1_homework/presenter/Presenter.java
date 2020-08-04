package com.example.day02_8_2_1_homework.presenter;

import android.util.Log;

import com.example.day02_8_2_1_homework.model.IModel;
import com.example.day02_8_2_1_homework.model.Model;
import com.example.day02_8_2_1_homework.view.ICallBack;
import com.example.day02_8_2_1_homework.view.IView;

public class Presenter<T> implements IPresenter {
    private IView<T> view;
    private IModel model;

    public Presenter(IView<T> view) {
        this.view = view;
        model = new Model();
    }

    private static final String TAG = "Presenter";
    @Override
    public void getHomeData(String url) {
        model.getHomeData(url,new ICallBack<T>() {
            @Override
            public void onSuccess(T t) {
                view.setData(t);
            }

            @Override
            public void onFailed(String error) {
                Log.i(TAG, "onFailed: " + error);
            }
        });
    }

    @Override
    public void getMineData(String url) {
        model.getMineData(url, new ICallBack<T>() {
            @Override
            public void onSuccess(T t) {
                view.setData(t);
            }

            @Override
            public void onFailed(String error) {
                Log.i(TAG, "onFailed: " + error);
            }
        });
    }
}
