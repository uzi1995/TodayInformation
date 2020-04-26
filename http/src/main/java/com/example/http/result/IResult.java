package com.example.http.result;
/*
 * @Author Sha
 * @Date 2020/4/26
 * @Des 所有IResponse解析后的结果
 */
public interface IResult<T> {

    boolean isSuccess();

    int getCode();

    T data();
}
