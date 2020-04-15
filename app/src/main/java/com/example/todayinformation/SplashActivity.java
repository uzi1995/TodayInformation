package com.example.todayinformation;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;

import butterknife.BindView;
/*
 * @Author Sha
 * @Date 2020/4/12
 * @Des 闪屏页面
 */
@Viewinject(mainlayoutid = R.layout.activity_splash)
public class SplashActivity extends BaseActivity implements ISplashActivityContract.Iview{

    @BindView(R.id.vv_play)
    FullScreenVideoView  mVideoView;
    @BindView(R.id.tv_splash_timer)
    TextView mTvTimer;

    private ISplashActivityContract.IPresenter timerPresenter;

    @Override
    public void afterBindView() {
        initTimerPresenter();
        initListener();
        initVideo();
    }

    private void initTimerPresenter() {
        timerPresenter = new SplashTimerPresenter(this);
        timerPresenter.initTimer();
    }

    private void initVideo() {
        //找到视频文件
        mVideoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + File.separator + R.raw.splash));
        //播放视频
        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();
            }
        });
    }

    private void initListener() {
        mTvTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }
        });
        mVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.start();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        timerPresenter.cancel();
    }

    public void setTvTimer(String s) {
        mTvTimer.setText(s);
    }
}
