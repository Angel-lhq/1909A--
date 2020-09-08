package com.example.tongpao.ui.myOwn.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tongpao.MainActivity;
import com.example.tongpao.R;
import com.example.tongpao.base.BaseActivity;
import com.example.tongpao.bean.UserLoginBean;
import com.example.tongpao.constract.myOwn.IMyOwn;
import com.example.tongpao.presenter.myOwn.LoginPresenter;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;

public class LoginActivity extends BaseActivity<IMyOwn.ILoginPresenter> implements IMyOwn.ILoginView, View.OnClickListener {
    @BindView(R.id.img_back)
    ImageView imgBack;
    @BindView(R.id.tv_register)
    TextView tvRegister;
    @BindView(R.id.et_username)
    EditText etUserName;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.img_reset)
    ImageView imgReset;
    @BindView(R.id.tv_verification_code)
    TextView tvCode;
    @BindView(R.id.tv_login)
    TextView tvLogin;
    private SharedPreferences login;

    @Override
    protected IMyOwn.ILoginPresenter initPresenter() {
        return new LoginPresenter();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        imgBack.setOnClickListener(this);
        tvRegister.setOnClickListener(this);
        tvLogin.setOnClickListener(this);
        imgReset.setOnClickListener(this);
        login = getSharedPreferences("login", 0);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void loginReturn(UserLoginBean userLoginBean) {
        if (userLoginBean != null){
            if (userLoginBean.getErr() == 200){
                SharedPreferences.Editor edit = login.edit();
                edit.putBoolean("isLogin",true);
                edit.putString("data",new Gson().toJson(userLoginBean));
                edit.commit();
                Intent intent = new Intent(this, MainActivity.class);
                intent.putExtra("login",0);
                startActivity(intent);
            }
            else {
                Toast.makeText(this, "登陆失败！用户名或密码错误", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.img_back:
                Intent intent = new Intent(this, MainActivity.class);
                intent.putExtra("login",1);
                startActivity(intent);
                finish();
                break;
            case R.id.tv_register:
                startActivity(new Intent(this,RegisterActivity.class));
                break;
            case R.id.tv_login:
                String userName = etUserName.getText().toString();
                String password = etPassword.getText().toString();
                if (!TextUtils.isEmpty(userName) && !TextUtils.isEmpty(password)){
                    Map<String,String> map = new HashMap<>();
                    map.put("username",userName);
                    map.put("password",password);
                    presenter.login(map);
                }
                break;
            case R.id.img_reset:
                etUserName.setText("");
                break;
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("login",1);
        startActivity(intent);
        super.onBackPressed();
    }
}
