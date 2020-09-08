package com.example.day04_8_4_1.net;

import com.example.day04_8_4_1.bean.GirlBean;
import com.example.day04_8_4_1.bean.TongPaoBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface ApiService {

    @GET
    Flowable<GirlBean> getData1(@Url String url);
    @GET
    Flowable<TongPaoBean> getData(@Url String url);
}
