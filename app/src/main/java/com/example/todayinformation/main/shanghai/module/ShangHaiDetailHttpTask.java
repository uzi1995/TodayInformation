package com.example.todayinformation.main.shanghai.module;

import com.example.http.LfHttpServer;
import com.example.http.result.IResult;

import java.util.HashMap;
import java.util.Map;

/*
 * @Author Sha
 * @Date 2020/4/25
 * @Des 执行网络请求
 */
public class ShangHaiDetailHttpTask<T> extends LfHttpServer {

    public IResult<T> getXiaoHuaList(String sort, String page, String pagesize){
        //封装参数，调用底层的execute
        Map<String, Object> params = new HashMap<>();
        params.put("sort", sort);
        params.put("page", page);
        params.put("pagesize", pagesize);
        params.put("time", "" + System.currentTimeMillis()/1000);
        params.put("key", "bbc57dd5e4f05991aff09eafd2e667e0");
        return super.execute(ShangHaiDetailRequest.xiaoHuaRequest,params);
    }
}
