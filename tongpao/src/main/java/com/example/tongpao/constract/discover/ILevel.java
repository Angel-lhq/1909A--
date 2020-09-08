package com.example.tongpao.constract.discover;

import com.example.tongpao.base.IBasePresenter;
import com.example.tongpao.base.IBaseView;
import com.example.tongpao.bean.discover.DiscoverranklevelBean;

public interface ILevel {
    interface ILeveliew extends IBaseView {
        //排行榜 等级榜
        void getLevelReturn(DiscoverranklevelBean discoverranklevelBean);
    }
    interface ILevelPresenter extends IBasePresenter<ILeveliew> {
        //排行榜 等级榜
        void getLevel();
    }
}
