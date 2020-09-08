package com.example.tongpao.ui.myOwn.activity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tongpao.MainActivity;
import com.example.tongpao.R;
import com.example.tongpao.base.BaseActivity;
import com.example.tongpao.constract.myOwn.IMyOwn;
import com.example.tongpao.myview.CustomerVideoView;

import butterknife.BindView;

public class LoginPrepareActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.img_back)
    ImageView imgBack;
    @BindView(R.id.videoView)
    CustomerVideoView videoView;
    @BindView(R.id.btn_phone_login)
    TextView btnPhoneLogin;
    @BindView(R.id.btn_pwd_login)
    TextView btnPwdLogin;
    @BindView(R.id.img_qq)
    ImageView imgQQ;
    @BindView(R.id.img_wechat)
    ImageView imgWeChat;
    @BindView(R.id.img_sina)
    ImageView imgSina;

    @Override
    protected IMyOwn.ILoginPresenter initPresenter() {
        return null;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        imgBack.setOnClickListener(this);
        btnPhoneLogin.setOnClickListener(this);
        btnPwdLogin.setOnClickListener(this);
        imgQQ.setOnClickListener(this);
        imgWeChat.setOnClickListener(this);
        imgSina.setOnClickListener(this);
        Uri uri = Uri.parse( "/sdcard/Pictures/WeiXin/1598518000741.mp4" );
        videoView.setVideoURI(uri);
        videoView.seekTo(0);
        videoView.requestFocus();
        videoView.start();

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setVolume(0f, 0f);
                mp.start();
                mp.setLooping(true);
            }
        });
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_login_prepare;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.img_back:
                Intent intent = new Intent(this, MainActivity.class);
                intent.putExtra("login",1);
                startActivity(intent);
                finish();
                break;
            case R.id.btn_phone_login:
                break;
            case R.id.btn_pwd_login:
                startActivity(new Intent(this,LoginActivity.class));
                finish();
                break;
            case R.id.img_qq:
                break;
            case R.id.img_wechat:
                break;
            case R.id.img_sina:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (videoView != null) videoView.stopPlayback();
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("login",1);
        startActivity(intent);
        super.onBackPressed();
    }
}
