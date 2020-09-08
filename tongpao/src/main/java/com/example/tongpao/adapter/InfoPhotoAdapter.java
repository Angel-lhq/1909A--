package com.example.tongpao.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.tongpao.R;
import com.example.tongpao.base.BaseAdapter;
import com.example.tongpao.bean.PhotoBean;

import java.util.List;

public class InfoPhotoAdapter extends BaseAdapter<PhotoBean.DataBean.DynamicsBean> {
    public InfoPhotoAdapter(Context context) {
        super(context);
    }

    @Override
    protected int getLayout() {
        return R.layout.layout_photo_item;
    }

    @Override
    protected void bindData(BaseViewHolder holder, PhotoBean.DataBean.DynamicsBean dataBean) {
        ImageView imgCover = (ImageView) holder.getView(R.id.img_cover);
        TextView tvContent = (TextView) holder.getView(R.id.tv_content);
        ImageView imgHead = (ImageView) holder.getView(R.id.img_head);
        TextView tvName = (TextView) holder.getView(R.id.tv_name);
        TextView tvLike = (TextView) holder.getView(R.id.tv_like);
        List<PhotoBean.DataBean.DynamicsBean.ImagesBean> images = dataBean.getImages();
        if (images.size()>0){
            String filePath = images.get(0).getFilePath();
            if (!TextUtils.isEmpty(filePath)){
                Glide.with(context).load(filePath).into(imgCover);
            }
        }
        if (!TextUtils.isEmpty(dataBean.getContent())){
            tvContent.setText(dataBean.getContent());
        }
        if (!TextUtils.isEmpty(dataBean.getNickName())){
            tvName.setText(dataBean.getNickName());
        }
        if (!TextUtils.isEmpty(dataBean.getHeadUrl())){
            Glide.with(context).load(dataBean.getHeadUrl()).apply(RequestOptions.circleCropTransform()).into(imgHead);
        }
        tvLike.setText(dataBean.getLikeNumber()+"");
    }
}
