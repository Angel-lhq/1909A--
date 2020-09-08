package com.example.testdemo;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

public class DemoFragment extends Fragment {
    public static final String MERCHANT_DETAILS_PAGE = "MERCHANT_DETAILS_PAGE";
    private RecyclerView mRclDemo;
    private int mPage;
    private Context context;
    private List<String> mFoodData;
    private List<String> mMovieData;
    private List<String> mHaveFunData;
    private List<String> mEvaluationData;
    private DemoAdapter mDemoAdapter;

    public static DemoFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(MERCHANT_DETAILS_PAGE, page);
        DemoFragment tripFragment = new DemoFragment();
        tripFragment.setArguments(args);
        return tripFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(MERCHANT_DETAILS_PAGE);
        context = getActivity().getApplicationContext();
        setData();
    }

    private void setData() {
        mFoodData = new ArrayList<>();
        for(int i=0; i<20;i++){
            mFoodData.add("美食"+i);
        }
        mMovieData = new ArrayList<>();
        for(int i=0; i<10;i++){
            mMovieData.add("电影"+i);
        }
        mHaveFunData = new ArrayList<>();
        for(int i=0; i<15;i++){
            mHaveFunData.add("玩乐"+i);
        }
        mEvaluationData = new ArrayList<>();
        for(int i=0; i<5;i++){
            mEvaluationData.add("评价"+i);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_demo, container, false);
        mRclDemo = view.findViewById(R.id.rcl_demo);
        switch (mPage){
            case 0:
                initAdapter(mFoodData);
                break;
            case 1:
                initAdapter(mMovieData);
                break;
            case 2:
                initAdapter(mHaveFunData);
                break;
            case 3:
                initAdapter(mEvaluationData);
                break;
        }
        return view;
    }

    private void initAdapter(List<String> list) {
        mRclDemo.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL_LIST));
        mRclDemo.setLayoutManager(new LinearLayoutManager(getActivity()));
        mDemoAdapter = new DemoAdapter(getActivity(), R.layout.item_ification_class, list);
        mRclDemo.setAdapter(mDemoAdapter);
        //设置item点击事件
        mDemoAdapter.setOnRecyclerViewItemClickListener(new BaseQuickAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

            }
        });
    }

    /**
     * adapter
     */
    class DemoAdapter extends BaseQuickAdapter<String> {
        int mLayoutId;
        public DemoAdapter(Context context, int LayoutId, List<String> str) {
            super(context, LayoutId, str);
            mLayoutId = LayoutId;
        }

        @Override
        public void convert(BaseViewHolder helper, String str) {
            helper.setText(R.id.tvTitle,str);
        }
    }
}