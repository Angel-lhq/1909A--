package com.example.tongpao.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.tongpao.R;
import com.example.tongpao.base.BaseAdapter;
import com.example.tongpao.bean.RecommendBean;

public class InfoLikeDetailAdapter extends BaseAdapter<RecommendBean.DataBean.PostDetailBean.LikeDetailsBean> {
    public InfoLikeDetailAdapter(Context context) {
        super(context);
    }

    @Override
    protected int getLayout() {
        return R.layout.layout_like_detail_item;
    }

    @Override
    protected void bindData(BaseViewHolder holder, RecommendBean.DataBean.PostDetailBean.LikeDetailsBean dataBean) {
        ImageView imgHead = (ImageView) holder.getView(R.id.img_head);
        ImageView imgLevel = (ImageView) holder.getView(R.id.img_level);
        TextView tvUserName = (TextView) holder.getView(R.id.txt_username);
        TextView tvDate = (TextView) holder.getView(R.id.txt_date);
        TextView tvFollow = (TextView) holder.getView(R.id.txt_follow);
        //设置头像的圆角
        RequestOptions options = RequestOptions.bitmapTransform(new CircleCrop());
        Glide.with(context).load(dataBean.getHeadUrl()).apply(options).into(imgHead);

        if (!TextUtils.isEmpty(dataBean.getNickName())){
            tvUserName.setText(dataBean.getNickName());
        }
        //显示时间
        if(!TextUtils.isEmpty(dataBean.getLikeTime())){
            tvDate.setText(dataBean.getLikeTime());
        }
    }
}
