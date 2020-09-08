package com.example.tongpao.common;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

public class TitleBehavior extends CoordinatorLayout.Behavior<View> {

    private float titleY; //列表顶部和title底部重合时，列表的滑动距离

    public TitleBehavior(){}

    public TitleBehavior(Context context, AttributeSet attrs){
        super(context,attrs);
    }

    /**
     * 使用behavior的view要监听哪个类型的view状态变化
     * @param parent CoordinatorLayout
     * @param child 使用behavior的view
     * @param dependency 代表要监听的view
     * @return
     */
    @Override
    public boolean layoutDependsOn(@NonNull CoordinatorLayout parent, @NonNull View child, @NonNull View dependency) {

        return child instanceof AppCompatTextView;
    }

    /**
     * 当View状态变化时会调用该方法，
     * @param parent
     * @param child
     * @param dependency
     * @return
     */
    @Override
    public boolean onDependentViewChanged(@NonNull CoordinatorLayout parent, @NonNull View child, @NonNull View dependency) {
        if(titleY == 0){
            titleY = dependency.getY()-child.getHeight(); 
        }
        float dy = dependency.getY()-child.getHeight();
        dy = dy < 0 ? 0 :dy;
        float alpha = 1 - (dy/titleY);
        child.setAlpha(alpha);
        return true;
    }
}
