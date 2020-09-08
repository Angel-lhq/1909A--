package com.example.tongpao.ui.myOwn.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tongpao.R;
import com.example.tongpao.base.BaseActivity;
import com.example.tongpao.bean.UserRegisterBean;
import com.example.tongpao.constract.myOwn.IMyOwn;
import com.example.tongpao.presenter.myOwn.RegisterPresenter;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;

public class RegisterActivity extends BaseActivity<IMyOwn.IRegisterPresenter> implements IMyOwn.IRegisterView,View.OnClickListener {

    @BindView(R.id.img_back)
    ImageView imgBack;
    @BindView(R.id.et_username)
    EditText etUserName;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.et_pwd)
    EditText etPwd;
    @BindView(R.id.tv_register)
    TextView tvRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    @Override
    protected IMyOwn.IRegisterPresenter initPresenter() {
        return new RegisterPresenter();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        imgBack.setOnClickListener(this);
        tvRegister.setOnClickListener(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_register;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.img_back:
                finish();
                break;
            case R.id.tv_register:
                String userName = etUserName.getText().toString();
                String password = etPassword.getText().toString();
                String pwd = etPwd.getText().toString();
                if (!TextUtils.isEmpty(userName) && !TextUtils.isEmpty(password) && !TextUtils.isEmpty(pwd)){
                    if (password.equals(pwd)){
                        Map<String,String> map = new HashMap<>();
                        map.put("username",userName);
                        map.put("password",password);
                        presenter.register(map);
                    }else {
                        Toast.makeText(this, "两次密码输入不相同", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(this, "用户名或密码不能为空", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    @Override
    public void registerReturn(UserRegisterBean userRegisterBean) {
        if (userRegisterBean != null){
            if (userRegisterBean.getCode() == 10000){
                Toast.makeText(this, "注册成功请登录", Toast.LENGTH_SHORT).show();
                finish();
            }else {
                Toast.makeText(this, userRegisterBean.getData(), Toast.LENGTH_SHORT).show();
            }
        }
    }
}