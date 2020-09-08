package com.example.tongpao.common;

import com.example.tongpao.bean.PerActiviesBean;
import com.example.tongpao.bean.PerInfoBean;

public class EventContant {
    private PerInfoBean perInfoBean;
    private PerActiviesBean.DataBean.ActivitysBean activitysBean;

    public PerInfoBean getPerInfoBean() {
        return perInfoBean;
    }

    public void setPerInfoBean(PerInfoBean perInfoBean) {
        this.perInfoBean = perInfoBean;
    }

    public PerActiviesBean.DataBean.ActivitysBean getActivitysBean() {
        return activitysBean;
    }

    public void setActivitysBean(PerActiviesBean.DataBean.ActivitysBean activitysBean) {
        this.activitysBean = activitysBean;
    }
}
