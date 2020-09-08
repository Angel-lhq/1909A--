package com.example.tongpao.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.tongpao.R;
import com.example.tongpao.base.BaseAdapter;
import com.example.tongpao.bean.VideoBean;
import com.example.tongpao.common.CircleTransform;

public class InfoVideoAdapter extends BaseAdapter<VideoBean.DataBean.ListBean> {
    public InfoVideoAdapter(Context context) {
        super(context);
    }

    @Override
    protected int getLayout() {
        return R.layout.layout_video_item;
    }

    @Override
    protected void bindData(BaseViewHolder holder, VideoBean.DataBean.ListBean dataBean) {
        ImageView imgCover = (ImageView) holder.getView(R.id.img_cover);
        TextView tvTitle = (TextView) holder.getView(R.id.tv_title);
        ImageView imgHead = (ImageView) holder.getView(R.id.img_head);
        TextView tvName = (TextView) holder.getView(R.id.tv_name);
        TextView tvLike = (TextView) holder.getView(R.id.tv_like);
        if (!TextUtils.isEmpty(dataBean.getCover())){
            Glide.with(context).load(dataBean.getCover()).into(imgCover);
        }
        if (!TextUtils.isEmpty(dataBean.getContent())){
            tvTitle.setText(dataBean.getContent());
        }
        if (!TextUtils.isEmpty(dataBean.getHeadUrl())){
            Glide.with(context).load(dataBean.getHeadUrl())
                    .apply(RequestOptions.bitmapTransform(new CircleTransform(context)))
                    .apply(RequestOptions.circleCropTransform())
                    .into(imgHead);
        }
        if (!TextUtils.isEmpty(dataBean.getNickName())){
            tvName.setText(dataBean.getNickName());
        }
        tvLike.setText(dataBean.getLikeNumber()+"");
    }
}
