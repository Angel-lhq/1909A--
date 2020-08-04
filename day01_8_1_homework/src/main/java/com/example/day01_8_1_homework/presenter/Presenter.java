package com.example.day01_8_1_homework.presenter;

import android.util.Log;

import com.example.day01_8_1_homework.contract.ICallBack;
import com.example.day01_8_1_homework.model.IModel;
import com.example.day01_8_1_homework.model.Model;
import com.example.day01_8_1_homework.view.IView;

public class Presenter implements IPresenter{
    private IView view;
    private IModel model;

    public Presenter(IView view) {
        this.view = view;
        model = new Model();
    }

    private static final String TAG = "Presenter";
    @Override
    public void getData() {
        model.getData(new ICallBack() {
            @Override
            public void onSuccess(Object o) {
                view.setData(o);
            }

            @Override
            public void onFailed(String error) {
                Log.i(TAG, "onFailed: " + error);
            }
        });
    }
}
