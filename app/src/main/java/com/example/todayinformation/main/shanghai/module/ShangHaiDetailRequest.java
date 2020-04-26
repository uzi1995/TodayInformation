package com.example.todayinformation.main.shanghai.module;

import com.example.http.annotation.RequestMethod;
import com.example.http.request.IRequest;
import com.example.todayinformation.base.JHRequest;
import com.example.todayinformation.main.shanghai.dto.ShangHaiDetailBean;

public interface ShangHaiDetailRequest {

    IRequest xiaoHuaRequest = JHRequest.sendHttp("/joke/content/list.php", RequestMethod.Get, ShangHaiDetailBean.class);
}
