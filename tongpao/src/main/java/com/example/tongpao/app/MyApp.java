package com.example.tongpao.app;

import android.app.Application;
import android.content.Context;

import androidx.multidex.MultiDex;

import com.danikula.videocache.HttpProxyCacheServer;
import com.example.tongpao.common.MyFileNameGenerator;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.socialize.PlatformConfig;

public class MyApp extends Application {

    public static Context context;
    private HttpProxyCacheServer proxy;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        MultiDex.install(this);
        UMConfigure.init(this,"5f3cd544d3093221547adbc1"
                ,"umeng",UMConfigure.DEVICE_TYPE_PHONE,"");//58edcfeb310c93091c000be2 5965ee00734be40b580001a0
        PlatformConfig.setWeixin("wxdc1e388c3822c80b", "3baf1193c85774b3fd9d18447d76cab0");
        //豆瓣RENREN平台目前只能在服务器端配置
        PlatformConfig.setSinaWeibo("3921700954", "04b48b094faeb16683c32669824ebdad","http://sns.whalecloud.com");
        PlatformConfig.setQQZone("101888769", "95efd7144cb1514dc3d6f1ae3d6d9b2b");

    }

    public static HttpProxyCacheServer getProxy(Context context){
        MyApp myApp = (MyApp) context.getApplicationContext();
        return myApp.proxy == null ? (myApp.proxy = myApp.newProxy()) : myApp.proxy;
    }

    private HttpProxyCacheServer newProxy(){
        return new HttpProxyCacheServer.Builder(this)
                .maxCacheSize(1024*1024*1024)
                .maxCacheFilesCount(30)
                .fileNameGenerator(new MyFileNameGenerator())
                .build();
    }
}
