package com.example.day01_8_1_1.utils;

import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

public class RetrofitUtil implements INetWork {

    private static volatile RetrofitUtil retrofitUtil = null;
    private final ApiService apiService;

    private RetrofitUtil(){
        apiService = new Retrofit.Builder()
                .client(new OkHttpClient.Builder().connectTimeout(10, TimeUnit.SECONDS).build())
                .baseUrl(ApiService.baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiService.class);
    }

    public static RetrofitUtil getInstance() {
        if (retrofitUtil == null){
            synchronized (RetrofitUtil.class){
                if (retrofitUtil == null){
                    retrofitUtil = new RetrofitUtil();
                }
            }
        }
        return retrofitUtil;
    }

    @Override
    public <T> void get(String url, IHttpCallBack<T> callBack) {
        apiService.getHttp(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull ResponseBody responseBody) {
                        Type[] types = callBack.getClass().getGenericInterfaces();
                        Type[] arguments = ((ParameterizedType) types[0]).getActualTypeArguments();
                        Type argument = arguments[0];
                        try {
                            T t = new Gson().fromJson(responseBody.string(), argument);
                            callBack.onSuccess(t);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        callBack.onFailed(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public <T> void get(String url, HashMap<String, String> map, IHttpCallBack<T> callBack) {

    }

    @Override
    public <T> void post(String url, IHttpCallBack<T> callBack) {

    }

    @Override
    public <T> void post(String url, HashMap<String, String> map, IHttpCallBack<T> callBack) {

    }
}
