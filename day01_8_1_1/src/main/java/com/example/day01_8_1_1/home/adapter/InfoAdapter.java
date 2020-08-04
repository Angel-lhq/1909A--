package com.example.day01_8_1_1.home.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.day01_8_1_1.R;
import com.example.day01_8_1_1.home.bean.GirlBean;

import java.util.ArrayList;
import java.util.List;

public class InfoAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<GirlBean.ResultsBean> list = new ArrayList<>();

    public InfoAdapter(Context context) {
        this.context = context;
    }

    public void setList(List<GirlBean.ResultsBean> list) {
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_item, parent, false);
        return new HolderItem(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        HolderItem holderItem = (HolderItem) holder;
        holderItem.tv_title.setText(list.get(position).getDesc());
        Glide.with(context).load(list.get(position).getUrl()).into(holderItem.img_item);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private class HolderItem extends RecyclerView.ViewHolder {

        private TextView tv_title;
        private ImageView img_item;

        public HolderItem(View inflate) {
            super(inflate);
            tv_title = inflate.findViewById(R.id.tv_title);
            img_item = inflate.findViewById(R.id.img_item);

        }
    }
}
