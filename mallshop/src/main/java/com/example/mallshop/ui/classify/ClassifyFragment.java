package com.example.mallshop.ui.classify;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.example.mallshop.R;
import com.example.mallshop.adapter.GridHelperAdapter;
import com.example.mallshop.adapter.LinearAdapter;
import com.example.mallshop.base.BaseFragment;
import com.example.mallshop.base.IBasePresenter;

import java.util.ArrayList;

import butterknife.BindView;

public class ClassifyFragment extends BaseFragment {

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;


    private ArrayList<Integer> imgSrc = new ArrayList<>();
    private GridHelperAdapter gridHelperAdapter;
    public ClassifyFragment() {
        // Required empty public constructor
    }

    @Override
    protected IBasePresenter initPresenter() {
        return null;
    }

    @Override
    protected void initData() {

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
    }
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
        return R.layout.fragment_classify;
    }
}