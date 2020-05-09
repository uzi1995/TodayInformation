package com.example.ipc.requst;


import com.example.ipc.CallBack;

public interface IRequest extends Comparable<IRequest> {

    void setParams(String params);

    String getParams();

    String getRequestKey();

    void addCallBack(CallBack callBack);

    CallBack getCallBack();

    long getAddTime();
}
