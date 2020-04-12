package com.example.todayinformation;


/*
 * @Author Sha
 * @Date 2020/4/12
 * @Des 倒计时功能P层
 */
public class SplashTimerPresenter {
    private final SplashActivity mActivity;
    private CustomCountDownTimer timer;

    public SplashTimerPresenter(SplashActivity Activity){
        this.mActivity = Activity;
    }

    public void initTimer() {
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
