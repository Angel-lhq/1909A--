package com.example.day02_8_2_1_homework.model;

import com.example.day02_8_2_1_homework.bean.HomeBean;
import com.example.day02_8_2_1_homework.bean.MineBean;
import com.example.day02_8_2_1_homework.net.ApiService;
import com.example.day02_8_2_1_homework.view.ICallBack;
import com.google.gson.Gson;

import java.io.IOException;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Model implements IModel  {
    @Override
    public void getHomeData(String url,ICallBack callBack) {
        loadData(url).subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull ResponseBody responseBody) {
                        try {
                            HomeBean homeBean = new Gson().fromJson(responseBody.string(), HomeBean.class);
                            callBack.onSuccess(homeBean);
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
    public void getMineData(String url, ICallBack callBack) {
        loadData(url).subscribe(new Observer<ResponseBody>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull ResponseBody responseBody) {
                try {
                    MineBean mineBean = new Gson().fromJson(responseBody.string(), MineBean.class);
                    callBack.onSuccess(mineBean);
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

    private Observable<ResponseBody> loadData(String url) {
        return new Retrofit.Builder()
                .baseUrl(ApiService.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiService.class)
                .getData(url)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }
}
