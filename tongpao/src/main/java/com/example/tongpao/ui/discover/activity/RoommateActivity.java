package com.example.tongpao.ui.discover.activity;

import android.util.Log;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tongpao.R;
import com.example.tongpao.adapter.discover.NearByAdapter;
import com.example.tongpao.adapter.discover.RoommateAdapter;
import com.example.tongpao.base.BaseActivity;
import com.example.tongpao.bean.discover.NearByBean;
import com.example.tongpao.bean.discover.RoommateBean;
import com.example.tongpao.common.Contant;
import com.example.tongpao.constract.discover.IFind;
import com.example.tongpao.myview.VideoItemDecoration2;
import com.example.tongpao.presenter.discover.RoommatePresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class RoommateActivity extends BaseActivity<IFind.DisPresenter> implements IFind.DisView {
    @BindView(R.id.mTool)
    Toolbar mTool;
    @BindView(R.id.et_search)
    EditText etSearch;
    @BindView(R.id.tv_roommate_change)
    TextView tvRoommateChange;
    @BindView(R.id.recycler_roommate_h)
    RecyclerView recyclerRoommateH;
    @BindView(R.id.tv_ge)
    TextView tvGe;
    @BindView(R.id.tv_nearby)
    TextView tvNearby;
    @BindView(R.id.recycler_roommate_v)
    RecyclerView recyclerRoommateV;
    private List<RoommateBean.DataBean> first = new ArrayList<>();
    private List<RoommateBean.DataBean> second = new ArrayList<>();
    private List<RoommateBean.DataBean> third = new ArrayList<>();
    private RoommateAdapter roommateAdapter;
    private int count = 1;
    private NearByAdapter nearByAdapter;
    private ArrayList<RoommateBean.DataBean> dataBeans;
    private ArrayList<NearByBean.DataBean.ListBean> listBeans;

    @Override
    protected void initData() {
        presenter.getRoommateData();
        presenter.getNearByData();
    }

    @Override
    protected IFind.DisPresenter initPresenter() {
        return new RoommatePresenter();
    }

    @Override
    protected void initView() {
        mTool.setTitle("");
        setSupportActionBar(mTool);

        mTool.setNavigationIcon(R.mipmap.icon_back_black);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        recyclerRoommateH.setLayoutManager(gridLayoutManager);
        //设置网格布局之间的间隔
        VideoItemDecoration2 itemDecoration = new VideoItemDecoration2();
        itemDecoration.setSpace(20);
        recyclerRoommateH.addItemDecoration(itemDecoration);
        dataBeans = new ArrayList<>();
        roommateAdapter = new RoommateAdapter(this);
        recyclerRoommateH.setAdapter(roommateAdapter);

        recyclerRoommateV.setLayoutManager(new LinearLayoutManager(this));
        listBeans = new ArrayList<>();
        nearByAdapter = new NearByAdapter(this);
        recyclerRoommateV.setAdapter(nearByAdapter);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_roommate;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void getRoommateReturn(RoommateBean result) {
        Log.d(TAG, "getRoommateReturn: " + result.toString());
        if (result.getStatus().getStatusCode() == Contant.DATA_SUCCESS) {
            List<RoommateBean.DataBean> data = result.getData();
            for (int i = 0; i < data.size(); i++) {
                if (i >= 0 && i < 3) {
                    first.add(data.get(i));
                } else if (i >= 3 && i < 6) {
                    second.add(data.get(i));
                } else {
                    third.add(data.get(i));
                }
            }
            roommateAdapter.setData(first);
        }
    }

    @Override
    public void getNearByReturn(NearByBean result) {
        Log.d(TAG, "getNearByReturn: " + result.getData().getList().size());
        if (result.getStatus().getStatusCode() == Contant.DATA_SUCCESS) {
            nearByAdapter.setData(result.getData().getList());
        }
    }

    private static final String TAG = "RoommateActivity";
    @OnClick(R.id.tv_roommate_change)
    public void onViewClicked() {
        roommateAdapter.clearData();
        if (count == 0) {
            roommateAdapter.setData(first);
            count++;
        } else if (count == 1) {
            roommateAdapter.setData(second);
            count++;
        } else {
            roommateAdapter.setData(third);
            count = 0;
        }
    }
}
