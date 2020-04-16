package com.example.todayinformation.base;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
/*
 * @Author Sha
 * @Date 2020/4/8
 * @Des 自定义注解
 */
@Retention(RUNTIME)
@Target(TYPE)
public @interface Viewinject {
    int mainlayoutid() default -1;
}
