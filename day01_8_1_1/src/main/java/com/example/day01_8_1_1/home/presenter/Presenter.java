package com.example.day01_8_1_1.home.presenter;

import android.util.Log;

import com.example.day01_8_1_1.base.BasePresenter;
import com.example.day01_8_1_1.home.bean.GirlBean;
import com.example.day01_8_1_1.home.contract.Contract;
import com.example.day01_8_1_1.home.model.Model;
import com.example.day01_8_1_1.utils.IHttpCallBack;

public class Presenter extends BasePresenter<Contract.IView> implements Contract.IPresenter {

    @Override
    protected Model iniModel() {
        return new Model();
    }

    private static final String TAG = "llhhqq";

    @Override
    public void getData(String url){
        model.getData(url, new IHttpCallBack<GirlBean>() {
            @Override
            public void onSuccess(GirlBean girlBean) {

                iView.setData(girlBean);
            }

            @Override
            public void onFailed(String error) {
                Log.i(TAG, "onFailed: " + error);
            }
        });
    }
}
