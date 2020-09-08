package com.example.tongpao.ui.myOwn.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tongpao.R;
import com.example.tongpao.base.BaseActivity;
import com.example.tongpao.base.IBasePresenter;

import butterknife.BindView;

public class SettingActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.tv_log_out)
    TextView tvLogOut;
    @BindView(R.id.img_back)
    ImageView imgBack;
    @Override
    protected IBasePresenter initPresenter() {
        return null;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        tvLogOut.setOnClickListener(this);
        imgBack.setOnClickListener(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_setting;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_log_out:
                SharedPreferences login = getSharedPreferences("login", 0);
                login.edit().clear().commit();
                startActivity(new Intent(this,LoginPrepareActivity.class));
                finish();
                break;
            case R.id.img_back:
                finish();
                break;
        }
    }
}
