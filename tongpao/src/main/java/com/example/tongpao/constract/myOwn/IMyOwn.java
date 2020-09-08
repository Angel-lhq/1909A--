package com.example.tongpao.constract.myOwn;

import com.example.tongpao.base.IBasePresenter;
import com.example.tongpao.base.IBaseView;
import com.example.tongpao.bean.UserLoginBean;
import com.example.tongpao.bean.UserRegisterBean;
import com.example.tongpao.bean.UserUpdateBean;

import java.util.Map;

public interface IMyOwn {
    interface IView extends IBaseView{

    }
    interface IPresenter extends IBasePresenter{

    }
    //登录
    interface ILoginView extends IBaseView{
        void loginReturn(UserLoginBean userLoginBean);
    }
    interface ILoginPresenter extends IBasePresenter<ILoginView>{
        void login(Map<String,String> map);
    }
    //注册
    interface IRegisterView extends IBaseView{
        void registerReturn(UserRegisterBean userRegisterBean);
    }
    interface IRegisterPresenter extends IBasePresenter<IRegisterView>{
        void register(Map<String,String> map);
    }
    //更新用户信息
    interface IUpDateView extends IBaseView{
        void upDateReturn(UserUpdateBean userUpdateBean);
    }
    interface IUpDatePresenter extends IBasePresenter<IUpDateView>{
        void upDate(Map<String,String> map);
    }

}
