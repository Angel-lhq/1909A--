package com.example.tongpao.ui.home.activity;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tongpao.R;
import com.example.tongpao.adapter.InfoAboutAdapter;
import com.example.tongpao.base.BaseActivity;
import com.example.tongpao.base.BaseAdapter;
import com.example.tongpao.bean.AboutHanFuBean;
import com.example.tongpao.constract.home.IHome;
import com.example.tongpao.presenter.home.AboutHanFuPresenter;
import com.example.tongpao.util.LogUtil;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;

import butterknife.BindView;

public class HanFuAboutActivity extends BaseActivity<IHome.IAboutHanFuPresenter> implements IHome.IAboutHanFuView, View.OnClickListener {
    @BindView(R.id.img_back)
    ImageView imgBack;
    @BindView(R.id.img_share)
    ImageView imgShare;
    @BindView(R.id.rcl_about)
    RecyclerView rclAbout;
    private InfoAboutAdapter infoAboutAdapter;

    @Override
    protected IHome.IAboutHanFuPresenter initPresenter() {
        return new AboutHanFuPresenter();
    }

    @Override
    protected void initData() {
        presenter.getAboutHanFu("home/knowhanfu.json");
    }

    @Override
    protected void initView() {
        rclAbout.setLayoutManager(new LinearLayoutManager(this));
        infoAboutAdapter = new InfoAboutAdapter(this);
        rclAbout.setAdapter(infoAboutAdapter);
        infoAboutAdapter.setiOnClick(new BaseAdapter.IOnClick() {
            @Override
            public void onClick(int position, Object o, View view) {
                Intent intent = new Intent(HanFuAboutActivity.this, AboutDetailActivity.class);
                int articleId = ((AboutHanFuBean.DataBean) o).getArticleId();
                intent.putExtra("id",articleId);
                startActivity(intent);
            }
        });
        imgBack.setOnClickListener(this);
        imgShare.setOnClickListener(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_han_fu_about;
    }

    @Override
    public void setAboutHanFu(AboutHanFuBean aboutHanFuBean) {
        infoAboutAdapter.setData(aboutHanFuBean.getData());
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
            Toast.makeText(HanFuAboutActivity.this,"成功                                        了",Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享失败的回调
         * @param platform 平台类型
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(HanFuAboutActivity.this,"失                                            败"+t.getMessage(),Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享取消的回调
         * @param platform 平台类型
         */
        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(HanFuAboutActivity.this,"取消                                          了",Toast.LENGTH_LONG).show();

        }
    };

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.img_back:
                finish();
                break;
            case R.id.img_share:
                LogUtil.logi("share");
                UMImage image =  new UMImage(HanFuAboutActivity.this, R.drawable.ic_like);
                UMImage thumb =  new UMImage(HanFuAboutActivity.this, R.drawable.jz_add_volume);
                image.setThumb(thumb);
                new ShareAction(HanFuAboutActivity.this)
                        .withText("hello")
                        .withMedia(image)
                        .setDisplayList(SHARE_MEDIA.SINA,SHARE_MEDIA.QQ,SHARE_MEDIA.WEIXIN)
                        .setCallback(shareListener).open();
                break;
        }
    }
}
