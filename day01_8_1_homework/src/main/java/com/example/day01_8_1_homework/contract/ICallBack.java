package com.example.day01_8_1_homework.contract;

public interface ICallBack<T> {
    void onSuccess(T t);
    void onFailed(String error);
}
