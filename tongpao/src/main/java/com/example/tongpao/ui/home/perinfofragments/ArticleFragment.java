package com.example.tongpao.ui.home.perinfofragments;

import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tongpao.R;
import com.example.tongpao.adapter.InfoPerArticleAdapter;
import com.example.tongpao.base.BaseFragment;
import com.example.tongpao.base.IBasePresenter;
import com.example.tongpao.bean.PerArticleBean;
import com.example.tongpao.constract.home.IHome;

import butterknife.BindView;

public class ArticleFragment extends BaseFragment {
    @BindView(R.id.rcl_article)
    RecyclerView rclArticle;
    private int TYPE;
    private PerArticleBean data;
    public IHome.ILoadData iLoadData;
    private InfoPerArticleAdapter infoPerArticleAdapter;

    public static ArticleFragment getInstance(int type, IHome.ILoadData iLoadData){
        ArticleFragment articleFragment = new ArticleFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("type",type);
        articleFragment.iLoadData = iLoadData;
        articleFragment.setArguments(bundle);
        return articleFragment;
    }
    @Override
    protected IBasePresenter initPresenter() {
        return null;
    }
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser && rclArticle != null){
            if (data != null){
                if (iLoadData != null){
                    iLoadData.loadData(TYPE);
                }
            }
        }
    }
    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View view) {
        rclArticle.setLayoutManager(new LinearLayoutManager(context));
        infoPerArticleAdapter = new InfoPerArticleAdapter(context);
        rclArticle.setAdapter(infoPerArticleAdapter);
        Bundle bundle = getArguments();
        if(bundle != null && bundle.containsKey("type")){
            TYPE = bundle.getInt("type");
        }
        if(iLoadData != null){
            iLoadData.loadData(TYPE);
        }
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_article;
    }
    public void setData(PerArticleBean data){
        this.data = data;
        if (rclArticle == null) return;
        infoPerArticleAdapter.setData(data.getData().getArticles());
    }
}
