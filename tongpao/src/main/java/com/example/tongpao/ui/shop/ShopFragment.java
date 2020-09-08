package com.example.tongpao.ui.shop;

import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.tongpao.R;
import com.example.tongpao.base.BaseFragment;
import com.example.tongpao.base.IBasePresenter;

import butterknife.BindView;

public class ShopFragment extends BaseFragment {
    @BindView(R.id.web_shop)
    WebView webShop;

    @Override
    protected IBasePresenter initPresenter() {
        return null;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View view) {
        webShop.getSettings().setSupportZoom(true);
        webShop.getSettings().setBuiltInZoomControls(true);

        webShop.getSettings().setJavaScriptEnabled(true);
        webShop.setWebViewClient(new WebViewClient());
        webShop.loadUrl("http://tongpao.whfpsoft.com:8095/");
//        FragmentManager fragmentManager = getFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.replace(R.id.web_shop,new ArticleFragment());
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_shop;
    }
}