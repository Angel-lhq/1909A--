package com.example.tongpao.adapter.discover;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tongpao.R;
import com.example.tongpao.bean.discover.DiscoverBaikeBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DiscoverBaikeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;

    public DiscoverBaikeAdapter(Context context) {
        this.context = context;
    }
    List<DiscoverBaikeBean.DataBean.ListBean> list = new ArrayList<>();

    public void setList(List<DiscoverBaikeBean.DataBean.ListBean> list) {
        this.list .addAll(list);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 3) {
            //加载3张图的条目布局
            View view = LayoutInflater.from(context).inflate(R.layout.item_rot_rlv1, parent, false);
            ViewHolder1 viewHolder1 = new ViewHolder1(view);
            return viewHolder1;
        } else if (viewType == 1) {
            //加载1张图的条目布局
            View view = LayoutInflater.from(context).inflate(R.layout.item_rot_rlv2, parent, false);
            ViewHolder2 viewHolder2 = new ViewHolder2(view);
            return viewHolder2;
        } else {
            //加载文字布局
            View view = LayoutInflater.from(context).inflate(R.layout.item_rot_rlv3, parent, false);
            ViewHolder3 viewHolder3 = new ViewHolder3(view);
            return viewHolder3;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        DiscoverBaikeBean.DataBean.ListBean bean = list.get(position);

        //绑定布局
        if (getItemViewType(position) == 3) {
            ViewHolder1 viewHolder1 = (ViewHolder1) holder;
            viewHolder1.tvTitleRot.setText(bean.getTitle());
            viewHolder1.rotTvDate.setText(bean.getCreateTime());

        } else if (getItemViewType(position) == 1) {
            ViewHolder2 viewHolder2 = (ViewHolder2) holder;
            viewHolder2.rotRlv2Tv.setText(bean.getTitle());

        } else {
            ViewHolder3 viewHolder3 = (ViewHolder3) holder;
            viewHolder3.rotRlv3Tv.setText(bean.getTitle());
            viewHolder3.getRotRlv3Tv.setText(bean.getCreateTime());
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

//    @Override
//    public int getItemViewType(int position) {
//        List<DiscoverBaikeBean.DataBean.ListBean> filePathList = list.get(position).getFilePathList();
//        return filePathList.size();
//    }
    static
    class ViewHolder1 extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_title_rot)
        TextView tvTitleRot;
        @BindView(R.id.rot_iv1)
        ImageView rotIv1;
        @BindView(R.id.rot_iv2)
        ImageView rotIv2;
        @BindView(R.id.rot_iv3)
        ImageView rotIv3;
        @BindView(R.id.ll)
        LinearLayout ll;
        @BindView(R.id.rot_tv_date)
        TextView rotTvDate;

        ViewHolder1(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    static
    class ViewHolder2 extends RecyclerView.ViewHolder {
        @BindView(R.id.rot_rlv2_iv)
        ImageView rotRlv2Iv;
        @BindView(R.id.rot_rlv2_tv)
        TextView rotRlv2Tv;

        ViewHolder2(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    static
    class ViewHolder3 extends RecyclerView.ViewHolder {
        @BindView(R.id.rot_rlv3_tv)
        TextView rotRlv3Tv;
        @BindView(R.id.rot_rlv3_date)
        TextView getRotRlv3Tv;
        ViewHolder3(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
