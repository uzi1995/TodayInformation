package com.example.player.player;

import android.content.Context;

import com.example.player.tool.DataSourceUtil;


public class PlayerFactory {
    /**
     * 一般工厂设计模式 ：可以创建用户想要的播放器
     *
     * @return
     */
    public IPlayer createPlayer(Context context) {
        //读取配置
        int playerType = DataSourceUtil.getMetaDataFromApp(context);
        switch (playerType) {
            case IPlayerType.MEDIAPLAYERTYPE:
                return new GoogleMediaPlayer();
            case IPlayerType.MEDIAPLAYERTYPE_2:
                return new ExoMediaPlayer(context);
            default:
                break;
        }
        return null;
    }
}
