package com.example.tongpao.ui.home.homefragments;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.tongpao.R;
import com.example.tongpao.adapter.InfoPhotoAdapter;
import com.example.tongpao.base.BaseFragment;
import com.example.tongpao.bean.PhotoBean;
import com.example.tongpao.constract.home.IHome;
import com.example.tongpao.presenter.home.PhotoPresenter;

import butterknife.BindView;

public class PhotoFragment extends BaseFragment<IHome.IPhotoPresenter> implements IHome.IPhotoView {
    @BindView(R.id.rcl_photo)
    RecyclerView rclPhoto;
    private InfoPhotoAdapter infoPhotoAdapter;

    @Override
    protected IHome.IPhotoPresenter initPresenter() {
        return new PhotoPresenter();
    }

    @Override
    protected void initData() {
        presneter.getPhoto("home/photo.json");
    }

    @Override
    protected void initView(View view) {
        rclPhoto.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        infoPhotoAdapter = new InfoPhotoAdapter(context);
        rclPhoto.setAdapter(infoPhotoAdapter);
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_photo;
    }

    @Override
    public void setPhoto(PhotoBean video) {
        infoPhotoAdapter.setData(video.getData().getDynamics());
    }
}
