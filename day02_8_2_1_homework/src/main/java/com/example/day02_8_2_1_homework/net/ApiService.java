package com.example.day02_8_2_1_homework.net;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface ApiService {

    String baseUrl = "https://wanandroid.com/";

    @GET
    Observable<ResponseBody> getData(@Url String url);

}
