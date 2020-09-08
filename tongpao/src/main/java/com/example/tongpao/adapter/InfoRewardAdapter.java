package com.example.tongpao.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.tongpao.R;
import com.example.tongpao.base.BaseAdapter;
import com.example.tongpao.bean.RewardBean;

public class InfoRewardAdapter extends BaseAdapter<RewardBean.DataBean.ListBean> {
    public InfoRewardAdapter(Context context) {
        super(context);
    }

    @Override
    protected int getLayout() {
        return R.layout.layout_reward_item;
    }

    @Override
    protected void bindData(BaseViewHolder holder, RewardBean.DataBean.ListBean dataBean) {
        TextView tvMoney = (TextView) holder.getView(R.id.tv_money);
        ImageView imgHead = (ImageView) holder.getView(R.id.img_head);
        TextView tvName = (TextView) holder.getView(R.id.tv_name);
        TextView tvContent = (TextView) holder.getView(R.id.tv_content);
        TextView tvTime = (TextView) holder.getView(R.id.tv_time);
        TextView tvLast = (TextView) holder.getView(R.id.tv_last);
        TextView tvLastTime = (TextView) holder.getView(R.id.tv_last_time);
        tvMoney.setText(dataBean.getRewardmoney()+"铜钱");
        if (!TextUtils.isEmpty(dataBean.getHeadUrl())){
            Glide.with(context).load(dataBean.getHeadUrl()).into(imgHead);
        }
        if (!TextUtils.isEmpty(dataBean.getNickName())){
            tvName.setText(dataBean.getNickName());
        }
        if (!TextUtils.isEmpty(dataBean.getContent())){
            tvContent.setText(dataBean.getContent());
        }
        if (!TextUtils.isEmpty(dataBean.getCreatetime())){
            tvTime.setText(dataBean.getCreatetime());
        }
        tvLast.setText(dataBean.getJoinCount() + "人参加");
        if (!TextUtils.isEmpty(dataBean.getSurplusDate())){
            tvLastTime.setText(dataBean.getSurplusDate());
        }
    }
}
