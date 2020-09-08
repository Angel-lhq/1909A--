package com.example.tongpao.ui.home.perinfofragments;

import android.os.Build;
import android.view.View;

import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tongpao.R;
import com.example.tongpao.adapter.InfoDynamicStateAdapter;
import com.example.tongpao.base.BaseFragment;
import com.example.tongpao.bean.PerDynamicStateBean;
import com.example.tongpao.constract.home.IHome;
import com.example.tongpao.presenter.home.PerDynamicPersenter;
import com.example.tongpao.util.MyLayoutManger;

import butterknife.BindView;

public class DynamicStateFragment extends BaseFragment<IHome.IPerDynamicPresenter> implements IHome.IPerDynamicView {

    @BindView(R.id.rcl_dynamic)
    RecyclerView rclDynamic;
    private InfoDynamicStateAdapter infoDynamicStateAdapter;

    @Override
    protected IHome.IPerDynamicPresenter initPresenter() {
        return new PerDynamicPersenter();
    }

    @Override
    protected void initData() {
        presneter.getDynamic("home/personal_activity.json");
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void initView(View view) {
        MyLayoutManger myLayoutManger = new MyLayoutManger(context);
        rclDynamic.setLayoutManager(myLayoutManger);
        infoDynamicStateAdapter = new InfoDynamicStateAdapter(context);
        rclDynamic.setAdapter(infoDynamicStateAdapter);
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_dynamic_state;
    }

    @Override
    public void setDynamic(PerDynamicStateBean perDynamicStateBean) {
        infoDynamicStateAdapter.setData(perDynamicStateBean.getData().getDynamics());
    }
}
