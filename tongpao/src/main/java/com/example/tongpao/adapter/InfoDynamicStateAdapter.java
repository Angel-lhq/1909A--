package com.example.tongpao.adapter;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.tongpao.R;
import com.example.tongpao.base.BaseAdapter;
import com.example.tongpao.bean.PerDynamicStateBean;
import com.example.tongpao.myview.ExpandTextView;
import com.example.tongpao.ui.home.activity.OtherActivity;
import com.example.tongpao.ui.home.activity.PerInfoActivity;
import com.example.tongpao.util.DateUtil;
import com.example.tongpao.util.SystemUtils;
import com.google.gson.Gson;

import java.util.List;

public class InfoDynamicStateAdapter extends BaseAdapter<PerDynamicStateBean.DataBean.DynamicsBean> {
    public InfoDynamicStateAdapter(Context context) {
        super(context);
    }

    @Override
    protected int getLayout() {
        return R.layout.layout_dynamic_item;
    }

    @Override
    protected void bindData(BaseViewHolder holder, PerDynamicStateBean.DataBean.DynamicsBean dataBean) {
        ImageView imgHead = (ImageView) holder.getView(R.id.img_head);
        ImageView imgLevel = (ImageView) holder.getView(R.id.img_level);
        TextView tvUserName = (TextView) holder.getView(R.id.txt_username);
        TextView tvDate = (TextView) holder.getView(R.id.txt_date);
        TextView tvFollow = (TextView) holder.getView(R.id.txt_follow);
        ExpandTextView tvDes = (ExpandTextView) holder.getView(R.id.txt_des);
        RecyclerView recyclerImgs = (RecyclerView) holder.getView(R.id.recycler_imgs);
        TextView tvFollowNums = (TextView) holder.getView(R.id.txt_follow_nums);
        TextView tvComment = (TextView) holder.getView(R.id.txt_comment);
        //设置头像的圆角
        int round = SystemUtils.px2Dp(context,50);
        RoundedCorners roundedCorners = new RoundedCorners(round);
        RequestOptions options = RequestOptions.bitmapTransform(roundedCorners);
        Glide.with(context).load(dataBean.getHeadUrl()).apply(options).into(imgHead);
        //点击头像跳转到个人信息页面
        imgHead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, PerInfoActivity.class));
            }
        });

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

        //显示嵌套的GridView效果的图片

        List<PerDynamicStateBean.DataBean.DynamicsBean.ImagesBean> images = dataBean.getImages();
        PerDynamicImageAdapter imageAdapter = new PerDynamicImageAdapter(context);
        imageAdapter.setData(images);
        recyclerImgs.setLayoutManager(new GridLayoutManager(context,3){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        recyclerImgs.setAdapter(imageAdapter);
        imageAdapter.setiOnClick(new IOnClick() {
            @Override
            public void onClick(int position, Object o,View view) {
                String json = new Gson().toJson(dataBean);
                Intent intent = new Intent(context, OtherActivity.class);
                intent.putExtra("perdata",json);
                intent.putExtra("perposi",position);
                context.startActivity(intent);
                //ActivityOptions.makeSceneTransitionAnimation((Activity) view.getContext(), view, "sharedView").toBundle()
            }
        });

        tvFollowNums.setText(String.valueOf(dataBean.getLikeNumber()));
        tvComment.setText(String.valueOf(dataBean.getCommentNumber()));

    }
}
