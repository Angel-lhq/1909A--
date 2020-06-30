package com.example.day29_6_29_2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.day29_6_29_2.databinding.ProjectItemBinding;

import java.util.ArrayList;
import java.util.List;

public class InfoRclAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<TabItemData.DataBean.DatasBean> list = new ArrayList<>();

    public InfoRclAdapter(Context context) {
        this.context = context;
    }

    public void setList(List<TabItemData.DataBean.DatasBean> list) {
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.project_item, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        Glide.with(context).load(list.get(position).getEnvelopePic()).into(viewHolder.ivleft);
        viewHolder.tvtitle.setText(list.get(position).getTitle());
        viewHolder.tvdata.setText(list.get(position).getNiceDate());
//        viewHolder.tvcontent.setText(list.get(position).getDesc());
        viewHolder.tvauthor.setText(list.get(position).getAuthor());
        viewHolder.img_heart.setBackgroundResource(R.drawable.heart_selector);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null){
                    onItemClickListener.itemClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView ivleft;
        private TextView tvtitle;
        private TextView tvcontent;
        private TextView tvauthor;
        private TextView tvdata;
        private ImageView img_heart;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivleft = itemView.findViewById(R.id.iv_project_item);
            tvtitle = itemView.findViewById(R.id.tv_project_item_title);
            tvcontent = itemView.findViewById(R.id.tv_project_item_content);
            tvauthor = itemView.findViewById(R.id.tv_project_item_author);
            tvdata = itemView.findViewById(R.id.tv_project_item_data);
            img_heart = itemView.findViewById(R.id.img_heart);
        }
    }
    public interface OnItemClickListener{
        void itemClick(int position);
    }
    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
