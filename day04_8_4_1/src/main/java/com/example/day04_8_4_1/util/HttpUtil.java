package com.example.day04_8_4_1.util;

import com.example.day04_8_4_1.common.Contant;
import com.example.day04_8_4_1.net.ApiService;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpUtil {
    private static volatile HttpUtil httpUtil = null;
    private static Retrofit retrofit;
    private static volatile ApiService apiService;

    private HttpUtil() {
        OkHttpClient okHttpClient = getOkHttpClient();
        retrofit = getRetrofit(okHttpClient);
    }

    private Retrofit getRetrofit(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("https://gank.io/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private OkHttpClient getOkHttpClient() {
        return new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .addInterceptor(new LogInterceptor())
                .addNetworkInterceptor(new NetInterceptor())
                .readTimeout(10, TimeUnit.SECONDS)
                .cache(new Cache(new File(Contant.PATH_CACHE),1024*1024*4))
                .retryOnConnectionFailure(true)
                .build();
    }

    public ApiService getApiService() {
        if (apiService == null){
            synchronized (HttpUtil.class){
                if (apiService == null){
                    apiService = retrofit.create(ApiService.class);
                }
            }
        }
        return apiService;
    }

    public static HttpUtil getInstance() {
        if (httpUtil == null){
            synchronized (HttpUtil.class){
                if (httpUtil == null){
                    httpUtil = new HttpUtil();
                }
            }
        }
        return httpUtil;
    }

    /**
     * 日志拦截器
     */
    static class LogInterceptor implements Interceptor {

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            long t1 = System.nanoTime();
            LogUtil.logi(String.format("Sending request %s on %s%n%s",request.url(),chain.connection(),request.headers()));
            Response response = chain.proceed(request);
            long t2 = System.nanoTime();
            LogUtil.logi(String.format("Received response for %s in %.1fms%n%s",response.request().url(),(t2-t1)/1e6d,response.headers()));
            LogUtil.logi(response.peekBody(1024*1024*4).string());
            return response;
        }
    }

    /**
     * 网络拦截器
     */
    static class NetInterceptor implements Interceptor{

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            if(!SystemUtils.checkNetWork()){
                request = request.newBuilder()
                        .cacheControl(CacheControl.FORCE_CACHE)
                        .build();
            }
            Response response = chain.proceed(request);
            //通过判断网络连接是否存在获取本地或者服务器的数据
            if(!SystemUtils.checkNetWork()){
                int maxAge = 0;
                return response.newBuilder()
                        .removeHeader("Pragma")
                        .header("Cache-Control","public ,max-age="+maxAge).build();
            }else{
                int maxStale = 60*60*24*28; //设置缓存数据的保存时间
                return response.newBuilder()
                        .removeHeader("Pragma")
                        .header("Cache-Control","public, onlyif-cached, max-stale="+maxStale).build();
            }
        }
    }
}
