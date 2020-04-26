package com.example.http;

import com.example.http.parser.IParser;
import com.example.http.request.IRequest;
import com.example.http.request.call.Icall;
import com.example.http.response.IResponse;
import com.example.http.result.IResult;

public abstract class HttpScheduler {


    public abstract Icall newCall(IRequest request);

    public IResult execute(Icall call) {
        //iresponse和iresult进行转换
        IResponse iResponse = call.execute();
        IRequest request = call.getRequest();
        IParser parser = request.getParser();
        return parser.parseResponse(request, iResponse);
    }
}
