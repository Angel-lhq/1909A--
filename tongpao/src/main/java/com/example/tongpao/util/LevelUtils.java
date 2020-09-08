package com.example.tongpao.util;

import android.widget.ImageView;

import com.example.tongpao.R;


public class LevelUtils {
    public static void setLevelImage(int level, ImageView img_level) {
        switch (level) {
            case 1:
                img_level.setBackgroundResource(R.mipmap.lv1);
                break;
            case 2:
                img_level.setBackgroundResource(R.mipmap.lv2);
                break;
            case 3:
                img_level.setBackgroundResource(R.mipmap.lv3);
                break;
            case 4:
                img_level.setBackgroundResource(R.mipmap.lv4);
                break;
            case 5:
                img_level.setBackgroundResource(R.mipmap.lv5);
                break;
            case 6  :
                img_level.setBackgroundResource(R.mipmap.lv6);
                break;
            case 7:
                img_level.setBackgroundResource(R.mipmap.lv7);
                break;
            case 8:
                img_level.setBackgroundResource(R.mipmap.lv8);
                break;
            case 9:
                img_level.setBackgroundResource(R.mipmap.lv9);
                break;
            case 10:
                img_level.setBackgroundResource(R.mipmap.lv10);
                break;
        }
    }
}
