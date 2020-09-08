package com.example.day04_8_4_1.common;

import com.example.day04_8_4_1.app.MyApp;

import java.io.File;

public interface Contant {

    //网络缓存的地址
    public static final String PATH_DATA = MyApp.context.getCacheDir().getAbsolutePath() + File.separator + "data";

    public static final String PATH_CACHE = PATH_DATA + "/client";

}
