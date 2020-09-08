package com.example.tongpao.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.tongpao.R;
import com.example.tongpao.base.BaseAdapter;
import com.example.tongpao.bean.SingleBean;

public class InfoSingleAdapter extends BaseAdapter<SingleBean.DataBean> {

    public InfoSingleAdapter(Context context) {
        super(context);
    }

    @Override
    protected int getLayout() {
        return R.layout.layout_single_item;
    }

    @Override
    protected void bindData(BaseViewHolder holder, SingleBean.DataBean dataBean) {
        ImageView imgCover = (ImageView) holder.getView(R.id.img_cover);
        TextView tvSingleTitle = (TextView) holder.getView(R.id.tv_single_title);
        TextView tvSingleContent = (TextView) holder.getView(R.id.tv_single_content);
        if (!TextUtils.isEmpty(dataBean.getCover())){
            Glide.with(context).load(dataBean.getCover()).into(imgCover);
        }
        if (!TextUtils.isEmpty(dataBean.getTitle())){
            tvSingleTitle.setText(dataBean.getTitle());
        }
        if (!TextUtils.isEmpty(dataBean.getContentDescribe())){
            tvSingleContent.setText(dataBean.getContentDescribe());
        }
    }
}
