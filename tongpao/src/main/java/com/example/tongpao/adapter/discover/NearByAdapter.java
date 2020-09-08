package com.example.tongpao.adapter.discover;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.tongpao.R;
import com.example.tongpao.base.BaseAdapter;
import com.example.tongpao.bean.discover.NearByBean;

import butterknife.BindView;

public class NearByAdapter extends BaseAdapter {
    @BindView(R.id.img_near_head)
    ImageView imgNearHead;
    @BindView(R.id.tv_near_nickName)
    TextView tvNearNickName;
    @BindView(R.id.tv_near_sex)
    TextView tvNearSex;
    @BindView(R.id.tv_near_m)
    TextView tvNearM;

    public NearByAdapter(Context context) {
        super(context);
    }


    @Override
    protected int getLayout() {
        return R.layout.adapter_near_by;
    }

    @Override
    protected void bindData(BaseViewHolder baseViewHolder, Object data) {
        NearByBean.DataBean.ListBean listBean = (NearByBean.DataBean.ListBean) data;
        ImageView imgNearHead = (ImageView) baseViewHolder.getView(R.id.img_near_head);
        TextView tvNearNickName = (TextView) baseViewHolder.getView(R.id.tv_near_nickName);
        TextView tvNearSex = (TextView) baseViewHolder.getView(R.id.tv_near_sex);
        TextView tvNearM = (TextView) baseViewHolder.getView(R.id.tv_near_m);

        Glide.with(context).load(listBean.getHeadUrl()).apply(RequestOptions.circleCropTransform()).into(imgNearHead);

        tvNearNickName.setText(listBean.getNickName());

        tvNearSex.setText(listBean.getAge()+"");

        tvNearM.setText(listBean.getProvince());
    }


}
