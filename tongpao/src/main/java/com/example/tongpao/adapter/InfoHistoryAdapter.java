package com.example.tongpao.adapter;

import android.content.Context;
import android.widget.TextView;

import com.example.tongpao.R;
import com.example.tongpao.base.BaseAdapter;
import com.example.tongpao.bean.HistoryBean;
import com.example.tongpao.util.TextUtil;

public class InfoHistoryAdapter extends BaseAdapter<HistoryBean.DataBean> {
    public InfoHistoryAdapter(Context context) {
        super(context);
    }

    @Override
    protected int getLayout() {
        return R.layout.layout_history_item;
    }

    @Override
    protected void bindData(BaseViewHolder holder, HistoryBean.DataBean dataBean) {
        TextView tvTitle = (TextView) holder.getView(R.id.tv_title);
        TextView tvContent = (TextView) holder.getView(R.id.tv_content);
        TextUtil.setText(tvTitle,dataBean.getTitle());
        TextUtil.setText(tvContent,"    "+dataBean.getContentDescribe());
    }
}
