package com.example.tongpao.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.tongpao.R;
import com.example.tongpao.base.BaseAdapter;
import com.example.tongpao.bean.AboutHanFuBean;

public class InfoAboutAdapter extends BaseAdapter<AboutHanFuBean.DataBean> {

    public InfoAboutAdapter(Context context) {
        super(context);
    }

    @Override
    protected int getLayout() {
        return R.layout.layout_about_item;
    }

    @Override
    protected void bindData(BaseViewHolder holder, AboutHanFuBean.DataBean dataBean) {
        ImageView imgCover = (ImageView) holder.getView(R.id.img_cover);
        TextView tvAboutTitle = (TextView) holder.getView(R.id.tv_about_title);
        TextView tvAboutContent = (TextView) holder.getView(R.id.tv_about_content);
        if (!TextUtils.isEmpty(dataBean.getCover())){
            Glide.with(context).load(dataBean.getCover()).into(imgCover);
        }
        if (!TextUtils.isEmpty(dataBean.getTitle())){
            tvAboutTitle.setText(dataBean.getTitle());
        }
        if (!TextUtils.isEmpty(dataBean.getContentDescribe())){
            tvAboutContent.setText(dataBean.getContentDescribe());
        }
    }
}
