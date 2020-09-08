package com.example.tongpao.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.TextView;

import com.example.tongpao.R;
import com.example.tongpao.base.BaseAdapter;

public class InfoRclMyAdapter extends BaseAdapter<String> {
    public InfoRclMyAdapter(Context context) {
        super(context);
    }

    @Override
    protected int getLayout() {
        return R.layout.layout_rcl_my;
    }

    @Override
    protected void bindData(BaseViewHolder holder, String dataBean) {
        TextView tvMy = (TextView) holder.getView(R.id.tv_my);
        tvMy.setText(dataBean);
        Drawable drawable = context.getResources().getDrawable(R.mipmap.icon_my_pic);
        drawable.setBounds(0,0,drawable.getMinimumWidth(),drawable.getMinimumHeight());
        tvMy.setCompoundDrawables(null, drawable,null,null);
    }
}
