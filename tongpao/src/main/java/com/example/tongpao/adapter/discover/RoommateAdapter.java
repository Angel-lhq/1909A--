package com.example.tongpao.adapter.discover;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.tongpao.R;
import com.example.tongpao.base.BaseAdapter;
import com.example.tongpao.bean.discover.RoommateBean;

public class RoommateAdapter extends BaseAdapter {


    public RoommateAdapter(Context context) {
        super(context);
    }

    @Override
    protected int getLayout() {
        return R.layout.adapter_roommate;
    }

    @Override
    protected void bindData(BaseViewHolder baseViewHolder, Object data) {
        RoommateBean.DataBean dataBean = (RoommateBean.DataBean) data;
        Log.d(TAG, "bindData: "+dataBean.getCity());
        ImageView imgHeaderRoo = (ImageView) baseViewHolder.getView(R.id.img_header_roo);
        TextView tvTitleRoo = (TextView) baseViewHolder.getView(R.id.tv_title_roo);
        TextView tvNickNameRoo = (TextView) baseViewHolder.getView(R.id.tv_nickName_roo);
        TextView tvAgeRoo = (TextView) baseViewHolder.getView(R.id.tv_age_roo);
        TextView tvLocationRoo = (TextView) baseViewHolder.getView(R.id.tv_location_roo);
        //头像
        Glide.with(context).load(dataBean.getHeadUrl()).apply(RequestOptions.circleCropTransform()).into(imgHeaderRoo);
        //标题
        tvTitleRoo.setText(dataBean.getSocialTitle());
        //昵称
        tvNickNameRoo.setText(dataBean.getNickName());
        //年龄
        tvAgeRoo.setText(dataBean.getAge() + "");
        //地点
        tvLocationRoo.setText(dataBean.getCity());
    }

    @Override
    public void clearData() {
        data.clear();
        notifyDataSetChanged();
    }

    private static final String TAG = "RoommateAdapter";


}
