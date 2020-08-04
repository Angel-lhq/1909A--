package com.example.day01_8_1_1.utils;

public interface IHttpCallBack<T> {
    void onSuccess(T t);
    void onFailed(String error);
}
