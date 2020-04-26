package com.example.http.parser;

import com.example.http.request.IRequest;
import com.example.http.response.IResponse;
import com.example.http.result.IResult;
import com.example.http.result.Result;
import com.google.gson.Gson;

import java.lang.reflect.Type;

public class DefaultResultParse implements IParser{


    private static DefaultResultParse mInstance;

    private final Gson mGson;

    private DefaultResultParse(){
        mGson = new Gson();
    }

    public static IParser getInstance() {

        if(mInstance == null){
            mInstance = new DefaultResultParse();
        }

        return mInstance;
    }

    @Override
    public IResult parseResponse(IRequest request, IResponse response) {

        Type type = request.getType();
        String bodyStr = response.getBodyStr();
        Object object = mGson.fromJson(bodyStr, type);

        return Result.success(object);

    }
}
