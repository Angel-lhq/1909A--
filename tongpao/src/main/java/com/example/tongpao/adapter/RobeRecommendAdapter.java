package com.example.tongpao.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.tongpao.R;
import com.example.tongpao.base.BaseAdapter;
import com.example.tongpao.bean.RobeBean;

public class RobeRecommendAdapter extends BaseAdapter {

    public RobeRecommendAdapter(Context context) {
        super(context);
    }

    @Override
    protected int getLayout() {
        return R.layout.roberecommend_item;
    }

    @Override
    protected void bindData(BaseViewHolder baseVirwHolder, Object t_data) {
        TextView roberecommend_tv_name = (TextView) baseVirwHolder.getView(R.id.roberecommend_tv_name);
        TextView recommend_tv_map = (TextView) baseVirwHolder.getView(R.id.recommend_tv_map);
        ImageView roberecommend_iv_header = (ImageView) baseVirwHolder.getView(R.id.roberecommend_iv_header);
        TextView roberecommend_tv_title = (TextView) baseVirwHolder.getView(R.id.roberecommend_tv_title);
        RobeBean.DataBean dataBean = (RobeBean.DataBean) t_data;
        roberecommend_tv_name.setText(dataBean.getNickName());
        recommend_tv_map.setText(dataBean.getCity());
        RequestOptions requestOptions = RequestOptions.circleCropTransform();
        Glide.with(context).load(dataBean.getHeadUrl()).apply(requestOptions).into(roberecommend_iv_header);
        roberecommend_tv_title.setText(dataBean.getSocialTitle());
    }
}
