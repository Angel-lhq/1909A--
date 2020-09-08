package com.example.tongpao.net;

import com.example.tongpao.bean.UserLoginBean;
import com.example.tongpao.bean.UserRegisterBean;
import com.example.tongpao.bean.UserUpdateBean;

import java.util.Map;

import io.reactivex.Flowable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface UserApi {
    String baseUrl = "http://cdwan.cn:9001/user/";
    //登录
    @POST("login")
    @FormUrlEncoded
    Flowable<UserLoginBean> login(@FieldMap Map<String,String> map);

    //更新用户信息
    @POST("updateinfo")
    @FormUrlEncoded
    Flowable<UserUpdateBean> updateUserInfo(@FieldMap Map<String,String> map);

    //注册
    @POST("register")
    @FormUrlEncoded
    Flowable<UserRegisterBean> register(@FieldMap Map<String,String> map);


}
