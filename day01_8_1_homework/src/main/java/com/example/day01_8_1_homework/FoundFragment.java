package com.example.day01_8_1_homework;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.day01_8_1_homework.adapter.InfpRclAdapter;
import com.example.day01_8_1_homework.bean.Bean;
import com.example.day01_8_1_homework.presenter.IPresenter;
import com.example.day01_8_1_homework.presenter.Presenter;
import com.example.day01_8_1_homework.view.IView;
import com.google.gson.Gson;

public class FoundFragment extends Fragment implements IView {

    private RecyclerView rcl_h;
    private View tab;
    private ViewPager vp;
    private IPresenter presenter;
    private InfpRclAdapter infpRclAdapter;

    public FoundFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_found, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        presenter = new Presenter(this);
        initView(getView());
        initData();
    }

    private void initData() {
        presenter.getData();
    }

    private void initView(View view) {
        rcl_h = view.findViewById(R.id.rcl_h);
        tab = view.findViewById(R.id.tab);
        vp = view.findViewById(R.id.vp);
        infpRclAdapter = new InfpRclAdapter(getContext());
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(RecyclerView.HORIZONTAL);
        rcl_h.setLayoutManager(manager);
        rcl_h.setAdapter(infpRclAdapter);
    }

    @Override
    public void setData(Object o) {
        String data = (String) o;
        Bean bean = new Gson().fromJson(data, Bean.class);
        infpRclAdapter.setList(bean.getData().getActiondata());
    }
}