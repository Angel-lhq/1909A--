package com.example.day02_8_2_1_homework.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.day02_8_2_1_homework.R;
import com.example.day02_8_2_1_homework.bean.HomeBean;
import com.example.day02_8_2_1_homework.presenter.IPresenter;
import com.example.day02_8_2_1_homework.presenter.Presenter;
import com.example.day02_8_2_1_homework.view.IView;

public class HomeFragment extends Fragment implements IView<HomeBean> {

    private IPresenter presenter;
    private TextView tv_home;

    public HomeFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        presenter = new Presenter<HomeBean>(this);
        initView(getView());
        initData();
    }

    private void initData() {
        presenter.getHomeData("https://wanandroid.com/wxarticle/chapters/json");
    }

    private void initView(View view) {
        tv_home = view.findViewById(R.id.tv_home);

    }

    @Override
    public void setData(HomeBean homeBean) {
        tv_home.setText(homeBean.toString());
    }
}