package com.example.day01_8_1_homework.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.day01_8_1_homework.R;
import com.example.day01_8_1_homework.bean.Bean;

import java.util.ArrayList;
import java.util.List;

public class InfpRclAdapter extends RecyclerView.Adapter<InfpRclAdapter.ViewHolder>{
    Context context;
    List<Bean.DataBean.ActiondataBean> list=new ArrayList<>();

    public void setList(List<Bean.DataBean.ActiondataBean> list) {
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    public InfpRclAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.find_rv_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Bean.DataBean.ActiondataBean actiondataBean = list.get(position);
        holder.title.setText(actiondataBean.getTitle());
        holder.location.setText(actiondataBean.getLocation());
        Glide.with(context).load(actiondataBean.getCover())
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(20)))
                .into(holder.iv);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView iv;
        private final TextView title;
        private final TextView location;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
            title=itemView.findViewById(R.id.tv_title);
            location=itemView.findViewById(R.id.tv_location);
        }
    }
}
