package com.example.tongpao.ui.discover.activity;

import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tongpao.R;
import com.example.tongpao.adapter.discover.AssociationAdapter;
import com.example.tongpao.base.BaseActivity;
import com.example.tongpao.bean.discover.AssociationBean;
import com.example.tongpao.constract.discover.IFind;
import com.example.tongpao.presenter.discover.DoPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class DiscoverAssociationActivity extends BaseActivity<IFind.DoPresenter> implements IFind.DoView {
    @BindView(R.id.mTool)
    Toolbar mTool;
    @BindView(R.id.et_search)
    EditText etSearch;
    @BindView(R.id.img_bg)
    ImageView imgBg;
    @BindView(R.id.tv_add_ass)
    TextView tvAddAss;
    @BindView(R.id.tv_city_sel)
    ImageView tvCitySel;
    @BindView(R.id.recycler_ass)
    RecyclerView recyclerAss;
    private AssociationAdapter associationAdapter;
    private List<AssociationBean.DataBean.ListBean> listBeans;

    @Override
    protected void initData() {
        presenter.getAssociation();
    }

    @Override
    protected IFind.DoPresenter initPresenter() {
        return new DoPresenter();
    }

    @Override
    protected void initView() {
        mTool.setTitle("");
        setSupportActionBar(mTool);
        mTool.setNavigationIcon(R.mipmap.icon_back_black);
        recyclerAss.setLayoutManager(new LinearLayoutManager(this));
        recyclerAss.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        listBeans = new ArrayList<>();
        associationAdapter = new AssociationAdapter(this);
        recyclerAss.setAdapter(associationAdapter);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_shetuan;
    }

    @Override
    public void getAssociationReturn(AssociationBean result) {
        Log.d(TAG, "getAssociationReturn: " + result.toString());
        associationAdapter.setData(result.getData().getList());
    }

    private static final String TAG = "DiscoverAssociationActi";

}
