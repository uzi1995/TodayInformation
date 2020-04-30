package com.example.todayinformation.base;

import android.app.Application;

import com.example.todayinformation.base.crash.CrashProtectManager;
import com.example.todayinformation.base.helper.ContextHelper;


public class TodayInformationApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        CrashProtectManager.getInstance(this).init();
        //全局Context获取类
        ContextHelper.getInstance().init(this);
    }
}
