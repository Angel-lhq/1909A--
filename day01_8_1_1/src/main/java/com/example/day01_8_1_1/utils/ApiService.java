package com.example.day01_8_1_1.utils;

import java.util.HashMap;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface ApiService {
    String baseUrl = "https://gank.io/";
    @GET
    Observable<ResponseBody> getHttp(@Url String url);

    @POST
    @FormUrlEncoded
    Observable<ResponseBody> postHttp(@Url String url);

    @POST
    @FormUrlEncoded
    Observable<ResponseBody> postHttp(@Url String url, @FieldMap HashMap<String,String> map);
}
