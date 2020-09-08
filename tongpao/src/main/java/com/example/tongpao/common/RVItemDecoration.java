package com.example.tongpao.common;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.example.tongpao.app.MyApp;
import com.example.tongpao.util.SystemUtils;

public class RVItemDecoration extends RecyclerView.ItemDecoration {

    private Paint mPaint;

    public RVItemDecoration(Context context) {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(2); //时间轴线的宽度。
        mPaint.setColor(Color.GRAY); //时间轴线的颜色。
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);

        int childCount = parent.getChildCount();

        for (int i = 0; i < childCount; i++) {
            View view = parent.getChildAt(i);

            //int index = parent.getChildAdapterPosition(view);

            float left = SystemUtils.dip2px(MyApp.context, 10);
            float bottom = view.getBottom();

            c.drawLine(left, SystemUtils.dip2px(MyApp.context, (50 - 20) / 2), left, bottom, mPaint);
        }
    }
}

