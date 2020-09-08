package com.example.tongpao.ui.myOwn.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
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
import com.example.tongpao.bean.UserLoginBean;
import com.example.tongpao.constract.home.IHome;
import com.example.tongpao.constract.home.IHome.IPerInfoPresenter;
import com.example.tongpao.presenter.home.PerInfoPresenter;
import com.example.tongpao.ui.myOwn.MyOwnFragment;
import com.example.tongpao.ui.myOwn.perinfofragments.ActivitiesFragment;
import com.example.tongpao.ui.myOwn.perinfofragments.ArticleFragment;
import com.example.tongpao.ui.myOwn.perinfofragments.CommunityFragment;
import com.example.tongpao.ui.myOwn.perinfofragments.DynamicStateFragment;
import com.example.tongpao.ui.myOwn.perinfofragments.InformationFragment;
import com.example.tongpao.util.ImageFilterUtils;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class PerInfoActivity extends BaseActivity<IPerInfoPresenter> implements IHome.IPerInfoView, IHome.ILoadData, View.OnClickListener {

    @BindView(R.id.img_head_bg)
    ImageView imgHeadBg;
    @BindView(R.id.toolBar)
    Toolbar toolbar;
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
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.txt_qqnum)
    TextView txtQQNum;
    @BindView(R.id.txt_follow)
    TextView txtFollow;
    @BindView(R.id.tv_call)
    TextView tvCall;
    @BindView(R.id.tv_edit)
    TextView tvEdit;
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
    private SharedPreferences login;

    public void setVpTouch(boolean vpTouch) {
        this.vpTouch = vpTouch;
    }

    @Override
    protected IPerInfoPresenter initPresenter() {
        return new PerInfoPresenter();
    }

    @Override
    protected void initData() {
//        presenter.getPersonal("home/personal.json");
        presenter.getCommunity("home/personal_msg.json");
        presenter.getArticle("home/personal_article.json");
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void initView() {
        tvEdit.setVisibility(View.VISIBLE);
        tvCall.setVisibility(View.GONE);
        txtFollow.setVisibility(View.GONE);
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

        login = getSharedPreferences("login", 0);

        tvEdit.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        String dataStr = login.getString("data", "");
        if (!TextUtils.isEmpty(dataStr)){
            UserLoginBean userLoginBean = new Gson().fromJson(dataStr, UserLoginBean.class);
            UserLoginBean.DataBean dataBean = userLoginBean.getData();
            if (!TextUtils.isEmpty(dataBean.getNickname())){
                tvTitle.setText(dataBean.getNickname());
            }else if (!TextUtils.isEmpty(dataBean.getUsername())){
                tvTitle.setText(dataBean.getUsername());
            }
            if (dataBean.getSex() == 0){
                imgSex.setImageResource(R.mipmap.male);
            }else {
                imgSex.setImageResource(R.mipmap.female);
            }
            if (!TextUtils.isEmpty(dataBean.getAvater())){
                Glide.with(this).load(dataBean.getAvater())
                        .apply(RequestOptions.bitmapTransform(new MyOwnFragment.GlideBlurformation(this)))
                        .into(imgHeadBg);
                //设置头像的圆角
                RequestOptions options = RequestOptions.bitmapTransform(new CircleCrop());
                Glide.with(this).load(dataBean.getAvater()).apply(options).into(imgHead);
            }
            tvMyContact.setText(0+"");
            tvContactMe.setText(2+"");
            tvExpScore.setText(10+"");
        }
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
//                presenter.getPersonal("home/personal.json");
                break;
            case 3:
                presenter.getCommunity("home/personal_msg.json");
                break;
            case 4:
                presenter.getArticle("home/personal_article.json");
                break;
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_edit:
                startActivity(new Intent(this,EditPerInfoActivity.class));
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
