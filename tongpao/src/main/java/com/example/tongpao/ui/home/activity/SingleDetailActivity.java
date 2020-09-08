package com.example.tongpao.ui.home.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tongpao.R;
import com.example.tongpao.base.BaseActivity;
import com.example.tongpao.bean.SingleDetailBean;
import com.example.tongpao.constract.home.IHome;
import com.example.tongpao.presenter.home.SingleDetailPresenter;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;

import butterknife.BindView;

public class SingleDetailActivity extends BaseActivity<IHome.ISingleDetailPresenter> implements IHome.ISingleDetailView, View.OnClickListener {
    @BindView(R.id.img_back)
    ImageView imgBack;
    @BindView(R.id.img_share)
    ImageView imgShare;
    @BindView(R.id.tv_single_title)
    TextView tvSingleTitle;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.web_single)
    WebView webSingle;

    @Override
    protected IHome.ISingleDetailPresenter initPresenter() {
        return new SingleDetailPresenter();
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        if (intent.hasExtra("id")){
            int id = intent.getIntExtra("id", 0);
            presenter.getSingleDetail("home/traditional_"+id+".json");
        }
    }

    @Override
    protected void initView() {
        imgBack.setOnClickListener(this);
        imgShare.setOnClickListener(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_single_detail;
    }

    @Override
    public void setSingleDetail(SingleDetailBean singleDetail) {
        SingleDetailBean.DataBean data = singleDetail.getData();
        if (!TextUtils.isEmpty(data.getTitle())){
            tvSingleTitle.setText(data.getTitle());
        }
        if (!TextUtils.isEmpty(data.getCreateTime())){
            tvTime.setText(data.getCreateTime());
        }
        if (!TextUtils.isEmpty(data.getContent())){
            webSingle.loadData(data.getContent(),"text/html","utf-8");
            //webAbout.loadDataWithBaseURL(null,data.getContent(),"text/html","utf-8",null);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.img_back:
                finish();
                break;
            case R.id.img_share:
                UMImage image =  new UMImage(SingleDetailActivity.this, R.drawable.ic_like);
                UMImage thumb =  new UMImage(SingleDetailActivity.this, R.drawable.jz_add_volume);
                image.setThumb(thumb);
                new ShareAction(SingleDetailActivity.this)
                        .withText("hello")
                        .withMedia(image)
                        .setDisplayList(SHARE_MEDIA.SINA,SHARE_MEDIA.QQ,SHARE_MEDIA.WEIXIN)
                        .setCallback(shareListener).open();
                break;
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
            Toast.makeText(SingleDetailActivity.this,"成功                                        了",Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享失败的回调
         * @param platform 平台类型
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(SingleDetailActivity.this,"失                                            败"+t.getMessage(),Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享取消的回调
         * @param platform 平台类型
         */
        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(SingleDetailActivity.this,"取消                                          了",Toast.LENGTH_LONG).show();

        }
    };
}
