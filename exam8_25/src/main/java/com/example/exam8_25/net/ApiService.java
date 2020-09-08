package com.example.exam8_25.net;

import com.example.exam8_25.bean.HotPostBean;
import com.example.exam8_25.bean.HotTopicBean;
import com.example.exam8_25.bean.HotUserBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface ApiService {

    String baseUrl = "http://cdwan.cn:7000/exam/";

    //获取列表数据
    @GET
    Flowable<HotPostBean> getHotPost(@Url String url);

    //获取热门话题数据
    @GET
    Flowable<HotTopicBean> getHotTopic(@Url String url);

    //获取热门用户数据
    @GET
    Flowable<HotUserBean> getHotUser(@Url String url);

}
