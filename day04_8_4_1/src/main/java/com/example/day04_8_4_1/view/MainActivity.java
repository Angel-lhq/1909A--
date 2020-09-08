package com.example.day04_8_4_1.view;

import android.widget.TextView;

import com.example.day04_8_4_1.R;
import com.example.day04_8_4_1.base.BaseActivity;
import com.example.day04_8_4_1.bean.TongPaoBean;
import com.example.day04_8_4_1.presenter.PresenterMain;

public class MainActivity extends BaseActivity<IMain.IPresenter> implements IMain.IView<TongPaoBean> {

    private TextView tv_main;

    @Override
    protected IMain.IPresenter initPresenter() {
        return new PresenterMain();
    }

    @Override
    protected void initData() {
        presenter.getData("http://cdwan.cn:7000/exam/data.json");
    }

    @Override
    protected void initView() {
        tv_main = findViewById(R.id.tv_main);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void setData(TongPaoBean tongPaoBean) {
        tv_main.setText(tongPaoBean.toString());
    }

}