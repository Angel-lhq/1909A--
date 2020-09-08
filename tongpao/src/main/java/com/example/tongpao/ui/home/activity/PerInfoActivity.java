package com.example.tongpao.ui.home.activity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.text.TextUtils;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.tongpao.R;
import com.example.tongpao.adapter.InfoPerInfoVpAdapter;
import com.example.tongpao.base.BaseActivity;
import com.example.tongpao.bean.PerArticleBean;
import com.example.tongpao.bean.PerCommunityBean;
import com.example.tongpao.bean.PerInfoBean;
import com.example.tongpao.constract.home.IHome;
import com.example.tongpao.constract.home.IHome.IPerInfoPresenter;
import com.example.tongpao.presenter.home.PerInfoPresenter;
import com.example.tongpao.ui.home.perinfofragments.ActivitiesFragment;
import com.example.tongpao.ui.home.perinfofragments.ArticleFragment;
import com.example.tongpao.ui.home.perinfofragments.CommunityFragment;
import com.example.tongpao.ui.home.perinfofragments.DynamicStateFragment;
import com.example.tongpao.ui.home.perinfofragments.InformationFragment;
import com.example.tongpao.util.ImageFilterUtils;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.tabs.TabLayout;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class PerInfoActivity extends BaseActivity<IPerInfoPresenter> implements IHome.IPerInfoView, IHome.ILoadData {

    @BindView(R.id.img_head_bg)
    ImageView imgHeadBg;
    @BindView(R.id.toolBar)
    Toolbar toolbar;
//    @BindView(R.id.img_shared)
//    ImageView imgShared;
    @BindView(R.id.img_head)
    ImageView imgHead;
    @BindView(R.id.img_sex)
    ImageView imgSex;
    @BindView(R.id.appbar)
    AppBarLayout appbar;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
//    @BindView(R.id.txt_title)
//    TextView txtTitle;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.txt_qqnum)
    TextView txtQQNum;
    @BindView(R.id.txt_follow)
    TextView txtFollow;
    @BindView(R.id.tv_call)
    TextView tvCall;
    @BindView(R.id.tv_myContact)
    TextView tvMyContact;
    @BindView(R.id.tv_contactMe)
    TextView tvContactMe;
    @BindView(R.id.tv_expScore)
    TextView tvExpScore;
    @BindView(R.id.collapsing)
    CollapsingToolbarLayout mCollapsingToolBar;
    private List<Fragment> fragments;
    public boolean vpTouch;

    public void setVpTouch(boolean vpTouch) {
        this.vpTouch = vpTouch;
    }

    @Override
    protected IPerInfoPresenter initPresenter() {
        return new PerInfoPresenter();
    }

    @Override
    protected void initData() {
        presenter.getPersonal("home/personal.json");
        presenter.getCommunity("home/personal_msg.json");
        presenter.getArticle("home/personal_article.json");
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void initView() {
        setTitle("ta的主页");
        setSupportActionBar(toolbar);
        mCollapsingToolBar.setTitle("ta的主页");
        mCollapsingToolBar.setExpandedTitleColor(Color.parseColor("#00ffffff"));//设置还没收缩时状态下字体颜色
        mCollapsingToolBar.setCollapsedTitleTextColor(Color.WHITE);//设置收缩后Toolbar上字体的
        fragments = new ArrayList<>();

        InformationFragment informationFragment = InformationFragment.getInstance(0,this);
        fragments.add(informationFragment);

        DynamicStateFragment dynamicStateFragment = new DynamicStateFragment();
        fragments.add(dynamicStateFragment);

        ActivitiesFragment activitiesFragment = new ActivitiesFragment();
        fragments.add(activitiesFragment);

        CommunityFragment communityFragment = CommunityFragment.getInstance(3,this);
        fragments.add(communityFragment);

        ArticleFragment articleFragment = ArticleFragment.getInstance(4,this);
        fragments.add(articleFragment);

        InfoPerInfoVpAdapter infoVpAdapter = new InfoPerInfoVpAdapter(getSupportFragmentManager(), fragments);
        viewPager.setAdapter(infoVpAdapter);
        viewPager.setNestedScrollingEnabled(false);
        tabLayout.setupWithViewPager(viewPager);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.op_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_per_info;
    }

    @Override
    public void setPersonal(PerInfoBean personal) {
        PerInfoBean.DataBean data = personal.getData();
        //设置头像的圆角
        RequestOptions options = RequestOptions.bitmapTransform(new CircleCrop());
        Glide.with(this).load(data.getHeadUrl()).apply(options).into(imgHead);

        Glide.with(this)
                .load(data.getHeadUrl())
                .apply(RequestOptions.bitmapTransform(new GlideBlurformation(this)))
                .into(imgHeadBg);
        if (!TextUtils.isEmpty(data.getNickName())){
            tvTitle.setText(data.getNickName());
        }
        if (!TextUtils.isEmpty(data.getSignature())){
            txtQQNum.setText(data.getSignature());
        }
        tvMyContact.setText(data.getMyContact()+"");
        tvContactMe.setText(data.getContactMe()+"");
        tvExpScore.setText(data.getExpScore()+"");

        ((InformationFragment)fragments.get(0)).setData(personal);
//        EventContant eventContant = new EventContant();
//        eventContant.setPerInfoBean(personal);
//        EventBus.getDefault().post(eventContant);

    }

    @Override
    public void setCommunity(PerCommunityBean community) {
        ((CommunityFragment)fragments.get(3)).setData(community);
    }

    @Override
    public void setArticle(PerArticleBean article) {
        ((ArticleFragment)fragments.get(4)).setData(article);
    }

    @Override
    public void loadData(int type) {
        switch (type){
            case 0:
                presenter.getPersonal("home/personal.json");
                break;
            case 3:
                presenter.getCommunity("home/personal_msg.json");
                break;
            case 4:
                presenter.getArticle("home/personal_article.json");
                break;
        }
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
