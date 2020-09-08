package com.example.tongpao.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.tongpao.R;
import com.example.tongpao.base.BaseAdapter;
import com.example.tongpao.bean.ArticleBean;

public class InfoArticleAdapter extends BaseAdapter<ArticleBean.DataBean.ArticlesBean> {
    public InfoArticleAdapter(Context context) {
        super(context);
    }

    @Override
    protected int getLayout() {
        return R.layout.layout_article_item;
    }

    @Override
    protected void bindData(BaseViewHolder holder, ArticleBean.DataBean.ArticlesBean dataBean) {
        ImageView imgCover = (ImageView) holder.getView(R.id.img_cover);
        TextView tvTitle = (TextView) holder.getView(R.id.tv_title);
        TextView tvDes = (TextView) holder.getView(R.id.tv_des);
        TextView tvName = (TextView) holder.getView(R.id.tv_name);
        TextView tvTime = (TextView) holder.getView(R.id.tv_time);
        if (!TextUtils.isEmpty(dataBean.getCover())){
            Glide.with(context).load(dataBean.getCover()).into(imgCover);
        }
        if (!TextUtils.isEmpty(dataBean.getTitle())){
            tvTitle.setText(dataBean.getTitle());
            tvDes.setText(dataBean.getTitle());
        }
        if (!TextUtils.isEmpty(dataBean.getNickName())){
            tvName.setText(dataBean.getNickName());
        }
        if (!TextUtils.isEmpty(dataBean.getCreateTime())){
            tvTime.setText(dataBean.getCreateTime());
        }
    }
}
