package com.example.exam8_25.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.exam8_25.R;
import com.example.exam8_25.base.BaseAdapter;
import com.example.exam8_25.bean.HotPostBean;
import com.example.exam8_25.myview.ExpandTextView;
import com.example.exam8_25.util.DateUtil;
import com.example.exam8_25.util.UserUtil;

import java.util.List;

import cn.jzvd.JzvdStd;

public class InfoHotPostAdapter extends BaseAdapter<HotPostBean.DataBean.DynamicsBean> {
    public InfoHotPostAdapter(Context context) {
        super(context);
    }

    @Override
    protected int getLayout() {
        return R.layout.layout_hot_post_item;
    }

    @Override
    protected void bindData(BaseViewHolder holder, HotPostBean.DataBean.DynamicsBean dataBean) {
        ImageView imgHead = (ImageView) holder.getView(R.id.img_head);
        ImageView imgLevel = (ImageView) holder.getView(R.id.img_level);
        ImageView imgImage = (ImageView) holder.getView(R.id.img_image);
        JzvdStd jz = (JzvdStd) holder.getView(R.id.jz);
        TextView tvUserName = (TextView) holder.getView(R.id.txt_username);
        TextView tvDate = (TextView) holder.getView(R.id.txt_date);
        TextView tvFollow = (TextView) holder.getView(R.id.txt_follow);
        ExpandTextView tvDes = (ExpandTextView) holder.getView(R.id.txt_des);
        RecyclerView recyclerImgs = (RecyclerView) holder.getView(R.id.recycler_imgs);
        TextView tvFollowNums = (TextView) holder.getView(R.id.txt_follow_nums);
        TextView tvComment = (TextView) holder.getView(R.id.txt_comment);

        RequestOptions options = RequestOptions.bitmapTransform(new CircleCrop());
        Glide.with(context).load(dataBean.getHeadUrl()).apply(options).into(imgHead);

        if (!TextUtils.isEmpty(dataBean.getNickName())){
            tvUserName.setText(dataBean.getNickName());
        }
        //显示时间
        if(!TextUtils.isEmpty(dataBean.getCreateTime())){
            Long time = DateUtil.getDateToTime(dataBean.getCreateTime(),null);
            String dateStr = DateUtil.getStandardDate(time);
            tvDate.setText(dateStr);
        }
        //内容的显示 ##包裹起来数据  @符号后面的数据
        String content = dataBean.getContent();

        WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        int width = manager.getDefaultDisplay().getWidth();
        tvDes.initWidth(width);
        tvDes.setCloseText(content);

        recyclerImgs.setVisibility(View.GONE);
        imgImage.setVisibility(View.GONE);
        jz.setVisibility(View.GONE);
        //显示嵌套的GridView效果的图片
        List<HotPostBean.DataBean.DynamicsBean.ImagesBean> images = dataBean.getImages();
        if (images.size()>0){
            if (images.size()>1){
                recyclerImgs.setVisibility(View.VISIBLE);
                DetailImageAdapter imageAdapter = new DetailImageAdapter(context);
                imageAdapter.setData(images);
                recyclerImgs.setLayoutManager(new GridLayoutManager(context,3){
                    @Override
                    public boolean canScrollVertically() {
                        return false;
                    }
                });
                recyclerImgs.setAdapter(imageAdapter);
            } else {
                imgImage.setVisibility(View.VISIBLE);
                Glide.with(context).load(images.get(0).getFilePath()).apply(RequestOptions.bitmapTransform(new RoundedCorners(5))).into(imgImage);
            }
        }
        String videoPath = dataBean.getVideoPath();
        String cover = dataBean.getCover();
        if (!TextUtils.isEmpty(videoPath) && !TextUtils.isEmpty(cover)){
            jz.setVisibility(View.VISIBLE);
            jz.setUp(videoPath,dataBean.getTitle());
            Glide.with(context).load(cover).into(jz.thumbImageView);
        }
        imgLevel.setImageResource(UserUtil.getResByLevel(dataBean.getLevel()));
        tvFollowNums.setText(String.valueOf(dataBean.getLikeNumber()));
        tvComment.setText(String.valueOf(dataBean.getCommentNumber()));

    }
}
