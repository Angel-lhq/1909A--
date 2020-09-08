package com.example.exam8_25.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.exam8_25.R;
import com.example.exam8_25.base.BaseAdapter;
import com.example.exam8_25.bean.HotPostBean;

public class DetailImageAdapter extends BaseAdapter<HotPostBean.DataBean.DynamicsBean.ImagesBean> {
    public DetailImageAdapter(Context context) {
        super(context);
    }

    @Override
    protected int getLayout() {
        return R.layout.layout_re_image_item;
    }

    @Override
    protected void bindData(BaseViewHolder holder, HotPostBean.DataBean.DynamicsBean.ImagesBean dataBean) {
        ImageView imageView = (ImageView) holder.getView(R.id.imageView);
        //设置头像的圆角
        RoundedCorners roundedCorners = new RoundedCorners(10);
        RequestOptions options = RequestOptions.bitmapTransform(roundedCorners);
        Glide.with(context).load(dataBean.getFilePath()).apply(options).into(imageView);
    }
}
