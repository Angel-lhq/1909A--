package com.example.tongpao.constract.discover;

import com.example.tongpao.base.IBasePresenter;
import com.example.tongpao.base.IBaseView;
import com.example.tongpao.bean.discover.DiscoverZhuangzaoBean;

public interface IZhuangzao {
    interface IZhuangzaoView extends IBaseView {
        void getIZhuangzaoReturn(DiscoverZhuangzaoBean discoverZhuangzaoBean);
    }
    interface IZhuangzaoPresenter extends IBasePresenter<IZhuangzaoView> {
        void getIZhuangzao();
    }
}
