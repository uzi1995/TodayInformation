package com.example.todayinformation.splash;

import android.os.Handler;


public class CustomCountDownTimer implements Runnable{
    private int time;
    private int countDownTime;
    private final ICountDownHandler countDownHandler;
    private final Handler handler;
    private boolean isRun;

    //运用观察者设计模式，设计构造函数
    public CustomCountDownTimer(int time, ICountDownHandler countDownHandler){
        handler = new Handler();
        this.time = time;
        this.countDownTime = time;
        this.countDownHandler = countDownHandler;
    }
//实现具体逻辑
    @Override
    public void run() {
        if(isRun){
            if(countDownHandler != null){
                countDownHandler.onTicker(countDownTime);
            }
            if(countDownTime == 0){
                cancel();
                if(countDownHandler != null){
                    countDownHandler.onFinish();
                }
            }else{
                countDownTime = time--;
                handler.postDelayed(this, 1000);
            }
        }
    }
    //开启倒计时
    public void start(){
        isRun = true;
        handler.post(this);
    }
    //跳出循环，终止
    public void cancel(){
        isRun = false;
        handler.removeCallbacks(this);
    }
//观察者回调接口，也叫IOC数据回调
    public interface ICountDownHandler{
        //倒计时回调
        void onTicker(int time);
        //完成时回调
        void onFinish();
    }
}
