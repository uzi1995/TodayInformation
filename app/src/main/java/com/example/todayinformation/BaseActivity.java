package com.example.todayinformation;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;

/*
 * @Author Sha
 * @Date 2020/4/8
 * @Des 基类
 */
public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Viewinject annotation = this.getClass().getAnnotation(Viewinject.class);
        if(annotation != null){
            int mainlayoutid = annotation.mainlayoutid();
            if(mainlayoutid > 0){
                setContentView(mainlayoutid);
                ButterKnife.bind(this);
            }else{
                throw new RuntimeException("mainlayoutid < 0");
            }
        }else{
            throw new RuntimeException("annotation == null");
        }
    }
}
