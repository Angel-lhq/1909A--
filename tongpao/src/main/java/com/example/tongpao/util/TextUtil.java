package com.example.tongpao.util;

import android.text.TextUtils;
import android.widget.TextView;

public class TextUtil {
    public static void setText(TextView text,String str){
        if (!TextUtils.isEmpty(str)){
            text.setText(str);
        }
    }
}
