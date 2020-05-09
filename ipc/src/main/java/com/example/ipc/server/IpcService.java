package com.example.ipc.server;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import androidx.annotation.Nullable;

import com.example.ipc.IClientInterface;
import com.example.ipc.IServerInterface;
import com.example.ipc.response.ResponseUtil;


public class IpcService extends Service {


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new IServerInterface.Stub() {

            public IClientInterface mClientInterface;

            @Override
            public void excuteAsync(String requestKey, String requestParmas) throws RemoteException {
                ResponseUtil.getAsyncResponse(requestKey,requestParmas,mClientInterface);
            }


            // TODO: 2019/9/14  反射处理同步的方式 自行完善
            @Override
            public String excuteSync(String requestKey, String requestParmas) throws RemoteException {
                String result = "";
                switch (requestKey) {
                    case "shanghai_detail":
                        result = "来自远方的祝福";
                        break;
                    default:
                        break;
                }
                return result;
            }

            @Override
            public void registerCallBack(IClientInterface iClientInterface) throws RemoteException {
                this.mClientInterface = iClientInterface;
            }
        };
    }
}
