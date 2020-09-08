package com.example.tongpao.ui.home.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tongpao.R;
import com.example.tongpao.base.BaseActivity;
import com.example.tongpao.bean.HistoryDetailBean;
import com.example.tongpao.constract.home.IHome;
import com.example.tongpao.presenter.home.HistoryDetailPresenter;
import com.example.tongpao.util.TextUtil;

import butterknife.BindView;

public class HistoryDetailActivity extends BaseActivity<IHome.IHistoryDetailPresenter> implements IHome.IHistoryDetailView {
    @BindView(R.id.img_back)
    ImageView imgBack;
    @BindView(R.id.img_share)
    ImageView imgShare;
    @BindView(R.id.tv_history_title)
    TextView tvHistoryTitle;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.web_history)
    WebView webHistory;
    @Override
    protected IHome.IHistoryDetailPresenter initPresenter() {
        return new HistoryDetailPresenter();
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        if (intent.hasExtra("id")){
            int id = intent.getIntExtra("id", 0);
            presenter.getHistoryDetail("home/history_"+id+".json");
        }
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_history_detail;
    }

    @Override
    public void setHistoryDetail(HistoryDetailBean historyDetailBean) {
        TextUtil.setText(tvHistoryTitle,historyDetailBean.getData().getTitle());
        TextUtil.setText(tvTime,historyDetailBean.getData().getCreateTime());
        if (!TextUtils.isEmpty(historyDetailBean.getData().getContent())){
            webHistory.loadData(historyDetailBean.getData().getContent(),"text/html","utf-8");
        }
    }
}
