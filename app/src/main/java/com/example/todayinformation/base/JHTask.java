package com.example.todayinformation.base;

import com.example.http.result.IResult;
import com.example.http.result.IResultCallBack;
import com.example.http.result.Result;
import com.example.task.LfTask;

public abstract class JHTask<T> extends LfTask<IResult<T>> implements IResultCallBack<T> {


    @Override
    public void onComplete(IResult<T> iResult) {
        if(iResult != null){
            if(iResult.isSuccess()){
                onSuccess(iResult);
            }else{
                onFailed(Result.failed(Result.code_505));
            }
        }else{
            onFailed(Result.failed(Result.code_404));
        }
    }

    @Override
    public void onFailed(IResult t) {
        switch (t.getCode()){
            //可以做成统一的错误码的处理
            case Result.code_404:
                break;
            case Result.code_505:
                break;
        }
    }

    @Override
    public void onException(Throwable throwable) {
        onFailed(Result.failed(Result.code_504));
    }
}
