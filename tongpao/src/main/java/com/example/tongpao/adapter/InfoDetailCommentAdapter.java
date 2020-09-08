package com.example.tongpao.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.tongpao.R;
import com.example.tongpao.base.BaseAdapter;
import com.example.tongpao.bean.RecommendBean;

public class InfoDetailCommentAdapter extends BaseAdapter<RecommendBean.DataBean.CommentsBean.AllCommentsBean> {
    public InfoDetailCommentAdapter(Context context) {
        super(context);
    }

    @Override
    protected int getLayout() {
        return R.layout.layout_detail_comment_item;
    }

    @Override
    protected void bindData(BaseViewHolder holder, RecommendBean.DataBean.CommentsBean.AllCommentsBean dataBean) {
        ImageView imgHead = (ImageView) holder.getView(R.id.img_head);
        ImageView imgLevel = (ImageView) holder.getView(R.id.img_level);
        TextView tvUserName = (TextView) holder.getView(R.id.txt_username);
        TextView tvDate = (TextView) holder.getView(R.id.txt_date);
        TextView tvFollow = (TextView) holder.getView(R.id.txt_follow);
        TextView tvDes = (TextView) holder.getView(R.id.txt_des);
        Log.i("TAG", "bindData: " + dataBean.getNickName());
        //设置头像的圆角
        RequestOptions options = RequestOptions.bitmapTransform(new CircleCrop());
        Glide.with(context).load(dataBean.getHeadUrl()).apply(options).into(imgHead);

        if (!TextUtils.isEmpty(dataBean.getNickName())){
            tvUserName.setText(dataBean.getNickName());
        }

        //显示时间
        if(!TextUtils.isEmpty(dataBean.getCreateTime())){
            tvDate.setText(dataBean.getCreateTime());
        }
        String comment = dataBean.getComment();
        if (tvDes != null && !TextUtils.isEmpty(comment)){
            tvDes.setText(comment);
        }
        tvFollow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tvFollow.isSelected()){
                    tvFollow.setSelected(false);
                    tvFollow.setText("0");
                }else {
                    tvFollow.setSelected(true);
                    tvFollow.setText("1");
                }
            }
        });
    }
}
