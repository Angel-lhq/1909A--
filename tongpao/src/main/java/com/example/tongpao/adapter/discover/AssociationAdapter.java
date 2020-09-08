package com.example.tongpao.adapter.discover;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.tongpao.R;
import com.example.tongpao.base.BaseAdapter;
import com.example.tongpao.bean.discover.AssociationBean;

public class AssociationAdapter extends BaseAdapter {


    public AssociationAdapter(Context context) {
        super(context);
    }

    @Override
    protected int getLayout() {
        return R.layout.adapter_association;
    }

    @Override
    protected void bindData(BaseViewHolder baseViewHolder, Object data) {
        AssociationBean.DataBean.ListBean listBean = (AssociationBean.DataBean.ListBean) data;
       // 头像
        ImageView img_ass_head = (ImageView) baseViewHolder.getView(R.id.img_ass_head);
        Glide.with(context).load(listBean.getLogo()).into(img_ass_head);
        //社团名称
        TextView tv_ass_name = (TextView) baseViewHolder.getView(R.id.tv_ass_name);
        tv_ass_name.setText(listBean.getFullName());
        //人数
        TextView tv_num = (TextView) baseViewHolder.getView(R.id.tv_num);
        tv_num.setText("参与人数："+listBean.getCountUser()+"");
        //活动
        TextView tv_activities = (TextView) baseViewHolder.getView(R.id.tv_activities);
        tv_activities.setText("活动："+listBean.getCountActivity() + "");
        //详情
        TextView tv_ass_desc = (TextView) baseViewHolder.getView(R.id.tv_ass_desc);
        tv_ass_desc.setText(listBean.getNote());
    }

    @Override
    public void clearData() {

    }


}
