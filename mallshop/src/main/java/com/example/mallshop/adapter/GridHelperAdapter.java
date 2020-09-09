package com.example.mallshop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.example.mallshop.R;

import java.util.List;

public class GridHelperAdapter extends DelegateAdapter.Adapter<RecyclerView.ViewHolder> {

    private LayoutHelper mHelper;
    private List<Integer> mData;
    private Context context;

    public GridHelperAdapter(List<Integer> mData, LayoutHelper helper,Context context) {
        this.mData = mData;
        this.mHelper = helper;
        this.context=context;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return mHelper;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_grid_layout, parent, false);
        return new RecyclerViewItemHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((RecyclerViewItemHolder) holder).iv_icon.setBackgroundResource(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    /**
     * 正常条目的item的ViewHolder
     */
    private class RecyclerViewItemHolder extends RecyclerView.ViewHolder {

        public ImageView iv_icon;

        public RecyclerViewItemHolder(View itemView) {
            super(itemView);
            iv_icon = (ImageView) itemView.findViewById(R.id.iv);
        }
    }
}
