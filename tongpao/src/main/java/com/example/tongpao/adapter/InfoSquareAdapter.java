package com.example.tongpao.adapter;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.tongpao.R;
import com.example.tongpao.base.BaseAdapter;
import com.example.tongpao.bean.SquareBean;
import com.example.tongpao.myview.ExpandTextView;
import com.example.tongpao.ui.home.activity.OtherActivity;
import com.example.tongpao.util.DateUtil;
import com.google.gson.Gson;

import java.util.List;

import cn.jzvd.JzvdStd;

public class InfoSquareAdapter extends BaseAdapter<SquareBean.DataBean.DynamicsBean> {

    private MediaPlayer mediaPlayer;

    public InfoSquareAdapter(Context context) {
        super(context);
    }

    @Override
    protected int getLayout() {
        return R.layout.layout_square_item;
    }

    @Override
    protected void bindData(BaseViewHolder holder, SquareBean.DataBean.DynamicsBean dataBean) {
        ImageView imgHead = (ImageView) holder.getView(R.id.img_head);
        TextView tvUserName = (TextView) holder.getView(R.id.tv_username);
        TextView tvDate = (TextView) holder.getView(R.id.tv_date);
        TextView txtFollow = (TextView) holder.getView(R.id.txt_follow);
        ExpandTextView tvDes = (ExpandTextView) holder.getView(R.id.tv_des);
        LinearLayout lineaMedio = (LinearLayout) holder.getView(R.id.linea_medio);
        RecyclerView rclImages = (RecyclerView) holder.getView(R.id.rcl_images);
        ImageView imgSquare = (ImageView) holder.getView(R.id.img_square);
        ImageView imgPlay = (ImageView) holder.getView(R.id.img_play);
        TextView tvPlayTime = (TextView) holder.getView(R.id.tv_play_time);
        ProgressBar progress = (ProgressBar) holder.getView(R.id.progress);
        JzvdStd jzVideo = (JzvdStd) holder.getView(R.id.jz_video);
        TextView txtFollowNums = (TextView) holder.getView(R.id.txt_follow_nums);
        TextView txtComment = (TextView) holder.getView(R.id.txt_comment);

        jzVideo.setVisibility(View.GONE);
        rclImages.setVisibility(View.GONE);
        imgSquare.setVisibility(View.GONE);
        lineaMedio.setVisibility(View.GONE);

        if (!TextUtils.isEmpty(dataBean.getHeadUrl()) && (dataBean.getHeadUrl().contains(".jpg")
                || dataBean.getHeadUrl().contains(".jpeg")
                || dataBean.getHeadUrl().contains(".png"))){
            Glide.with(context).load(dataBean.getHeadUrl()).apply(RequestOptions.circleCropTransform()).into(imgHead);
        }
        if (!TextUtils.isEmpty(dataBean.getNickName())){
            tvUserName.setText(dataBean.getNickName());
        }
        //显示时间
        if(!TextUtils.isEmpty(dataBean.getCreateTime())){
            Long time = DateUtil.getDateToTime(dataBean.getCreateTime(),null);
            String dateStr = DateUtil.getStandardDate(time);
            tvDate.setText(dateStr);
        }
        //内容的显示 ##包裹起来数据  @符号后面的数据
        String content = dataBean.getContent();

        WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        int width = manager.getDefaultDisplay().getWidth();
        tvDes.initWidth(width);
        tvDes.setCloseText(content);

        //判断描述下方是图片还是音视频文件及图片数量
        String videoPath = dataBean.getVideoPath();
        if (!TextUtils.isEmpty(videoPath) && !TextUtils.isEmpty(dataBean.getCover())){
            jzVideo.setVisibility(View.VISIBLE);
            jzVideo.setUp(videoPath,dataBean.getContent(),JzvdStd.SCREEN_NORMAL);
            Glide.with(context).load(dataBean.getCover()).into(jzVideo.thumbImageView);
        }
        List<SquareBean.DataBean.DynamicsBean.ImagesBean> images = dataBean.getImages();
        //集合内元素数量为1时  再判断是一张图片还是音频
        if (images.size() == 1){

            String filePath = images.get(0).getFilePath();
            //如果路径结尾为.mp3则为音频
            if (filePath.contains(".mp3")){
                lineaMedio.setVisibility(View.VISIBLE);
                preparePlayer(filePath);
                imgPlay.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (!imgPlay.isSelected()){
                            imgPlay.setSelected(true);
                            mediaPlayer.start();
                        }else {
                            imgPlay.setSelected(false);
                            mediaPlayer.pause();
                        }
                    }
                });
                int currentPosition = mediaPlayer.getCurrentPosition();
            }
            if (filePath.contains(".jpg") || filePath.contains(".jpeg") || filePath.contains(".png")){
                imgSquare.setVisibility(View.VISIBLE);
                Glide.with(context).load(filePath).into(imgSquare);
                imgSquare.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(context, OtherActivity.class);
                        intent.putExtra("squerimg",filePath);
                        intent.putExtra("sqposi",0);
                        context.startActivity(intent);
                    }
                });
            }
        }
        if (images.size()>1){
            rclImages.setVisibility(View.VISIBLE);
            rclImages.setLayoutManager(new GridLayoutManager(context,3){
                @Override
                public boolean canScrollVertically() {
                    return false;
                }
            });
            SquareImageAdapter squareImageAdapter = new SquareImageAdapter(context);
            squareImageAdapter.setData(images);
            rclImages.setAdapter(squareImageAdapter);
            squareImageAdapter.setiOnClick(new IOnClick() {
                @Override
                public void onClick(int position, Object o, View view) {
                    Intent intent = new Intent(context, OtherActivity.class);
                    intent.putExtra("squareposi",position);
                    String s = new Gson().toJson(dataBean);
                    intent.putExtra("squareData",s);
                    context.startActivity(intent);
                }
            });
        }

        txtFollowNums.setText(String.valueOf(dataBean.getLikeNumber()));
        txtComment.setText(String.valueOf(dataBean.getCommentNumber()));
    }

    private void preparePlayer(String filePath) {
        mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource(filePath);
            mediaPlayer.prepare();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
