package com.example.tongpao.ui.home.homefragments;

import android.view.View;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tongpao.R;
import com.example.tongpao.adapter.InfoSquareAdapter;
import com.example.tongpao.base.BaseFragment;
import com.example.tongpao.bean.SquareBean;
import com.example.tongpao.constract.home.IHome;
import com.example.tongpao.presenter.home.SquarePresenter;
import com.example.tongpao.util.LogUtil;

import butterknife.BindView;
import cn.jzvd.JzvdStd;

public class SquareFragment extends BaseFragment<IHome.ISquarePresenter> implements IHome.ISquareView {

    @BindView(R.id.rcl_square)
    RecyclerView rclSquare;
    private InfoSquareAdapter infoSquareAdapter;

    @Override
    protected IHome.ISquarePresenter initPresenter() {
        return new SquarePresenter();
    }

    @Override
    protected void initData() {
        presneter.getSquare("home/square.json");
    }

    @Override
    protected void initView(View view) {
        rclSquare.setLayoutManager(new LinearLayoutManager(context));
        infoSquareAdapter = new InfoSquareAdapter(context);
        rclSquare.setAdapter(infoSquareAdapter);
        rclSquare.addItemDecoration(new DividerItemDecoration(context,DividerItemDecoration.VERTICAL));
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_square;
    }

    @Override
    public void setSquare(SquareBean square) {
        if (square != null){
            LogUtil.logi("有数据");
        }
        infoSquareAdapter.setData(square.getData().getDynamics());
    }

    @Override
    public void onPause() {
        super.onPause();
        JzvdStd.releaseAllVideos ();
    }
}
