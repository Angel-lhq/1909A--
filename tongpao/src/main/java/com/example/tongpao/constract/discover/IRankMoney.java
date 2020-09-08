package com.example.tongpao.constract.discover;


import com.example.tongpao.base.IBasePresenter;
import com.example.tongpao.base.IBaseView;
import com.example.tongpao.bean.discover.DiscoverRankMoneyBean;

public interface IRankMoney {
    interface IRankMoneyView extends IBaseView {
        void getIRankMoneyReturn(DiscoverRankMoneyBean discoverRankMoneyBean);
    }
    interface IRankMoneyPresenter extends IBasePresenter<IRankMoneyView> {
        void getIRankMoney();
    }
}
