package com.example.day01_8_1_homework.net;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface ApiService {
    String baseUrl = "http://cdwan.cn:7000/";

    @GET
    Observable<ResponseBody> get(@Url String url);
}
