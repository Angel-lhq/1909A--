package com.example.day02_8_2_1_homework.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.day02_8_2_1_homework.R;
import com.example.day02_8_2_1_homework.bean.MineBean;
import com.example.day02_8_2_1_homework.presenter.IPresenter;
import com.example.day02_8_2_1_homework.presenter.Presenter;
import com.example.day02_8_2_1_homework.view.IView;

public class MineFragment extends Fragment implements IView<MineBean> {

    private TextView tv_mine;
    private IPresenter presenter;

    public MineFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mine, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        presenter = new Presenter<MineBean>(this);
        initView(getView());
        initData();
    }

    private void initData() {
        presenter.getMineData("https://wanandroid.com/wxarticle/list/408/1/json");
    }

    private void initView(View view) {
        tv_mine = view.findViewById(R.id.tv_mine);
    }

    @Override
    public void setData(MineBean mineBean) {
        tv_mine.setText(mineBean.toString());
    }
}