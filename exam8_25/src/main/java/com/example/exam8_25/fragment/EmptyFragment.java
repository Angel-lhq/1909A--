package com.example.exam8_25.fragment;

import android.view.View;

import com.example.exam8_25.R;
import com.example.exam8_25.base.BaseFragment;
import com.example.exam8_25.base.IBasePresenter;

public class EmptyFragment extends BaseFragment {
    @Override
    protected IBasePresenter initPresenter() {
        return null;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_empty;
    }
}
