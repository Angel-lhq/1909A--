package com.example.tongpao.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.tongpao.R;
import com.example.tongpao.base.BaseAdapter;
import com.example.tongpao.bean.VideoBean;
import com.example.tongpao.myview.PlayVideoView;
import com.example.tongpao.ui.home.activity.VideoDetailActivity;
import com.example.tongpao.util.LogUtil;
import com.example.tongpao.util.UserUtil;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;

import cn.jzvd.Jzvd;
import cn.jzvd.JzvdStd;

public class InfoVideoPlayAdapter extends BaseAdapter<VideoBean.DataBean.ListBean> {

    private PlayVideoView video;

    public InfoVideoPlayAdapter(Context context) {
        super(context);
    }

    @Override
    protected int getLayout() {
        return R.layout.layout_video_play_item;
    }

    @Override
    protected void bindData(BaseViewHolder holder, VideoBean.DataBean.ListBean dataBean) {
        video = (PlayVideoView) holder.getView(R.id.video);
        TextView tvLike = (TextView) holder.getView(R.id.tv_like);
        ImageView imgBack = (ImageView) holder.getView(R.id.img_back);
        TextView tvComment = (TextView) holder.getView(R.id.tv_comment);
        ImageView imgHead = (ImageView) holder.getView(R.id.img_head);
        ImageView imgShare = (ImageView) holder.getView(R.id.img_share);
        ImageView imgLevel = (ImageView) holder.getView(R.id.img_level);
        TextView tvName = (TextView) holder.getView(R.id.tv_name);
        TextView tvFollow = (TextView) holder.getView(R.id.tv_follow);
        TextView tvContent = (TextView) holder.getView(R.id.tv_content);
        if (!TextUtils.isEmpty(dataBean.getVideoPath()) && !TextUtils.isEmpty(dataBean.getCover())){
            video.setUp(dataBean.getVideoPath(),dataBean.getTitle());
            Glide.with(context).load(dataBean.getCover()).into(video.thumbImageView);
        }
        video.titleTextView.setPadding(80,video.titleTextView.getPaddingTop(),video.titleTextView.getPaddingRight(),video.titleTextView.getPaddingBottom());
        video.setData(dataBean);
        if (!TextUtils.isEmpty(dataBean.getHeadUrl())){
            Glide.with(context).load(dataBean.getHeadUrl()).apply(RequestOptions.circleCropTransform()).into(imgHead);
        }
        if (!TextUtils.isEmpty(dataBean.getNickName())){
            tvName.setText(dataBean.getNickName());
        }
        tvLike.setText(dataBean.getLikeNumber()+"");
        tvComment.setText(dataBean.getCommentNumber()+"");
        imgLevel.setImageResource(UserUtil.getResByLevel(dataBean.getLevel()));
        if (!TextUtils.isEmpty(dataBean.getContent())){
            tvContent.setText(dataBean.getContent());
        }
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (video.screen == video.SCREEN_FULLSCREEN){
                    Jzvd.backPress();
                }else {
                    ((VideoDetailActivity)context).finish();
                    JzvdStd.releaseAllVideos();
                }
            }
        });
        imgShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LogUtil.logi("share");
                UMImage image =  new UMImage(context, dataBean.getCover());
                UMImage thumb =  new UMImage(context, R.drawable.jz_add_volume);
                image.setThumb(thumb);
                new ShareAction((VideoDetailActivity)context)
                        .withText("hello")
                        .withMedia(image)
                        .setDisplayList(SHARE_MEDIA.SINA,SHARE_MEDIA.QQ,SHARE_MEDIA.WEIXIN)
                        .setCallback(shareListener).open();
            }
        });
    }


    private UMShareListener shareListener = new UMShareListener() {
        /**
         * @descrption 分享开始的回调
         * @param platform 平台类型
         */
        @Override
        public void onStart(SHARE_MEDIA platform) {

        }

        /**
         * @descrption 分享成功的回调
         * @param platform 平台类型
         */
        @Override
        public void onResult(SHARE_MEDIA platform) {
            Toast.makeText(context,"成功                                        了",Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享失败的回调
         * @param platform 平台类型
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(context,"失                                            败"+t.getMessage(),Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享取消的回调
         * @param platform 平台类型
         */
        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(context,"取消                                          了",Toast.LENGTH_LONG).show();

        }
    };
    public void playVideo(){
        if(video != null){
            video.startButton.performClick();
        }
    }
}
