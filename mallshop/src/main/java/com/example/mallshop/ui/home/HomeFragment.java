package com.example.mallshop.ui.home;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.mallshop.R;
import com.example.mallshop.adapter.GridHelperAdapter;
import com.example.mallshop.adapter.LinearAdapter;
import com.example.mallshop.base.BaseFragment;
import com.example.mallshop.bean.home.ContentBean;
import com.example.mallshop.constract.home.IHome;
import com.example.mallshop.presenters.home.HomeContentPresenter;
import com.example.mallshop.utils.DateUtil;
import com.example.mallshop.utils.LogUtil;
import com.sunfusheng.marqueeview.MarqueeView;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;
import com.youth.banner.indicator.CircleIndicator;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class HomeFragment extends BaseFragment<IHome.IHomeContentPresenter> implements IHome.IHomeContentView {

    @BindView(R.id.home_banner)
    Banner homeBanner;
    @BindView(R.id.marqueeView)
    MarqueeView marqueeView;
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.txt_next)
    TextView txtNext;
    @BindView(R.id.tv_time_hour)
    TextView tvHour;
    @BindView(R.id.tv_time_minute)
    TextView tvMinute;
    @BindView(R.id.tv_time_second)
    TextView tvSecond;

    private ArrayList<Integer> imgSrc = new ArrayList<>();
    private TimeThread timeThread;
    private GridHelperAdapter gridHelperAdapter;

    @Override
    protected IHome.IHomeContentPresenter initPresenter() {
        return new HomeContentPresenter();
    }

    @Override
    protected void initData() {
        presneter.getContent("home/content");
    }

    @Override
    protected void initView(View view) {
        VirtualLayoutManager layoutManager = new VirtualLayoutManager(context);
        mRecyclerView.setLayoutManager(layoutManager);
        //开始
        DelegateAdapter delegateAdapter = new DelegateAdapter(layoutManager, false);
        mRecyclerView.setAdapter(delegateAdapter);

//        LinearLayoutHelper linearHelper = new LinearLayoutHelper(5);
//        delegateAdapter.addAdapter(new RVAdapter(context, linearHelper));

        //item_1
        GridLayoutHelper gridHelper = new GridLayoutHelper(5);
        gridHelper.setMarginTop(30);
        // gridHelper.setWeights(new float[]{20.0f,20.0f,20.0f,20.0f,20.0f});
        //设置垂直方向条目的间隔
        gridHelper.setVGap(5);
        //设置水平方向条目的间隔
        gridHelper.setHGap(5);
        gridHelper.setMarginLeft(30);
        gridHelper.setMarginBottom(30);
        //自动填充满布局，在设置完权重，若没有占满，自动填充满布局
        gridHelper.setAutoExpand(true);
        initGridData();
        gridHelperAdapter = new GridHelperAdapter(imgSrc, gridHelper,context);
        gridHelperAdapter.notifyDataSetChanged();
        delegateAdapter.addAdapter(gridHelperAdapter);
        //item_1
        //Linear 布局
        LinearLayoutHelper linearHelper1 = new LinearLayoutHelper(5);
        delegateAdapter.addAdapter(new LinearAdapter(context, linearHelper1));

        initTime();
        timeThread = new TimeThread();
        timeThread.start();

    }

    private void initTime() {
        String time = DateUtil.getTime();
        String[] timeSplit = time.split(":");
        if (timeSplit.length > 0){
            int hour = Integer.parseInt(timeSplit[0]);
            int minute = 60 - Integer.parseInt(timeSplit[1]);
            int second = 60 - Integer.parseInt(timeSplit[2]);
            if (txtNext != null && tvHour != null && tvSecond != null && tvMinute != null) {
                txtNext.setText("下一场" + (hour + 1) + "：00开始");
                tvHour.setText("00");
                tvMinute.setText(minute + "");
                tvSecond.setText(second + "");
                if (minute < 10) {
                    tvMinute.setText("0" + minute);
                }
                if (second < 10) {
                    tvSecond.setText("0" + second);
                }
                if (minute == 60) {
                    tvMinute.setText("00");
                }
                if (second == 60) {
                    tvSecond.setText("00");
                }
                if (minute == 60 && second == 60) {
                    tvHour.setText("01");
                    tvMinute.setText("00");
                    tvSecond.setText("00");
                }
            }
        }
    }

    private static final int msgKey1 = 1;

    public class TimeThread extends Thread {
        @Override
        public void run () {
            do {
                try {
                    Thread.sleep(1000);
                    Message msg = new Message();
                    msg.what = msgKey1;
                    mHandler.sendMessage(msg);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } while(true);
        }
    }
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage (Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case msgKey1:
                    initTime();
                    break;
                default:
                    break;
            }
        }
    };

    private void initGridData() {
        imgSrc.add(R.mipmap.ic_launcher);
        imgSrc.add(R.mipmap.ic_launcher);
        imgSrc.add(R.mipmap.ic_launcher);
        imgSrc.add(R.mipmap.ic_launcher);
        imgSrc.add(R.mipmap.ic_launcher);
        imgSrc.add(R.mipmap.ic_launcher);
        imgSrc.add(R.mipmap.ic_launcher);
        imgSrc.add(R.mipmap.ic_launcher);
        imgSrc.add(R.mipmap.ic_launcher);
        imgSrc.add(R.mipmap.ic_launcher);
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_home;
    }

    @Override
    public void setContent(ContentBean contentBean) {
        LogUtil.logd(contentBean.getCode()+contentBean.getMessage());
        List<ContentBean.DataBean.BrandListBean> brandList = contentBean.getData().getBrandList();
        List<ContentBean.DataBean.AdvertiseListBean> advertiseList = contentBean.getData().getAdvertiseList();
        List<String> imgs = new ArrayList<>();
        List<String> title = new ArrayList<>();
        for (ContentBean.DataBean.AdvertiseListBean advertiseListBean : advertiseList) {
            imgs.add(advertiseListBean.getPic());
            title.add(advertiseListBean.getName());
        }
        homeBanner.setAdapter(new BannerImageAdapter<String>(imgs) {
            @Override
            public void onBindView(BannerImageHolder holder, String data, int position, int size) {
                //图片加载自己实现
                Glide.with(holder.itemView)
                        .load(data)
                        .apply(RequestOptions.bitmapTransform(new RoundedCorners(30)))
                        .into(holder.imageView);
            }
        }).addBannerLifecycleObserver(this)//添加生命周期观察者
                .setIndicator(new CircleIndicator(context))
                .setBannerRound(20)
                .setBannerGalleryEffect(5,5,10);
        marqueeView.startWithList(title);
    }

}