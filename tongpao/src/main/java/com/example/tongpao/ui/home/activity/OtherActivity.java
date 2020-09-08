package com.example.tongpao.ui.home.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.example.tongpao.R;
import com.example.tongpao.base.BaseActivity;
import com.example.tongpao.base.IBasePresenter;
import com.example.tongpao.bean.PerDynamicStateBean;
import com.example.tongpao.bean.RecommendBean;
import com.example.tongpao.bean.SquareBean;
import com.example.tongpao.myview.PhotoViewPager;
import com.github.chrisbanes.photoview.PhotoView;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class OtherActivity extends BaseActivity implements View.OnClickListener{

    public static final String TAG = OtherActivity.class.getSimpleName();
    private PhotoViewPager mViewPager;
    private int currentPosition;
    private MyImageAdapter adapter;
    private TextView mTvImageCount;
    private TextView mTvSaveImage;
    private List<String> Urls;
    @Override
    protected IBasePresenter initPresenter() {
        return null;
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        String data = intent.getStringExtra("data");
        int posi = intent.getIntExtra("posi", 0);
        String perdata = intent.getStringExtra("perdata");
        int perposi = intent.getIntExtra("perposi", 0);
        String squareData = intent.getStringExtra("squareData");
        int squareposi = intent.getIntExtra("squareposi", 0);
        String squerimg = intent.getStringExtra("squerimg");
        int sqposi = intent.getIntExtra("sqposi", 0);

        Urls = new ArrayList<>();
        if (!TextUtils.isEmpty(data)){
            currentPosition = posi;
            RecommendBean.DataBean.PostDetailBean postDetailBean = new Gson().fromJson(data, RecommendBean.DataBean.PostDetailBean.class);
            List<RecommendBean.DataBean.PostDetailBean.ImagesBean> images = postDetailBean.getImages();
            for (int i = 0; i < images.size(); i++) {
                Urls.add(images.get(i).getFilePath());
            }
        }
        if (!TextUtils.isEmpty(perdata)){
            currentPosition = perposi;
            PerDynamicStateBean.DataBean.DynamicsBean dynamicsBean = new Gson().fromJson(perdata, PerDynamicStateBean.DataBean.DynamicsBean.class);
            List<PerDynamicStateBean.DataBean.DynamicsBean.ImagesBean> images = dynamicsBean.getImages();
            for (int i = 0; i < images.size(); i++) {
                Urls.add(images.get(i).getFilePath());
            }
        }
        if (!TextUtils.isEmpty(squareData)){
            currentPosition = squareposi;
            SquareBean.DataBean.DynamicsBean dynamicsBean = new Gson().fromJson(squareData, SquareBean.DataBean.DynamicsBean.class);
            List<SquareBean.DataBean.DynamicsBean.ImagesBean> images = dynamicsBean.getImages();
            for (int i = 0; i < images.size(); i++) {
                Urls.add(images.get(i).getFilePath());
            }
        }
        if (!TextUtils.isEmpty(squerimg)){
            currentPosition = sqposi;
            Urls.add(squerimg);
        }


        adapter = new MyImageAdapter(Urls, this);
        mViewPager.setAdapter(adapter);
        mViewPager.setCurrentItem(currentPosition, false);
        mTvImageCount.setText(currentPosition+1 + "/" + Urls.size());
        mViewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                currentPosition = position;
                mTvImageCount.setText(currentPosition + 1 + "/" + Urls.size());
            }
        });
    }

    @Override
    protected void initView() {

        mViewPager = (PhotoViewPager) findViewById(R.id.view_pager_photo);
        mTvImageCount = (TextView) findViewById(R.id.tv_image_count);
        mTvSaveImage = (TextView) findViewById(R.id.tv_save_image_photo);
        mTvSaveImage.setOnClickListener(this);

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_other;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_save_image_photo:
                //save image
                break;
        }
    }

    public class MyImageAdapter extends PagerAdapter {
        public final String TAG = MyImageAdapter.class.getSimpleName();
        private List<String> imageUrls;
        private AppCompatActivity activity;

        public MyImageAdapter(List<String> imageUrls, AppCompatActivity activity) {
            this.imageUrls = imageUrls;
            this.activity = activity;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            String url = imageUrls.get(position);
            PhotoView photoView = new PhotoView(activity);
            Glide.with(activity)
                    .load(url)
                    .into(photoView);
            container.addView(photoView);
            photoView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d(TAG, "onClick: ");
                    activity.finish();
                }
            });
            return photoView;
        }

        @Override
        public int getCount() {
            return imageUrls != null ? imageUrls.size() : 0;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public int getItemPosition(Object object) {
            return POSITION_NONE;
        }
    }

}
