package com.example.day02_8_2_1_homework.view;

public interface ICallBack<T> {
    void onSuccess(T t);
    void onFailed(String error);
}
