package com.example.day29_6_29_2;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;

public interface ApiService {
    String url = "https://www.wanandroid.com/";

    @GET("project/tree/json")
    Observable<ResponseBody> getData();
}
