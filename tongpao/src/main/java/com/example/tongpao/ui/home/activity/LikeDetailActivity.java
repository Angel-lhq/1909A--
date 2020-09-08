package com.example.tongpao.ui.home.activity;

import android.content.Intent;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tongpao.R;
import com.example.tongpao.adapter.InfoLikeDetailAdapter;
import com.example.tongpao.base.BaseActivity;
import com.example.tongpao.base.IBasePresenter;
import com.example.tongpao.bean.RecommendBean;
import com.google.gson.Gson;

import java.util.List;

import butterknife.BindView;

public class LikeDetailActivity extends BaseActivity {
    @BindView(R.id.rcl_like_detail)
    RecyclerView rclLikeDetail;
    @Override
    protected IBasePresenter initPresenter() {
        return null;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        setTitle("所有点赞");
        Intent intent = getIntent();
        String postStr = intent.getStringExtra("postStr");
        RecommendBean.DataBean.PostDetailBean postDetailBean = new Gson().fromJson(postStr, RecommendBean.DataBean.PostDetailBean.class);
        List<RecommendBean.DataBean.PostDetailBean.LikeDetailsBean> likeDetails = postDetailBean.getLikeDetails();
        rclLikeDetail.setLayoutManager(new LinearLayoutManager(this));
        InfoLikeDetailAdapter infoLikeDetailAdapter = new InfoLikeDetailAdapter(this);
        infoLikeDetailAdapter.setData(likeDetails);
        rclLikeDetail.setAdapter(infoLikeDetailAdapter);

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_like_detail;
    }
}
