package com.example.day01_8_1_1.home.model;

import com.example.day01_8_1_1.home.contract.Contract;
import com.example.day01_8_1_1.utils.IHttpCallBack;
import com.example.day01_8_1_1.utils.RetrofitUtil;

public class Model implements Contract.IModel {

    public <T> void getData(String url, IHttpCallBack<T> callBack){
        RetrofitUtil.getInstance().get(url,callBack);
    }
}
