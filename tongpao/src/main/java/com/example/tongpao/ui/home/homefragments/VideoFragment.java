package com.example.tongpao.ui.home.homefragments;

import android.content.Intent;
import android.view.View;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tongpao.R;
import com.example.tongpao.adapter.InfoVideoAdapter;
import com.example.tongpao.base.BaseAdapter;
import com.example.tongpao.base.BaseFragment;
import com.example.tongpao.bean.VideoBean;
import com.example.tongpao.constract.home.IHome;
import com.example.tongpao.presenter.home.VideoPresenter;
import com.example.tongpao.ui.home.activity.VideoDetailActivity;
import com.google.gson.Gson;

import butterknife.BindView;

public class VideoFragment extends BaseFragment<IHome.IVideoPresenter> implements IHome.IVideoView {

    @BindView(R.id.rcl_video)
    RecyclerView rclVideo;
    private InfoVideoAdapter infoVideoAdapter;
    private VideoBean video;

    @Override
    protected IHome.IVideoPresenter initPresenter() {
        return new VideoPresenter();
    }

    @Override
    protected void initData() {
        presneter.getVideo("home/video.json");
    }

    @Override
    protected void initView(View view) {
        rclVideo.setLayoutManager(new GridLayoutManager(context,2));
        infoVideoAdapter = new InfoVideoAdapter(context);
        rclVideo.setAdapter(infoVideoAdapter);
        infoVideoAdapter.setiOnClick(new BaseAdapter.IOnClick() {
            @Override
            public void onClick(int position, Object o, View view) {
                String videoStr = new Gson().toJson(video);
                Intent intent = new Intent(context, VideoDetailActivity.class);
                intent.putExtra("videodata",videoStr);
                intent.putExtra("posi",position);
                context.startActivity(intent);
            }
        });
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_video;
    }

    @Override
    public void setVideo(VideoBean video) {
        this.video = video;
        infoVideoAdapter.setData(video.getData().getList());
    }
}
