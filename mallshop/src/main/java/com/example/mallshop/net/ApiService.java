package com.example.mallshop.net;

import com.example.mallshop.bean.home.ContentBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface ApiService {
    String baseUrl = "http://169.254.96.147:8085/";

    @GET
    Flowable<ContentBean> getContent(@Url String url);
}
