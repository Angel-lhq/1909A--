package com.example.tongpao.myview;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class VedioItemDecoration extends RecyclerView.ItemDecoration {
    private int space;//条目之间的间距
    public void setSapce(int value){
        space = value;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        if (parent.getChildLayoutPosition(view)%2==0){
            outRect.left = space;
            outRect.right=0;
        }else {
            outRect.left = space;
            outRect.right = space;
        }
        outRect.top = space;
    }
}
