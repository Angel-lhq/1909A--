package com.example.tongpao.ui.home.homefragments;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.tongpao.R;
import com.example.tongpao.adapter.InfoRecommendAdapter;
import com.example.tongpao.base.BaseAdapter;
import com.example.tongpao.base.BaseFragment;
import com.example.tongpao.bean.BannerBean;
import com.example.tongpao.bean.HotTopicBean;
import com.example.tongpao.bean.HotUserBean;
import com.example.tongpao.bean.RecommendBean;
import com.example.tongpao.constract.home.IHome;
import com.example.tongpao.presenter.home.RecommendPresenter;
import com.example.tongpao.ui.home.activity.DetailActivity;
import com.example.tongpao.util.MyLayoutManger;
import com.google.gson.Gson;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;
import com.youth.banner.indicator.CircleIndicator;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class RecommendFragment extends BaseFragment<IHome.IRecommendPresenter> implements IHome.IRecommendView {
    @BindView(R.id.banner)
    Banner banner;
    @BindView(R.id.rcl_hottopic)
    RecyclerView rcl_hottopic;
    @BindView(R.id.rcl_recommend)
    RecyclerView rclRecommend;
    private InfoRclHotTopicAdapter hotTopicAdapter;
    private int[] colors = new int[]{
            R.color.card_color1,
            R.color.card_color2,
            R.color.card_color3,
            R.color.card_color4,
            R.color.card_color5,
            R.color.card_color6
    };
    private InfoRecommendAdapter infoRecommendAdapter;


    @Override
    protected IHome.IRecommendPresenter initPresenter() {
        return new RecommendPresenter();
    }

    @Override
    protected void initData() {
        presneter.getBanner("home/banner.json");
        presneter.getHotTopic("home/topic_discussed.json");
        presneter.getRecommend("home/recommend.json");
        presneter.getHotUser("home/hot_user.json");
    }

    @Override
    protected void initView(View view) {
        LinearLayoutManager HottopicManager = new LinearLayoutManager(context);
        HottopicManager.setOrientation(RecyclerView.HORIZONTAL);
        rcl_hottopic.setLayoutManager(HottopicManager);
        hotTopicAdapter = new InfoRclHotTopicAdapter(context);
        rcl_hottopic.setAdapter(hotTopicAdapter);

        MyLayoutManger RecommendManager = new MyLayoutManger(context);
        RecommendManager.setScrollEnabled(false);
        rclRecommend.setLayoutManager(RecommendManager);
        infoRecommendAdapter = new InfoRecommendAdapter(context);
        rclRecommend.setAdapter(infoRecommendAdapter);
        infoRecommendAdapter.setiOnClick(new BaseAdapter.IOnClick<RecommendBean.DataBean>() {
            @Override
            public void onClick(int position, RecommendBean.DataBean dataBean,View view1) {
                dataBean.getComments().getCountNumber();
                String dataStr = new Gson().toJson(dataBean);
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("dataStr",dataStr);
                startActivity(intent);
            }
        });
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_recommend;
    }

    @Override
    public void setBanner(BannerBean bannerBean) {
        List<BannerBean.DataBean.ListBean> list = bannerBean.getData().getList();
        List<String> imgs = new ArrayList<>();
        List<String> title = new ArrayList<>();
        if (list.size() > 0){
            for (BannerBean.DataBean.ListBean listBean : list) {
                imgs.add(listBean.getBanner());
                title.add(listBean.getName());
            }
        }
        banner.setAdapter(new BannerImageAdapter<String>(imgs) {
            @Override
            public void onBindView(BannerImageHolder holder, String data, int position, int size) {
                //图片加载自己实现
                Glide.with(holder.itemView)
                        .load(data)
                        .apply(RequestOptions.bitmapTransform(new RoundedCorners(30)))
                        .into(holder.imageView);
            }
        }).addBannerLifecycleObserver(this)//添加生命周期观察者
            .setIndicator(new CircleIndicator(context));

    }
    /****************************************banner*********************/

    //实现HolderCreator接口
    public interface HolderCreator {
        View createView(Context context, final int index, Object o);
    }

    //举个栗子
    class ImageHolderCreator implements HolderCreator {
        @Override
        public View createView(final Context context, final int index, Object o) {
            ImageView iv = new ImageView(context);
            iv.setScaleType(ImageView.ScaleType.FIT_XY);
            Glide.with(context).load(o).into(iv);
            //内部实现点击事件
            iv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, index + "", Toast.LENGTH_LONG).show();
                }
            });
            return iv;
        }
    }

    @Override
    public void setHotTopic(HotTopicBean hotTopicBean) {
        Log.i("TAG", "setHotTopic: " + hotTopicBean.getStatus().getMessage());
        if (hotTopicBean.getStatus().getStatusCode() == 100){
            hotTopicAdapter.setData(hotTopicBean.getData());
        }
    }

    @Override
    public void setRecommend(RecommendBean recommendBean) {
        Log.i("TAG", "setRecommend: " + recommendBean.getStatus().getMessage());
        if (recommendBean.getStatus().getStatusCode() == 100){
            RecommendBean.DataBean data = recommendBean.getData();
            List<RecommendBean.DataBean> list = new ArrayList<>();
            list.add(data);
            infoRecommendAdapter.setData(list);
        }
    }

    @Override
    public void setHotUser(HotUserBean hotUserBean) {

    }

    public class InfoRclHotTopicAdapter extends BaseAdapter<HotTopicBean.DataBean> {

        public InfoRclHotTopicAdapter(Context context) {
            super(context);
        }


        @Override
        protected int getLayout() {
            return R.layout.layout_topic_item;
        }

        @Override
        protected void bindData(BaseViewHolder holder, HotTopicBean.DataBean dataBean) {
            ImageView imgTopic = (ImageView) holder.getView(R.id.img_topic);
            TextView tvTitle = (TextView) holder.getView(R.id.tv_title_topic);
            TextView tvUsertime = (TextView) holder.getView(R.id.tv_usetime_topic);
            ConstraintLayout topic = (ConstraintLayout) holder.getView(R.id.topic);
            tvTitle.setText("#"+ dataBean.getName()+"#");
            tvUsertime.setText(dataBean.getUseTime()+"人参与");
            Glide.with(context).load(dataBean.getImageUrl())
                    .apply(RequestOptions.bitmapTransform(new RoundedCorners(10))).into(imgTopic);
            topic.setBackgroundResource(colors[holder.getLayoutPosition()]);
        }

    }
}
