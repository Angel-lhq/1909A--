package com.example.tongpao.ui.home.perinfofragments;

import android.content.Intent;
import android.os.Build;
import android.view.View;

import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tongpao.R;
import com.example.tongpao.adapter.InfoPerActivitiesAdapter;
import com.example.tongpao.base.BaseAdapter;
import com.example.tongpao.base.BaseFragment;
import com.example.tongpao.bean.PerActiviesBean;
import com.example.tongpao.constract.home.IHome;
import com.example.tongpao.presenter.home.PerActivitiesPresenter;
import com.example.tongpao.ui.home.activity.ActivitiesDetailActivity;

import butterknife.BindView;

public class ActivitiesFragment extends BaseFragment<IHome.IPerActivitiesPresenter> implements IHome.IPerActivitiesView {

    @BindView(R.id.rcl_activities)
    RecyclerView rclActicities;
    private InfoPerActivitiesAdapter infoPerActivitiesAdapter;
    @Override
    protected IHome.IPerActivitiesPresenter initPresenter() {
        return new PerActivitiesPresenter();
    }

    @Override
    protected void initData() {
        presneter.getActivities("home/personal_post.json");
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void initView(View view) {
        rclActicities.setLayoutManager(new LinearLayoutManager(context));
        infoPerActivitiesAdapter = new InfoPerActivitiesAdapter(context);
        rclActicities.addItemDecoration(new DividerItemDecoration(context,DividerItemDecoration.VERTICAL));
        rclActicities.setAdapter(infoPerActivitiesAdapter);
        infoPerActivitiesAdapter.setiOnClick(new BaseAdapter.IOnClick() {
            @Override
            public void onClick(int position, Object o, View view) {
                Intent intent = new Intent(context, ActivitiesDetailActivity.class);
                intent.putExtra("data",(PerActiviesBean.DataBean.ActivitysBean)o);
                startActivity(intent);
            }
        });
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_activities;
    }


    @Override
    public void setActivities(PerActiviesBean activiesBean) {
        infoPerActivitiesAdapter.setData(activiesBean.getData().getActivitys());
    }
}
