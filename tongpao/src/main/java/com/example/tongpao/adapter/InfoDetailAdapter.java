package com.example.tongpao.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
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
import com.example.tongpao.myview.CustomAvaterView;
import com.example.tongpao.ui.home.activity.LikeDetailActivity;
import com.example.tongpao.ui.home.activity.OtherActivity;
import com.example.tongpao.ui.home.activity.PerInfoActivity;
import com.example.tongpao.util.DateUtil;
import com.example.tongpao.util.SystemUtils;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InfoDetailAdapter extends BaseAdapter<RecommendBean.DataBean> {

    private static final int MAX_HEADER_NUMBER = 10;

    public InfoDetailAdapter(Context context) {
        super(context);
    }

    @Override
    protected int getLayout() {
        return R.layout.layout_detail_item;
    }

    @Override
    protected void bindData(BaseViewHolder holder, RecommendBean.DataBean dataBean) {
        ImageView imgHead = (ImageView) holder.getView(R.id.img_head);
        ImageView imgLevel = (ImageView) holder.getView(R.id.img_level);
        TextView tvUserName = (TextView) holder.getView(R.id.txt_username);
        TextView tvDate = (TextView) holder.getView(R.id.txt_date);
        TextView tvFollow = (TextView) holder.getView(R.id.txt_follow);
        TextView tvDes = (TextView) holder.getView(R.id.txt_des);
        RecyclerView recyclerImgs = (RecyclerView) holder.getView(R.id.recycler_imgs);
        CustomAvaterView customAvater = (CustomAvaterView) holder.getView(R.id.customAvater);
        TextView tv_detail_head = (TextView) holder.getView(R.id.tv_detail_head);

        RecommendBean.DataBean.PostDetailBean postDetail = dataBean.getPostDetail();
        //设置头像的圆角
        int round = SystemUtils.px2Dp(context,50);
        RoundedCorners roundedCorners = new RoundedCorners(round);
        RequestOptions options = RequestOptions.bitmapTransform(roundedCorners);
        Glide.with(context).load(postDetail.getHeadUrl()).apply(options).into(imgHead);
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
        SpannableString spannableString = getSpannableString(content);
        tvDes.setText(spannableString);

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

        List<RecommendBean.DataBean.PostDetailBean.LikeDetailsBean> likeDetails = postDetail.getLikeDetails();
        List<String> headers = new ArrayList<>();
        for(int i=0; i<likeDetails.size(); i++){
            if(i >= MAX_HEADER_NUMBER) break;
            headers.add(likeDetails.get(i).getHeadUrl());
        }
        customAvater.initDatas(headers);
        tv_detail_head.setText(likeDetails.size()+"人参与>");
        customAvater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, LikeDetailActivity.class);
                String postDetailStr = new Gson().toJson(postDetail);
                intent.putExtra("postStr",postDetailStr);
                context.startActivity(intent);
            }
        });

    }

    public SpannableString getSpannableString(String workingText) {
        //使用富文本修改 内容中的文字颜色 134 248 252
        SpannableString mSpannableString = new SpannableString(workingText);
        //第一层#*#
        String regOne = "#[^#]*#";
        Pattern patternOne = Pattern.compile(regOne);
        Matcher matcherOne = patternOne.matcher(workingText);
        while (matcherOne.find()){
            int start = matcherOne.start();
            int end = matcherOne.end();
            mSpannableString.setSpan(new ForegroundColorSpan(Color.rgb(134,248,252)),
                    start,end, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        }

        //第二层@*空格
        String regTwo = "@.+?\\s";
        Pattern patternTwo = Pattern.compile(regTwo);
        Matcher matcherTwo = patternTwo.matcher(workingText);
        while (matcherTwo.find()){
            int start = matcherTwo.start();
            int end = matcherTwo.end();
            mSpannableString.setSpan(new ForegroundColorSpan(Color.rgb(134,248,252)),
                    start,end, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        }
        return mSpannableString;
    }
}
