package com.example.tongpao.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.tongpao.R;
import com.example.tongpao.base.BaseAdapter;
import com.example.tongpao.bean.PerCommunityBean;

public class InfoCummunityAdapter extends BaseAdapter<PerCommunityBean.DataBean> {
    public InfoCummunityAdapter(Context context) {
        super(context);
    }

    @Override
    protected int getLayout() {
        return R.layout.layout_community_item;
    }

    @Override
    protected void bindData(BaseViewHolder holder, PerCommunityBean.DataBean dataBean) {
        ImageView imgTitle = (ImageView) holder.getView(R.id.img_title);
        TextView tvName = (TextView) holder.getView(R.id.tv_name);
        TextView tvMember = (TextView) holder.getView(R.id.tv_member);
        TextView tvActivity = (TextView) holder.getView(R.id.tv_activity);
        TextView tvDes = (TextView) holder.getView(R.id.tv_des);
        if (!TextUtils.isEmpty(dataBean.getLogo())){
            Glide.with(context).load(dataBean.getLogo()).apply(RequestOptions.bitmapTransform(new RoundedCorners(10))).into(imgTitle);
        }
        if (!TextUtils.isEmpty(dataBean.getDepict())){
            tvName.setText(dataBean.getDepict());
        }
        tvMember.setText("成员："+dataBean.getCountUser());
        tvActivity.setText("活动："+dataBean.getCountActivity());
        if (!TextUtils.isEmpty(dataBean.getNote())){
            tvDes.setText(dataBean.getNote());
        }
    }
}
