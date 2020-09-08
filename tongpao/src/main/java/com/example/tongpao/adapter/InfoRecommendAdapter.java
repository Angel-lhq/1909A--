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
import com.example.tongpao.bean.RecommendBean;
import com.example.tongpao.myview.ExpandTextView;
import com.example.tongpao.ui.home.activity.OtherActivity;
import com.example.tongpao.ui.home.activity.PerInfoActivity;
import com.example.tongpao.util.DateUtil;
import com.example.tongpao.util.SystemUtils;
import com.google.gson.Gson;

import java.util.List;

public class InfoRecommendAdapter extends BaseAdapter<RecommendBean.DataBean> {
    public InfoRecommendAdapter(Context context) {
        super(context);
    }

    @Override
    protected int getLayout() {
        return R.layout.layout_recommend_item;
    }

    @Override
    protected void bindData(BaseViewHolder holder, RecommendBean.DataBean dataBean) {
        ImageView imgHead = (ImageView) holder.getView(R.id.img_head);
        ImageView imgLevel = (ImageView) holder.getView(R.id.img_level);
        TextView tvUserName = (TextView) holder.getView(R.id.txt_username);
        TextView tvDate = (TextView) holder.getView(R.id.txt_date);
        TextView tvFollow = (TextView) holder.getView(R.id.txt_follow);
        ExpandTextView tvDes = (ExpandTextView) holder.getView(R.id.txt_des);
        RecyclerView recyclerImgs = (RecyclerView) holder.getView(R.id.recycler_imgs);
        TextView tvFollowNums = (TextView) holder.getView(R.id.txt_follow_nums);
        TextView tvComment = (TextView) holder.getView(R.id.txt_comment);

        RecommendBean.DataBean.PostDetailBean postDetail = dataBean.getPostDetail();
        //设置头像的圆角
        int round = SystemUtils.px2Dp(context,50);
        RoundedCorners roundedCorners = new RoundedCorners(round);
        RequestOptions options = RequestOptions.bitmapTransform(roundedCorners);
        Glide.with(context).load(postDetail.getHeadUrl()).apply(options).into(imgHead);
        //点击头像跳转到个人信息页面
        imgHead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, PerInfoActivity.class));
            }
        });

        if (!TextUtils.isEmpty(postDetail.getNickName())){
            tvUserName.setText(postDetail.getNickName());
        }
        //显示时间
        if(!TextUtils.isEmpty(postDetail.getCreateTime())){
            Long time = DateUtil.getDateToTime(postDetail.getCreateTime(),null);
            String dateStr = DateUtil.getStandardDate(time);
            tvDate.setText(dateStr);
        }
        //内容的显示 ##包裹起来数据  @符号后面的数据
        String content = postDetail.getContent();

        WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        int width = manager.getDefaultDisplay().getWidth();
        tvDes.initWidth(width);
        tvDes.setCloseText(content);

        //显示嵌套的GridView效果的图片

        List<RecommendBean.DataBean.PostDetailBean.ImagesBean> images = postDetail.getImages();
        DetailImageAdapter imageAdapter = new DetailImageAdapter(context);
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
                String json = new Gson().toJson(postDetail);
                Intent intent = new Intent(context, OtherActivity.class);
                intent.putExtra("data",json);
                intent.putExtra("posi",position);
                context.startActivity(intent);
                //ActivityOptions.makeSceneTransitionAnimation((Activity) view.getContext(), view, "sharedView").toBundle()
            }
        });

        tvFollowNums.setText(String.valueOf(postDetail.getLikeNumber()));
        tvComment.setText(String.valueOf(postDetail.getCommentNumber()));

    }
}
