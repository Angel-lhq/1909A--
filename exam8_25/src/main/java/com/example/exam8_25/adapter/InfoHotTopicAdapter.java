package com.example.exam8_25.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.exam8_25.R;
import com.example.exam8_25.base.BaseAdapter;
import com.example.exam8_25.bean.HotTopicBean;

public class InfoHotTopicAdapter extends BaseAdapter<HotTopicBean.DataBean> {
    private int[] colors = new int[]{
            R.color.card_color1,
            R.color.card_color2,
            R.color.card_color3,
            R.color.card_color4,
            R.color.card_color5,
            R.color.card_color6
    };
    public InfoHotTopicAdapter(Context context) {
        super(context);
    }

    @Override
    protected int getLayout() {
        return R.layout.layout_hot_topic;
    }

    @Override
    protected void bindData(BaseViewHolder holder, HotTopicBean.DataBean dataBean) {
        ImageView imgTopic = (ImageView) holder.getView(R.id.img_topic);
        TextView tvTitle = (TextView) holder.getView(R.id.tv_title_topic);
        TextView tvUsertime = (TextView) holder.getView(R.id.tv_usetime_topic);
        ConstraintLayout topic = (ConstraintLayout) holder.getView(R.id.topic);
        tvTitle.setText("#"+ dataBean.getName()+"#");
        tvUsertime.setText(dataBean.getUseTime()+"人参与");
        Glide.with(context).load(dataBean.getImageUrl())
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(10))).into(imgTopic);
        topic.setBackgroundResource(colors[holder.getLayoutPosition()]);
    }
}
