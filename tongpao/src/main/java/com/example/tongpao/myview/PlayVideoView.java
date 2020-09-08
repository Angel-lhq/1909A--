package com.example.tongpao.myview;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.danikula.videocache.HttpProxyCacheServer;
import com.example.tongpao.R;
import com.example.tongpao.app.MyApp;
import com.example.tongpao.bean.VideoBean;
import com.example.tongpao.ui.home.activity.VideoDetailActivity;
import com.example.tongpao.util.UserUtil;

import cn.jzvd.JZUtils;
import cn.jzvd.Jzvd;
import cn.jzvd.JzvdStd;


public class PlayVideoView extends JzvdStd {
    private ViewGroup viewGroup;
    private Context context;
    private VideoBean.DataBean.ListBean dataBean;

    public PlayVideoView(Context context) {
        super(context);
        this.context = context;
    }

    public PlayVideoView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    @Override
    public void gotoScreenFullscreen() {
        screen = SCREEN_FULLSCREEN;
        ViewGroup vg = (ViewGroup) getParent();
        viewGroup = vg;
        vg.removeView(this);
        cloneAJzvd(vg);
        CONTAINER_LIST.add(vg);
        vg = (ViewGroup) (JZUtils.scanForActivity(getContext())).getWindow().getDecorView();//和他也没有关系
        vg.addView(this, new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        View view = getInflateView();
        vg.addView(view);
        setScreenFullscreen();
        JZUtils.hideStatusBar(getContext());

        JZUtils.setRequestedOrientation(getContext(), FULLSCREEN_ORIENTATION);
        JZUtils.hideSystemUI(getContext());//华为手机和有虚拟键的手机全屏时可隐藏虚拟键 issue:1326
    }

    @Override
    public void gotoScreenNormal() {
        screen = SCREEN_NORMAL;
        gobakFullscreenTime = System.currentTimeMillis();//退出全屏
        ViewGroup vg = (ViewGroup) (JZUtils.scanForActivity(getContext())).getWindow().getDecorView();
        vg.removeView(this);
        CONTAINER_LIST.getLast().removeAllViews();
        CONTAINER_LIST.getLast().addView(this, new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        CONTAINER_LIST.pop();

        setScreenNormal();//这块可以放到jzvd中
        JZUtils.showStatusBar(getContext());
        JZUtils.setRequestedOrientation(getContext(), NORMAL_ORIENTATION);
        JZUtils.showSystemUI(getContext());
    }

    private View getInflateView() {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_test, null);
        TextView tvLike = (TextView) view.findViewById(R.id.tv_like);
        ImageView imgBack = (ImageView) view.findViewById(R.id.img_back);
        TextView tvComment = (TextView) view.findViewById(R.id.tv_comment);
        ImageView imgHead = (ImageView) view.findViewById(R.id.img_head);
        ImageView imgLevel = (ImageView) view.findViewById(R.id.img_level);
        TextView tvName = (TextView) view.findViewById(R.id.tv_name);
        TextView tvFollow = (TextView) view.findViewById(R.id.tv_follow);
        TextView tvContent = (TextView) view.findViewById(R.id.tv_content);
        if (dataBean != null){
            if (!TextUtils.isEmpty(dataBean.getHeadUrl())){
                Glide.with(context).load(dataBean.getHeadUrl()).apply(RequestOptions.circleCropTransform()).into(imgHead);
            }
            if (!TextUtils.isEmpty(dataBean.getNickName())){
                tvName.setText(dataBean.getNickName());
            }
            tvLike.setText(dataBean.getLikeNumber()+"");
            tvComment.setText(dataBean.getCommentNumber()+"");
            imgLevel.setImageResource(UserUtil.getResByLevel(dataBean.getLevel()));
            if (!TextUtils.isEmpty(dataBean.getContent())){
                tvContent.setText(dataBean.getContent());
            }
            imgBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (screen == SCREEN_FULLSCREEN){
                        Jzvd.backPress();
                    }else {
                        ((VideoDetailActivity)context).finish();
                        JzvdStd.releaseAllVideos();
                    }
                }
            });
        }
        return view;
    }

    @Override
    public void setScreenFullscreen() {
        super.setScreenFullscreen();
        //进入全屏之后要保证原来的播放状态和ui状态不变，改变个别的ui
        fullscreenButton.setImageResource(R.drawable.jz_shrink);
        backButton.setVisibility(View.GONE);
        tinyBackImageView.setVisibility(View.INVISIBLE);
        batteryTimeLayout.setVisibility(View.VISIBLE);
        if (jzDataSource.urlsMap.size() == 1) {
            clarity.setVisibility(GONE);
        } else {
            clarity.setText(jzDataSource.getCurrentKey().toString());
            clarity.setVisibility(View.VISIBLE);
        }
        changeStartButtonSize((int) getResources().getDimension(R.dimen.jz_start_button_w_h_fullscreen));
        setSystemTimeAndBattery();
    }

    public void setData(VideoBean.DataBean.ListBean dataBean) {
        this.dataBean = dataBean;
    }


    @Override
    public void setUp(String url, String title, int screen, Class mediaInterfaceClass) {
        super.setUp(jzDataSource, screen, mediaInterfaceClass);
        titleTextView.setTextColor(Color.RED);
        setScreen(screen);
    }

    @Override
    public void startVideo() {
        if(screen == SCREEN_FULLSCREEN){
            startFullscreenDirectly(context,PlayVideoView.class,jzDataSource);
            onStatePreparing();
        }else{
            super.startVideo();
        }
    }
    @Override
    public void setUp(String url, String title) {
        //super.setUp(url, title);
        titleTextView.setTextColor(Color.RED);
        //修改标题的文字
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) titleTextView.getLayoutParams();
        if(params == null){
            params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        }
        titleTextView.setPadding(80,titleTextView.getPaddingTop(),titleTextView.getPaddingRight(),titleTextView.getPaddingBottom());
        if(url.startsWith("http") || url.startsWith("https")){ //如果是网络资源缓存
            HttpProxyCacheServer proxy = MyApp.getProxy(context);
            String proxyUrl = proxy.getProxyUrl(url);
            super.setUp(proxyUrl,title);
        }else{
            super.setUp(url,title);
        }
    }
}
