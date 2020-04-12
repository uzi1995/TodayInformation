package com.example.todayinformation;

public class SplashTimerPresenter {


    private final SplashActivity mActivity;
    private CustomCountDownTimer timer;

    public SplashTimerPresenter(SplashActivity Activity){
        this.mActivity = Activity;
    }

    public void initTimer() {
        //实现连续播放
        timer = new CustomCountDownTimer(5, new CustomCountDownTimer.ICountDownHandler() {
            @Override
            public void onTicker(int time) {
                mActivity.setTvTimer(time + "秒");
            }

            @Override
            public void onFinish() {
                mActivity.setTvTimer("跳过");
            }
        });
        timer.start();
    }

    public void cancel() {
        timer.cancel();
    }
}
