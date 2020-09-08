package com.example.tongpao.constract.discover;


import com.example.tongpao.base.IBasePresenter;
import com.example.tongpao.base.IBaseView;
import com.example.tongpao.bean.discover.AssociationBean;
import com.example.tongpao.bean.discover.NearByBean;
import com.example.tongpao.bean.discover.RoommateBean;

public interface IFind {


    interface DisView extends IBaseView {
        //袍子
        void getRoommateReturn(RoommateBean result);

        //袍子附近
        void getNearByReturn(NearByBean result);
    }

    interface DisPresenter extends IBasePresenter<DisView> {
        //袍子
        void getRoommateData();

        //袍子附近
        void getNearByData();

    }



    interface DoView extends IBaseView {

        void getAssociationReturn(AssociationBean result);
    }

    interface DoPresenter extends IBasePresenter<DoView> {

        void getAssociation();
    }

}
