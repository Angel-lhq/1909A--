package com.example.exam8_25.fragment;

import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.exam8_25.R;
import com.example.exam8_25.adapter.InfoHotPostAdapter;
import com.example.exam8_25.adapter.InfoHotTopicAdapter;
import com.example.exam8_25.adapter.InfoHotUserAdapter;
import com.example.exam8_25.base.BaseFragment;
import com.example.exam8_25.bean.HotPostBean;
import com.example.exam8_25.bean.HotTopicBean;
import com.example.exam8_25.bean.HotUserBean;
import com.example.exam8_25.constract.IHome;
import com.example.exam8_25.presenter.HomePresenter;
import com.example.exam8_25.util.MyLayoutManger;

import java.util.ArrayList;
import java.util.List;

import cn.jzvd.JzvdStd;

public class HomeFragment extends BaseFragment<IHome.IHomePresenter> implements IHome.IHomeView {

    private RecyclerView rclHotTopic;
    private RecyclerView rclHotPost;
    private RecyclerView rclHotPost2;
    private InfoHotTopicAdapter infoHotTopicAdapter;
    private InfoHotPostAdapter infoHotPostAdapter;
    private InfoHotPostAdapter infoHotPostAdapter2;
    private RecyclerView rclHotUser;
    private InfoHotUserAdapter infoHotUserAdapter;

    @Override
    protected IHome.IHomePresenter initPresenter() {
        return new HomePresenter();
    }

    @Override
    protected void initData() {
        presenter.getHotTopic("hottopic.json");
        presenter.getHotPost("hotpost.json");
        presenter.getHotUser("hotuser.json");
    }

    @Override
    protected void initView(View view) {
        rclHotTopic = view.findViewById(R.id.rcl_hot_topic);
        rclHotPost = view.findViewById(R.id.rcl_hot_post);
        rclHotUser = view.findViewById(R.id.rcl_hot_user);
        rclHotPost2 = view.findViewById(R.id.rcl_hot_post2);

        LinearLayoutManager hotTopicManager = new LinearLayoutManager(context);
        hotTopicManager.setOrientation(RecyclerView.HORIZONTAL);
        rclHotTopic.setLayoutManager(hotTopicManager);
        infoHotTopicAdapter = new InfoHotTopicAdapter(context);
        rclHotTopic.setAdapter(infoHotTopicAdapter);

        MyLayoutManger RecommendManager = new MyLayoutManger(context);
        RecommendManager.setScrollEnabled(false);
        rclHotPost.setLayoutManager(RecommendManager);
        infoHotPostAdapter = new InfoHotPostAdapter(context);
        rclHotPost.setAdapter(infoHotPostAdapter);

        MyLayoutManger RecommendManager2 = new MyLayoutManger(context);
        RecommendManager2.setScrollEnabled(false);
        rclHotPost2.setLayoutManager(RecommendManager2);
        infoHotPostAdapter2 = new InfoHotPostAdapter(context);
        rclHotPost2.setAdapter(infoHotPostAdapter2);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        rclHotUser.setLayoutManager(linearLayoutManager);
        infoHotUserAdapter = new InfoHotUserAdapter(context);
        rclHotUser.setAdapter(infoHotUserAdapter);
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_home;
    }

    @Override
    public void setHotTopic(HotTopicBean hotTopicBean) {
        infoHotTopicAdapter.setData(hotTopicBean.getData());
    }

    @Override
    public void setHotPost(HotPostBean hotPostBean) {
        List<HotPostBean.DataBean.DynamicsBean> dynamics = hotPostBean.getData().getDynamics();

        List<HotPostBean.DataBean.DynamicsBean> list = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            list.add(dynamics.get(i));
        }
        infoHotPostAdapter.setData(list);

        List<HotPostBean.DataBean.DynamicsBean> list2 = new ArrayList<>();
        for (int i = 0; i < dynamics.size(); i++) {
            if (i>1){
                list2.add(dynamics.get(i));
            }
        }
        infoHotPostAdapter2.setData(list2);
    }

    @Override
    public void setHotUser(HotUserBean hotUserBean) {
        infoHotUserAdapter.setData(hotUserBean.getData());
    }

    @Override
    public void onPause() {
        super.onPause();
        JzvdStd.releaseAllVideos();
    }
}
