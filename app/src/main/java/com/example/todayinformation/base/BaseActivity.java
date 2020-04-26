package com.example.todayinformation.base;

import android.os.Bundle;

import androidx.annotation.Nullable;


import com.example.mvp.mvp.view.LifeCircleMvpActivity;

import butterknife.ButterKnife;

/*
 * @Author Sha
 * @Date 2020/4/8
 * @Des 基类
 */
public abstract class BaseActivity extends LifeCircleMvpActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Viewinject annotation = this.getClass().getAnnotation(Viewinject.class);
        if(annotation != null){
            int mainlayoutid = annotation.mainlayoutid();
            if(mainlayoutid > 0){
                setContentView(mainlayoutid);
                bindView();
                afterBindView();
            }else{
                throw new RuntimeException("mainlayoutid < 0");
            }
        }else{
            throw new RuntimeException("annotation == null");
        }
    }

    //模板方法设计模式
    public abstract void afterBindView();

    //view的依赖注入绑定
    private void bindView() {
        ButterKnife.bind(this);

    }
}
