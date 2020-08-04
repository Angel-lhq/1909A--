package com.example.day01_8_1_1.utils;

import java.util.HashMap;

public interface INetWork {
    <T> void get(String url,IHttpCallBack<T> callBack);
    <T> void get(String url, HashMap<String,String> map, IHttpCallBack<T> callBack);
    <T> void post(String url,IHttpCallBack<T> callBack);
    <T> void post(String url,HashMap<String,String> map,IHttpCallBack<T> callBack);
}
