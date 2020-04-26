package com.example.todayinformation.splash;


import com.example.mvp.mvp.base.BaseMvpPresenter;

/*
 * @Author Sha
 * @Date 2020/4/12
 * @Des 倒计时功能P层
 */
public class SplashTimerPresenter extends BaseMvpPresenter<ISplashActivityContract.Iview> implements ISplashActivityContract.IPresenter{
    private CustomCountDownTimer timer;

    public SplashTimerPresenter(ISplashActivityContract.Iview view) {
        super(view);
    }


    public void initTimer() {
        timer = new CustomCountDownTimer(5, new CustomCountDownTimer.ICountDownHandler() {
            @Override
            public void onTicker(int time) {
                getView().setTvTimer(time + "秒");
            }

            @Override
            public void onFinish() {
                getView().setTvTimer("跳过");
            }
        });
        timer.start();
    }

    public void cancel() {
        timer.cancel();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        cancel();
    }

    //防止空指针异常
    @Override
    protected ISplashActivityContract.Iview getEmptyView() {
        return ISplashActivityContract.emptyView;
    }

}
