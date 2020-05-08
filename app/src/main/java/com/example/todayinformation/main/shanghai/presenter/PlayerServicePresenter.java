package com.example.todayinformation.main.shanghai.presenter;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;

import com.example.player.PlayerService;
import com.example.player.source.RawPlayerSource;
import com.example.todayinformation.R;
import com.example.todayinformation.base.BasePresenter;
import com.example.todayinformation.base.helper.ContextHelper;
import com.example.todayinformation.main.shanghai.lf.IPlayerServiceContract;


public class PlayerServicePresenter extends BasePresenter<IPlayerServiceContract.Iview> implements IPlayerServiceContract.IPresenter{


    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
           //IOC 数据回调  和Service链接成功后 调用
            PlayerService.PlayerBinder binder = (PlayerService.PlayerBinder) service;
            playerService = binder.getService();
            playOrPaused();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            //和Service链接断开后 调用
            if (playerService != null) {
                playerService.unbindService(mConnection);
                playerService = null;
            }
        }
    };
    private PlayerService playerService;

    public PlayerServicePresenter(IPlayerServiceContract.Iview view) {
        super(view);
    }


    @Override
    public void bindService(Context context) {
        if (playerService != null) {
            playOrPaused();
        } else {
            Intent intent = new Intent(context, PlayerService.class);
            context.bindService(intent, mConnection, Service.BIND_AUTO_CREATE);
        }
    }

    @Override
    public void playOrPaused() {
        if (playerService != null) {
            //开启播放音乐
            playerService.playOrPause(new RawPlayerSource().setPath(ContextHelper.getInstance().getApplicationContext().getPackageName(), R.raw.minyao),ContextHelper.getInstance().getApplicationContext());
        }
    }
}
