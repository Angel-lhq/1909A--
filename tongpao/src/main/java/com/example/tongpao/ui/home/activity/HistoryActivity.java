package com.example.tongpao.ui.home.activity;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tongpao.R;
import com.example.tongpao.adapter.InfoHistoryAdapter;
import com.example.tongpao.base.BaseActivity;
import com.example.tongpao.base.BaseAdapter;
import com.example.tongpao.bean.HistoryBean;
import com.example.tongpao.common.RVItemDecoration;
import com.example.tongpao.constract.home.IHome;
import com.example.tongpao.presenter.home.HistoryPresenter;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;

import butterknife.BindView;

public class HistoryActivity extends BaseActivity<IHome.IHistoryPresenter> implements IHome.IHistoryView, View.OnClickListener {
    @BindView(R.id.img_back)
    ImageView imgBack;
    @BindView(R.id.img_share)
    ImageView imgShare;
    @BindView(R.id.rcl_history)
    RecyclerView rclHistory;
    private InfoHistoryAdapter infoHistoryAdapter;

    @Override
    protected IHome.IHistoryPresenter initPresenter() {
        return new HistoryPresenter();
    }

    @Override
    protected void initData() {
        presenter.getHistory("home/evolution_history.json");
    }

    @Override
    protected void initView() {
        imgBack.setOnClickListener(this);
        imgShare.setOnClickListener(this);
        rclHistory.setLayoutManager(new LinearLayoutManager(this));
        infoHistoryAdapter = new InfoHistoryAdapter(this);
        rclHistory.setAdapter(infoHistoryAdapter);
        rclHistory.addItemDecoration(new RVItemDecoration(getApplicationContext()));
        infoHistoryAdapter.setiOnClick(new BaseAdapter.IOnClick() {
            @Override
            public void onClick(int position, Object o, View view) {
                int hanfuHistoryID = ((HistoryBean.DataBean) o).getHanfuHistoryID();
                Intent intent = new Intent(HistoryActivity.this, HistoryDetailActivity.class);
                intent.putExtra("id",hanfuHistoryID);
                startActivity(intent);
            }
        });
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_history;
    }

    @Override
    public void setHistory(HistoryBean histroyBean) {
        infoHistoryAdapter.setData(histroyBean.getData());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.img_back:
                finish();
                break;
            case R.id.img_share:
                UMImage image =  new UMImage(HistoryActivity.this, R.drawable.ic_like);
                UMImage thumb =  new UMImage(HistoryActivity.this, R.drawable.jz_add_volume);
                image.setThumb(thumb);
                new ShareAction(HistoryActivity.this)
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
            Toast.makeText(HistoryActivity.this,"成功                                        了",Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享失败的回调
         * @param platform 平台类型
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(HistoryActivity.this,"失                                            败"+t.getMessage(),Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享取消的回调
         * @param platform 平台类型
         */
        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(HistoryActivity.this,"取消                                          了",Toast.LENGTH_LONG).show();

        }
    };
}
