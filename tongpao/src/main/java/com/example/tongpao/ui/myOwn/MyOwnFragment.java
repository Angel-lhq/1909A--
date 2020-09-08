package com.example.tongpao.ui.myOwn;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.tongpao.R;
import com.example.tongpao.adapter.InfoRclMyAdapter;
import com.example.tongpao.base.BaseFragment;
import com.example.tongpao.base.IBasePresenter;
import com.example.tongpao.bean.UserLoginBean;
import com.example.tongpao.ui.myOwn.activity.PerInfoActivity;
import com.example.tongpao.ui.myOwn.activity.SettingActivity;
import com.example.tongpao.util.ImageFilterUtils;
import com.google.gson.Gson;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;

public class MyOwnFragment extends BaseFragment implements View.OnClickListener {

    private Unbinder unbinder;
    @BindView(R.id.img_cover)
    ImageView imgCover;
    @BindView(R.id.img_head)
    ImageView imgHead;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.img_level)
    ImageView imgLevel;
    @BindView(R.id.tv_own)
    TextView tvOwn;
    @BindView(R.id.tv_sign)
    TextView tvSign;
    @BindView(R.id.linea_active)
    LinearLayout lineaActive;
    @BindView(R.id.linea_follow)
    LinearLayout lineaFollow;
    @BindView(R.id.linea_lover)
    LinearLayout lineaLover;
    @BindView(R.id.linea_money)
    LinearLayout lineaMoney;
    @BindView(R.id.rcl_my)
    RecyclerView rclMy;
    @BindView(R.id.layout_community)
    ConstraintLayout layoutCommunity;
    @BindView(R.id.receive_address)
    ConstraintLayout recivieAddress;
    @BindView(R.id.skill_certification)
    ConstraintLayout skillCertification;
    @BindView(R.id.real_name_authentication)
    ConstraintLayout realNameAuthentication;
    @BindView(R.id.invitational)
    ConstraintLayout invitational;
    @BindView(R.id.img_textsms)
    ImageView imgTextsms;
    @BindView(R.id.img_setting)
    ImageView imgSetting;
    private SharedPreferences login;
    private int maxSelectNum = 9;
    private PopupWindow pop;
    @Override
    protected IBasePresenter initPresenter() {
        return null;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View view) {
        TextView addressName = recivieAddress.findViewById(R.id.tv_item_name);
        ImageView addressInto = recivieAddress.findViewById(R.id.img_into);
        addressName.setText("收货地址");
        TextView skillName = skillCertification.findViewById(R.id.tv_item_name);
        ImageView skillInto = skillCertification.findViewById(R.id.img_into);
        skillName.setText("技能认证");
        TextView realName = realNameAuthentication.findViewById(R.id.tv_item_name);
        ImageView realInto = realNameAuthentication.findViewById(R.id.img_into);
        TextView realAttestation = realNameAuthentication.findViewById(R.id.tv_attestation);
        realAttestation.setVisibility(View.VISIBLE);
        realName.setText("实名认证");
        TextView inviteName = invitational.findViewById(R.id.tv_item_name);
        ImageView inviteInto = invitational.findViewById(R.id.img_into);
        inviteName.setText("邀请同袍有奖");

        imgHead.setOnClickListener(this);
        tvOwn.setOnClickListener(this);
        tvName.setOnClickListener(this);
        tvSign.setOnClickListener(this);
        imgSetting.setOnClickListener(this);
        tvOwn.setOnClickListener(this);
        imgTextsms.setOnClickListener(this);
        List<String> my = new ArrayList<>();
        my.add("商品收藏");
        my.add("关注店铺");
        my.add("优惠卡卷");
        my.add("商城订单");
        my.add("我的活动");
        my.add("我的话题");
        my.add("我喜欢的");
        my.add("我的悬赏");
        rclMy.setLayoutManager(new GridLayoutManager(context,4));
        InfoRclMyAdapter infoRclMyAdapter = new InfoRclMyAdapter(context);
        rclMy.setAdapter(infoRclMyAdapter);
        infoRclMyAdapter.setData(my);
        login = context.getSharedPreferences("login", 0);

    }

    @Override
    public void onResume() {
        super.onResume();
        String dataStr = login.getString("data", "");
        if (!TextUtils.isEmpty(dataStr)){
            UserLoginBean userLoginBean = new Gson().fromJson(dataStr, UserLoginBean.class);
            UserLoginBean.DataBean dataBean = userLoginBean.getData();
            if (!TextUtils.isEmpty(dataBean.getNickname())){
                tvName.setText(dataBean.getNickname());
            }else if (!TextUtils.isEmpty(dataBean.getUsername())){
                tvName.setText(dataBean.getUsername());
            }

            if (!TextUtils.isEmpty(dataBean.getAvater())){
                Glide.with(context).load(dataBean.getAvater())
                        .apply(RequestOptions.bitmapTransform(new MyOwnFragment.GlideBlurformation(context)))
                        .into(imgCover);
                //设置头像的圆角
                RequestOptions options = RequestOptions.bitmapTransform(new CircleCrop());
                Glide.with(this).load(dataBean.getAvater()).apply(options).into(imgHead);
            }
        }
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_my_own;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.img_head:
                startActivity(new Intent(context, PerInfoActivity.class));
                //第一种方式，弹出选择和拍照的dialog
//                showPop();

                //第二种方式，直接进入相册，但是 是有拍照得按钮的
//                showAlbum();
                break;
            case R.id.tv_name:

                break;
            case R.id.tv_own:
                startActivity(new Intent(context, PerInfoActivity.class));
                break;
            case R.id.tv_sign:

                break;
            case R.id.img_setting:
                startActivity(new Intent(context, SettingActivity.class));
                break;
            case R.id.img_textsms:
                SharedPreferences share = context.getSharedPreferences("share", 0);
                share.edit().putBoolean("isFirst",true).commit();
                System.exit(0);
                break;
        }
    }

    private void showAlbum() {
        //参数很多，根据需要添加
        PictureSelector.create(getActivity())
                .openGallery(PictureMimeType.ofImage())// 全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()、音频.ofAudio()
                .maxSelectNum(maxSelectNum)// 最大图片选择数量
                .minSelectNum(1)// 最小选择数量
                .imageSpanCount(4)// 每行显示个数
                .selectionMode(PictureConfig.MULTIPLE)// 多选 or 单选PictureConfig.MULTIPLE : PictureConfig.SINGLE
                .previewImage(true)// 是否可预览图片
                .isCamera(true)// 是否显示拍照按钮
                .isZoomAnim(true)// 图片列表点击 缩放效果 默认true
                //.setOutputCameraPath("/CustomPath")// 自定义拍照保存路径
                .enableCrop(true)// 是否裁剪
                .compress(true)// 是否压缩
                //.sizeMultiplier(0.5f)// glide 加载图片大小 0~1之间 如设置 .glideOverride()无效
                .glideOverride(160, 160)// glide 加载宽高，越小图片列表越流畅，但会影响列表图片浏览的清晰度
                .withAspectRatio(1, 1)// 裁剪比例 如16:9 3:2 3:4 1:1 可自定义
                //.selectionMedia(selectList)// 是否传入已选图片
                //.previewEggs(false)// 预览图片时 是否增强左右滑动图片体验(图片滑动一半即可看到上一张是否选中)
                //.cropCompressQuality(90)// 裁剪压缩质量 默认100
                //.compressMaxKB()//压缩最大值kb compressGrade()为Luban.CUSTOM_GEAR有效
                //.compressWH() // 压缩宽高比 compressGrade()为Luban.CUSTOM_GEAR有效
                //.cropWH()// 裁剪宽高比，设置如果大于图片本身宽高则无效
                .rotateEnabled(false) // 裁剪是否可旋转图片
                //.scaleEnabled()// 裁剪是否可放大缩小图片
                //.recordVideoSecond()//录制视频秒数 默认60s
                .forResult(PictureConfig.CHOOSE_REQUEST);//结果回调onActivityResult code
    }

    private void showPop() {
        View bottomView = View.inflate(context, R.layout.layout_bottom_dialog, null);
        TextView mAlbum = bottomView.findViewById(R.id.tv_album);
        TextView mCamera = bottomView.findViewById(R.id.tv_camera);
        TextView mCancel = bottomView.findViewById(R.id.tv_cancel);

        pop = new PopupWindow(bottomView, -1, -2);
        pop.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        pop.setOutsideTouchable(true);
        pop.setFocusable(true);
        WindowManager.LayoutParams lp = getActivity().getWindow().getAttributes();
        lp.alpha = 0.5f;
        getActivity().getWindow().setAttributes(lp);
        pop.setOnDismissListener(new PopupWindow.OnDismissListener() {

            @Override
            public void onDismiss() {
                WindowManager.LayoutParams lp = getActivity().getWindow().getAttributes();
                lp.alpha = 1f;
                getActivity().getWindow().setAttributes(lp);
            }
        });
//        pop.setAnimationStyle(R.style.main_menu_photo_anim);
        pop.showAtLocation(getActivity().getWindow().getDecorView(), Gravity.BOTTOM, 0, 0);

        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.tv_album:
                        //相册
                        PictureSelector.create(getActivity())
                                .openGallery(PictureMimeType.ofImage())
                                .maxSelectNum(maxSelectNum)
                                .minSelectNum(1)
                                .imageSpanCount(4)
                                .enableCrop(true)// 是否裁剪
                                .selectionMode(PictureConfig.MULTIPLE)
                                .forResult(PictureConfig.CHOOSE_REQUEST);
                        break;
                    case R.id.tv_camera:
                        //拍照
                        PictureSelector.create(getActivity())
                                .openCamera(PictureMimeType.ofImage())
                                .forResult(PictureConfig.CHOOSE_REQUEST);
                        break;
                    case R.id.tv_cancel:
                        //取消
                        //closePopupWindow();
                        break;
                }
                closePopupWindow();
            }
        };

        mAlbum.setOnClickListener(clickListener);
        mCamera.setOnClickListener(clickListener);
        mCancel.setOnClickListener(clickListener);
    }

    public void closePopupWindow() {
        if (pop != null && pop.isShowing()) {
            pop.dismiss();
            pop = null;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        List<LocalMedia> images;
//        if (resultCode == RESULT_OK) {
//            if (requestCode == PictureConfig.CHOOSE_REQUEST) {// 图片选择结果回调
//
//                images = PictureSelector.obtainMultipleResult(data);
//                if (images.size()>0){
//                    LocalMedia localMedia = images.get(0);
//                    if (localMedia.isCut()){
//                        String cutPath = localMedia.getCutPath();
//                        File file = new File(cutPath);
//                        RequestBody requestBody = RequestBody.create(MediaType.parse("image/jpg"),file);
//                        MultipartBody.Part multipartBody = MultipartBody.Part.createFormData("file",file.getName(),requestBody);
//                        RequestBody postParams =RequestBody.create(MediaType.parse("text/plain"), "head");
//                        presneter.upLoad(postParams,multipartBody);
//                    }
//                    String Path = localMedia.getPath();
//                    File file = new File(Path);
//                    RequestBody requestBody = RequestBody.create(MediaType.parse("image/jpg"),file);
//                    MultipartBody.Part multipartBody = MultipartBody.Part.createFormData("file",file.getName(),requestBody);
//                    RequestBody postParams =RequestBody.create(MediaType.parse("text/plain"), "head");
//                    presneter.upLoad(postParams,multipartBody);
//                }
//                selectList.addAll(images);

//                selectList = PictureSelector.obtainMultipleResult(data);

                // 例如 LocalMedia 里面返回三种path
//                 1.media.getPath(); 为原图path
                // 2.media.getCutPath();为裁剪后path，需判断media.isCut();是否为true
                // 3.media.getCompressPath();为压缩后path，需判断media.isCompressed();是否为true
                // 如果裁剪并压缩了，以取压缩路径为准，因为是先裁剪后压缩的
//                adapter.setList(selectList);
//                adapter.notifyDataSetChanged();
//            }
//        }

    }

    public static class GlideBlurformation extends BitmapTransformation {
        private Context context;
        public GlideBlurformation(Context context) {
            this.context = context;
        }
        @Override
        protected Bitmap transform(@NonNull BitmapPool pool, @NonNull Bitmap toTransform, int outWidth, int outHeight) {
            return ImageFilterUtils.instance().blurBitmap(context, toTransform, 20,outWidth,outHeight);
        }

        @Override
        public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {

        }
    }
}
