package com.example.tongpao.base;

/**
 * p层基类接口
 * @param <T>
 */
public interface IBasePresenter<T extends IBaseView> {
    void attachView(T t);
    void detachView();
}
