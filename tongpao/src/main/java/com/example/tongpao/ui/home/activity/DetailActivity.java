package com.example.tongpao.ui.home.activity;

import android.content.Intent;
import android.util.Log;

import androidx.recyclerview.widget.RecyclerView;

import com.example.tongpao.R;
import com.example.tongpao.adapter.InfoDetailAdapter;
import com.example.tongpao.adapter.InfoDetailCommentAdapter;
import com.example.tongpao.base.BaseActivity;
import com.example.tongpao.base.IBasePresenter;
import com.example.tongpao.bean.RecommendBean;
import com.example.tongpao.util.MyLayoutManger;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class DetailActivity extends BaseActivity {
    @Override
    protected IBasePresenter initPresenter() {
        return null;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        setTitle("动态详情");
        RecyclerView rclDetailAll = findViewById(R.id.rcl_detail_all);
        RecyclerView rclDetialComment = findViewById(R.id.rcl_detail_comment);

        Intent intent = getIntent();
        String dataStr = intent.getStringExtra("dataStr");

        Log.i("TAG", "initView: " + dataStr);
        RecommendBean.DataBean dataBean = new Gson().fromJson(dataStr, RecommendBean.DataBean.class);
        List<RecommendBean.DataBean> list = new ArrayList<>();
        list.add(dataBean);
        MyLayoutManger detailAllLayoutManger = new MyLayoutManger(this);
        detailAllLayoutManger.setScrollEnabled(false);
        rclDetailAll.setLayoutManager(detailAllLayoutManger);
        InfoDetailAdapter infoDetailAdapter = new InfoDetailAdapter(this);
        infoDetailAdapter.setData(list);
        rclDetailAll.setAdapter(infoDetailAdapter);

        Log.i("TAG", "initView: " + dataBean.getComments().getAllComments().size());
        InfoDetailCommentAdapter infoDetailCommentAdapter = new InfoDetailCommentAdapter(this);
        MyLayoutManger detialCommentLayoutManger = new MyLayoutManger(this);
        detialCommentLayoutManger.setScrollEnabled(false);
        rclDetialComment.setLayoutManager(detialCommentLayoutManger);
        infoDetailCommentAdapter.setData(dataBean.getComments().getAllComments());
        rclDetialComment.setAdapter(infoDetailCommentAdapter);

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_detail;
    }


}
