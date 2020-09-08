package com.example.tongpao.adapter.discover;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.tongpao.R;
import com.example.tongpao.base.BaseAdapter;
import com.example.tongpao.bean.discover.DisCoverTopicBean;

public class DiscoverTopicAdapter extends BaseAdapter {
    public DiscoverTopicAdapter(Context context) {
        super(context);
    }

    @Override
    protected int getLayout() {
        return R.layout.adapter_topic;
    }

    @Override
    protected void bindData(BaseViewHolder baseViewHolder, Object data) {
        DisCoverTopicBean.DataBean bean = (DisCoverTopicBean.DataBean) data;
        ImageView img_cover = (ImageView) baseViewHolder.getView(R.id.img_topic_cover);
        TextView tv_title = (TextView) baseViewHolder.getView(R.id.tv_topic_title);
        TextView tv_location = (TextView) baseViewHolder.getView(R.id.tv_topic_location);
        TextView tv_time = (TextView) baseViewHolder.getView(R.id.tv_topic_time);

        Glide.with(context).load(bean.getCover())
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(20))).into(img_cover);
        tv_title.setText(bean.getTitle());
        tv_location.setText(bean.getLocation());
        String startTime = bean.getStartTime();
        String[] s = startTime.split(" ");
        if (s.length > 0){
            tv_time.setText(s[0]);
        }
    }
}
