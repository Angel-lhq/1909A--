package com.example.tongpao.ui.home.perinfofragments;

import android.os.Build;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tongpao.R;
import com.example.tongpao.adapter.InfoCummunityAdapter;
import com.example.tongpao.base.BaseFragment;
import com.example.tongpao.base.IBasePresenter;
import com.example.tongpao.bean.PerCommunityBean;
import com.example.tongpao.constract.home.IHome;

import butterknife.BindView;

public class CommunityFragment extends BaseFragment {
    @BindView(R.id.rcl_community)
    RecyclerView rclCommunity;

    private int TYPE;
    private PerCommunityBean data;
    public IHome.ILoadData iLoadData;
    private InfoCummunityAdapter infoCummunityAdapter;

    public static CommunityFragment getInstance(int type, IHome.ILoadData iLoadData){
        CommunityFragment communityFragment = new CommunityFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("type",type);
        communityFragment.iLoadData = iLoadData;
        communityFragment.setArguments(bundle);
        return communityFragment;
    }
    @Override
    protected IBasePresenter initPresenter() {
        return null;
    }

    @Override
    protected void initData() {

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void initView(View view) {
        rclCommunity.setLayoutManager(new LinearLayoutManager(context));
        infoCummunityAdapter = new InfoCummunityAdapter(context);
        rclCommunity.setAdapter(infoCummunityAdapter);
        Bundle bundle = getArguments();
        if(bundle != null && bundle.containsKey("type")){
            TYPE = bundle.getInt("type");
        }
        if(iLoadData != null){
            iLoadData.loadData(TYPE);
        }
//        rclCommunity.setNestedScrollingEnabled(((PerInfoActivity)getActivity()).vpTouch);
//        rclCommunity.setOnScrollChangeListener(new View.OnScrollChangeListener() {
//            @Override
//            public void onScrollChange(View view, int i, int i1, int i2, int i3) {
//                if (rclCommunity.getScrollY() == 0){
//                    ((PerInfoActivity)getActivity()).setVpTouch(false);
//                }
//            }
//        });
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser && rclCommunity != null){
            if (data != null){
                if (iLoadData != null){
                    iLoadData.loadData(TYPE);
                }
            }
        }
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_community;
    }

    public void setData(PerCommunityBean data){
        this.data = data;
        if (rclCommunity == null) return;
        infoCummunityAdapter.setData(data.getData());
    }
}
