package com.example.day02_8_2_1_homework.model;

import com.example.day02_8_2_1_homework.view.ICallBack;

public interface IModel{
    void getHomeData(String url,ICallBack callBack);
    void getMineData(String url,ICallBack callBack);
}
