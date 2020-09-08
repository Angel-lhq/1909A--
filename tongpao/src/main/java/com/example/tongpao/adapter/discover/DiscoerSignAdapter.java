package com.example.tongpao.adapter.discover;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.tongpao.R;
import com.example.tongpao.base.BaseAdapter;
import com.example.tongpao.bean.discover.DiscoverRankSignBean;
import com.example.tongpao.util.LevelUtils;

public class DiscoerSignAdapter extends BaseAdapter {
    public DiscoerSignAdapter(Context context) {
        super(context);
    }

    @Override
    protected int getLayout() {
        return R.layout.adapter_discover_ranklevel;
    }

    @Override
    protected void bindData(BaseViewHolder baseViewHolder, Object data) {
        DiscoverRankSignBean.DataBean.SignTopBean.ListBean bean = (DiscoverRankSignBean.DataBean.SignTopBean.ListBean) data;
        ImageView img_head = (ImageView) baseViewHolder.getView(R.id.img_level_head);
        TextView tv_name = (TextView) baseViewHolder.getView(R.id.tv_level_name);
        TextView tv_location = (TextView) baseViewHolder.getView(R.id.tv_level_location);
        TextView tv_score = (TextView) baseViewHolder.getView(R.id.tv_level_score);
        ImageView img_level = (ImageView) baseViewHolder.getView(R.id.img_level);
        TextView tv_pos = (TextView) baseViewHolder.getView(R.id.tv_pos);
        LevelUtils.setLevelImage(bean.getLevel(),img_level);
        Glide.with(context).load(bean.getHeadUrl()).apply(new RequestOptions().circleCrop()).into(img_head);
        tv_name.setText(bean.getNickName());
        tv_pos.setText(baseViewHolder.getLayoutPosition()+"");
        tv_location.setText(bean.getProvince());
        tv_score.setText(bean.getExpScore()+"经验");
    }
}
