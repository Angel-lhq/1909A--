package com.example.tongpao.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.tongpao.R;
import com.example.tongpao.base.BaseAdapter;
import com.example.tongpao.bean.PerActiviesBean;

import java.util.List;

public class InfoPerActivitiesAdapter extends BaseAdapter<PerActiviesBean.DataBean.ActivitysBean> {
    public InfoPerActivitiesAdapter(Context context) {
        super(context);
    }

    @Override
    protected int getLayout() {
        return R.layout.layout_per_activities_item;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void bindData(BaseViewHolder holder, PerActiviesBean.DataBean.ActivitysBean dataBean) {
        ImageView imgHead = (ImageView) holder.getView(R.id.img_title);
        TextView tvOverOrNot = (TextView) holder.getView(R.id.tv_overornot);
        TextView tvTitle = (TextView) holder.getView(R.id.tv_title);
        LinearLayout linearCommunity = (LinearLayout) holder.getView(R.id.linear_community);
        TextView tvTime = (TextView) holder.getView(R.id.tv_time);
        TextView tvApply = (TextView) holder.getView(R.id.tv_apply);
        TextView tvLocation = (TextView) holder.getView(R.id.tv_location);
        if (!TextUtils.isEmpty(dataBean.getCover())){
            Glide.with(context).load(dataBean.getCover()).apply(
                    RequestOptions.bitmapTransform(new RoundedCorners(10))
            ).into(imgHead);
        }
        if (!TextUtils.isEmpty(dataBean.getTitle())){
            tvTitle.setText(dataBean.getTitle());
        }

        linearCommunity.removeAllViews();
        List<PerActiviesBean.DataBean.ActivitysBean.ColorTagsBean> colorTags = dataBean.getColorTags();
        for (PerActiviesBean.DataBean.ActivitysBean.ColorTagsBean item:colorTags) {
            TextView tv_tag = (TextView) LayoutInflater.from(context).inflate(R.layout.layout_text_tag, null);
            tv_tag.setText(item.getTagName());
            tv_tag.setTextColor(Color.parseColor(item.getTagColor()));
            linearCommunity.addView(tv_tag);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
            params.setMarginEnd(10);
            tv_tag.setLayoutParams(params);
            //动态修改边框的颜色
            GradientDrawable gradientDrawable = (GradientDrawable) tv_tag.getBackground();
            gradientDrawable.setStroke(2,Color.parseColor(item.getTagColor()));
        }

        if (!TextUtils.isEmpty(dataBean.getStartTime())){
            tvTime.setText(dataBean.getStartTime());
        }
        tvApply.setText("已报名："+dataBean.getApplyUserCount()+"人");
        if (!TextUtils.isEmpty(dataBean.getLocation())){
            tvLocation.setText(dataBean.getLocation());
        }
    }
}
