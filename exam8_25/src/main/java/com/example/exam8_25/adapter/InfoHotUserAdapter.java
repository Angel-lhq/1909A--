package com.example.exam8_25.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.exam8_25.R;
import com.example.exam8_25.base.BaseAdapter;
import com.example.exam8_25.bean.HotUserBean;
import com.example.exam8_25.common.CircleTransform;
import com.example.exam8_25.util.TextUtil;

import java.util.List;

public class InfoHotUserAdapter extends BaseAdapter<HotUserBean.DataBean> {

    public InfoHotUserAdapter(Context context) {
        super(context);
    }

    @Override
    protected int getLayout() {
        return R.layout.layout_hot_user;
    }

    @Override
    protected void bindData(BaseViewHolder holder, HotUserBean.DataBean dataBean) {
        ImageView imgHead = (ImageView) holder.getView(R.id.img_head);
        TextView tvName = (TextView) holder.getView(R.id.tv_name);
        TextView tvLocation = (TextView) holder.getView(R.id.tv_location);
        ImageView img1 = (ImageView) holder.getView(R.id.img1);
        ImageView img2 = (ImageView) holder.getView(R.id.img2);
        TextView tvFollow = (TextView) holder.getView(R.id.tv_follow);

        if (!TextUtils.isEmpty(dataBean.getHeadUrl())){
            Glide.with(context).load(dataBean.getHeadUrl()).apply(RequestOptions.bitmapTransform(new CircleTransform(context))).into(imgHead);
        }

        TextUtil.setText(tvName,dataBean.getNickName());
        TextUtil.setText(tvLocation,dataBean.getCity());
        List<HotUserBean.DataBean.FileBeanListBean> fileBeanList = dataBean.getFileBeanList();
        if (fileBeanList.size()>=2){
            Glide.with(context).load(fileBeanList.get(0).getFilePath()).apply(RequestOptions.bitmapTransform(new RoundedCorners(30))).into(img1);
            Glide.with(context).load(fileBeanList.get(1).getFilePath()).apply(RequestOptions.bitmapTransform(new RoundedCorners(30))).into(img2);
        }
    }
}
