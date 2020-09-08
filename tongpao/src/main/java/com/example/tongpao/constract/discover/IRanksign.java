package com.example.tongpao.constract.discover;


import com.example.tongpao.base.IBasePresenter;
import com.example.tongpao.base.IBaseView;
import com.example.tongpao.bean.discover.DiscoverRankSignBean;

public interface IRanksign {
    interface IRanksignView extends IBaseView {
        void getIRanksignReturn(DiscoverRankSignBean discoverRankSignBean);
    }
    interface IRanksignPresenter extends IBasePresenter<IRanksignView> {
        void getIRanksignPresenter();
    }
}
