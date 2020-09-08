package com.example.tongpao.test;

import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.tongpao.R;
import com.example.tongpao.base.BaseActivity;
import com.example.tongpao.base.IBasePresenter;
import com.example.tongpao.common.CircleTransform;
import com.example.tongpao.util.LogUtil;

import butterknife.BindView;

public class TestActivity extends BaseActivity {
    String name = TestActivity.class.getSimpleName();
    @BindView(R.id.tv_test)
    MyView tvTest;
    @BindView(R.id.image)
    ImageView imageView;
    @Override
    protected IBasePresenter initPresenter() {
        return null;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        Glide.with(this).load("https://tpcdn.whfpsoft.com:443/File/headPhoto/20190410/a1ac13efa881dfb84d83277bb86fd59a.jpg").apply(
                RequestOptions.bitmapTransform(new CircleTransform(this))
        ).into(imageView);
        tvTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_test;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        LogUtil.logi(name+":onTouchEvent-"+event.getAction());
        return super.onTouchEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        LogUtil.logi(name+":dispatchTouchEvent-"+ev.getAction());
        return super.dispatchTouchEvent(ev);
//        return false;
//        return true;
    }
}
