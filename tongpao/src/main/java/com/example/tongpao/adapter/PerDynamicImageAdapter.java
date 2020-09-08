package com.example.tongpao.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.tongpao.R;
import com.example.tongpao.base.BaseAdapter;
import com.example.tongpao.bean.PerDynamicStateBean;
import com.example.tongpao.util.SystemUtils;

public class PerDynamicImageAdapter extends BaseAdapter<PerDynamicStateBean.DataBean.DynamicsBean.ImagesBean> {
    public PerDynamicImageAdapter(Context context) {
        super(context);
    }

    @Override
    protected int getLayout() {
        return R.layout.layout_re_image_item;
    }

    @Override
    protected void bindData(BaseViewHolder holder, PerDynamicStateBean.DataBean.DynamicsBean.ImagesBean dataBean) {
        ImageView imageView = (ImageView) holder.getView(R.id.imageView);
        //设置头像的圆角
        int round = SystemUtils.px2Dp(context,50);
        RoundedCorners roundedCorners = new RoundedCorners(round);
        RequestOptions options = RequestOptions.bitmapTransform(roundedCorners);
        Glide.with(context).load(dataBean.getFilePath()).apply(options).into(imageView);
    }
}
