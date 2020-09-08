package com.example.tongpao.ui.home.homefragments;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.tongpao.R;
import com.example.tongpao.adapter.InfoArticleAdapter;
import com.example.tongpao.base.BaseFragment;
import com.example.tongpao.bean.ArticleBean;
import com.example.tongpao.constract.home.IHome;
import com.example.tongpao.presenter.home.ArticlePresenter;
import com.example.tongpao.ui.home.activity.HanFuAboutActivity;
import com.example.tongpao.ui.home.activity.HistoryActivity;
import com.example.tongpao.ui.home.activity.SingleGoodsActivity;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;
import com.youth.banner.indicator.CircleIndicator;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class ArticleFragment extends BaseFragment<IHome.IArticlePresenter> implements IHome.IArticleView, View.OnClickListener {
    @BindView(R.id.banner_articley)
    Banner banner;
    @BindView(R.id.tv_about)
    TextView tvAbout;
    @BindView(R.id.tv_single)
    TextView tvSingle;
    @BindView(R.id.tv_history)
    TextView tvHistroy;
    @BindView(R.id.tv_big_thing)
    TextView tvBigThing;
    @BindView(R.id.rcl_article)
    RecyclerView rclArticle;
    private InfoArticleAdapter infoArticleAdapter;

    @Override
    protected IHome.IArticlePresenter initPresenter() {
        return new ArticlePresenter();
    }

    @Override
    protected void initData() {
        presneter.getArticle("home/article.json");
    }

    @Override
    protected void initView(View view) {
        rclArticle.setLayoutManager(new LinearLayoutManager(context));
        infoArticleAdapter = new InfoArticleAdapter(context);
        rclArticle.setAdapter(infoArticleAdapter);
        tvAbout.setOnClickListener(this);
        tvSingle.setOnClickListener(this);
        tvHistroy.setOnClickListener(this);
        tvBigThing.setOnClickListener(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_artile;
    }

    @Override
    public void setArticle(ArticleBean article) {
        List<ArticleBean.DataBean.ArticlesBean> articles = article.getData().getArticles();
        List<String> imgs = new ArrayList<>();
        List<String> titles = new ArrayList<>();
        for (int i = 0; i < articles.size(); i++) {
            ArticleBean.DataBean.ArticlesBean articlesBean = articles.get(i);
            imgs.add(articlesBean.getCover());
            titles.add(articlesBean.getContent()+"/n作者："+articlesBean.getNickName()+"   "+articlesBean.getCreateTime());
        }
        banner.setAdapter(new BannerImageAdapter<String>(imgs) {
            @Override
            public void onBindView(BannerImageHolder holder, String data, int position, int size) {
                //图片加载自己实现
                Glide.with(holder.itemView)
                        .load(data)
                        .apply(RequestOptions.bitmapTransform(new RoundedCorners(30)))
                        .into(holder.imageView);
            }
        }).addBannerLifecycleObserver(this)//添加生命周期观察者
                .setIndicator(new CircleIndicator(context))
                .setBannerRound(20)
                .setBannerGalleryEffect(5,5,10);
        infoArticleAdapter.setData(articles);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_about:
                startActivity(new Intent(context, HanFuAboutActivity.class));
                break;
            case R.id.tv_single:
                startActivity(new Intent(context, SingleGoodsActivity.class));
                break;
            case R.id.tv_history:
                startActivity(new Intent(context, HistoryActivity.class));
                break;
            case R.id.tv_big_thing:
                break;
        }
    }
}
