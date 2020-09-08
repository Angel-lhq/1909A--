package com.example.tongpao.ui.home.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.widget.NestedScrollView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.request.RequestOptions;
import com.example.tongpao.R;
import com.example.tongpao.base.BaseActivity;
import com.example.tongpao.base.IBasePresenter;
import com.example.tongpao.bean.PerActiviesBean;
import com.example.tongpao.util.ImageFilterUtils;
import com.example.tongpao.util.LogUtil;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.security.MessageDigest;
import java.util.List;

import butterknife.BindView;

public class ActivitiesDetailActivity extends BaseActivity {
    @BindView(R.id.img_head_bg)
    ImageView imgHeadBg;
    @BindView(R.id.tv_overornot)
    TextView tvOverOrNot;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.linear_community)
    LinearLayout linearCommunity;
    @BindView(R.id.tv_activity)
    TextView tvApply;
    @BindView(R.id.tv_last)
    TextView tvLast;
    @BindView(R.id.txt_follow)
    TextView tvFollow;
    @BindView(R.id.tv_activity_time)
    TextView tvActivityTime;
    @BindView(R.id.tv_apply_end_time)
    TextView tvApplyEndTime;
    @BindView(R.id.tv_des)
    TextView tvLocation;
    @BindView(R.id.tv_apply_count)
    TextView tvApplyCount;
    @BindView(R.id.web_detail)
    WebView webDetail;
    @BindView(R.id.scroll)
    NestedScrollView scroll;
    @BindView(R.id.img_shared)
    ImageView imgShared;
//    private boolean canScroll;

    @Override
    protected IBasePresenter initPresenter() {
        return null;
    }

    @Override
    protected void initData() {

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void initView() {
        Intent intent = getIntent();
        PerActiviesBean.DataBean.ActivitysBean data = (PerActiviesBean.DataBean.ActivitysBean) intent.getSerializableExtra("data");
        if (data != null){
            LogUtil.logi("成功");
            if (!TextUtils.isEmpty(data.getCover())){
                Glide.with(this)
                        .load(data.getCover())
                        .apply(RequestOptions.bitmapTransform(new GlideBlurformation(this)))
                        .into(imgHeadBg);
            }
            if (!TextUtils.isEmpty(data.getTitle())){
                tvTitle.setText(data.getTitle());
            }
            linearCommunity.removeAllViews();
            List<PerActiviesBean.DataBean.ActivitysBean.ColorTagsBean> colorTags = data.getColorTags();
            for (PerActiviesBean.DataBean.ActivitysBean.ColorTagsBean item:colorTags) {
                TextView tv_tag = (TextView) LayoutInflater.from(this).inflate(R.layout.layout_text_tag, null);
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
            String tvApplyStr = tvApply.getText().toString();
            tvApply.setText(tvApplyStr+data.getApplyUserCount());
            String tvLastStr = tvLast.getText().toString();
            tvLast.setText(tvLastStr+(data.getMaxUserNumber()-data.getApplyUserCount()));
            String activityTime = tvActivityTime.getText().toString();
            if (!TextUtils.isEmpty(data.getStartTime()) && !TextUtils.isEmpty(data.getEndTime())){
                tvActivityTime.setText(activityTime + data.getStartTime() + "-" + data.getEndTime());
            }
            String applyCutOffTime = tvApplyEndTime.getText().toString();
            if (!TextUtils.isEmpty(data.getApplyCutOffTime())){
                tvApplyEndTime.setText(applyCutOffTime + data.getApplyCutOffTime());
            }
            String location = tvLocation.getText().toString();
            if (!TextUtils.isEmpty(data.getLocation())){
                tvLocation.setText(location + data.getLocation());
            }
            String applyCount = tvApplyCount.getText().toString();
            tvApplyCount.setText(applyCount + data.getApplyUserCount());
            if (!TextUtils.isEmpty(data.getContent())){
                webDetail.loadData(data.
                        getContent(),"text/html","utf-8");
                webDetail.loadDataWithBaseURL(null,data.getContent(),"text/html","utf-8",null);
            }
            imgShared.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    LogUtil.logi("share");
                    new ShareAction(ActivitiesDetailActivity.this)
                            .withText("hello")
                            .setDisplayList(SHARE_MEDIA.SINA,SHARE_MEDIA.QQ,SHARE_MEDIA.WEIXIN)
                            .setCallback(shareListener).open();
                }
            });
        }
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
            Toast.makeText(ActivitiesDetailActivity.this,"成功                                        了",Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享失败的回调
         * @param platform 平台类型
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(ActivitiesDetailActivity.this,"失                                            败"+t.getMessage(),Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享取消的回调
         * @param platform 平台类型
         */
        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(ActivitiesDetailActivity.this,"取消                                          了",Toast.LENGTH_LONG).show();

        }
    };


    @Override
    protected int getLayout() {
        return R.layout.activity_activities_detail;
    }
    class GlideBlurformation extends BitmapTransformation {
        private Context context;
        public GlideBlurformation(Context context) {
            this.context = context;
        }
        @Override
        protected Bitmap transform(@NonNull BitmapPool pool, @NonNull Bitmap toTransform, int outWidth, int outHeight) {
            return ImageFilterUtils.instance().blurBitmap(context, toTransform, 20,outWidth,outHeight);
        }

        @Override
        public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {

        }
    }
}
