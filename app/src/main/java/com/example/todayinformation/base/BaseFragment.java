package com.example.todayinformation.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.todayinformation.mvp.view.LifeCircleMvpActivity;
import com.example.todayinformation.mvp.view.LifeCircleMvpFragment;

import butterknife.ButterKnife;

/*
 * @Author Sha
 * @Date 2020/4/8
 * @Des 基类
 */
public abstract class BaseFragment extends LifeCircleMvpFragment {

    private Context mContext;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mView = null;
        Viewinject annotation = this.getClass().getAnnotation(Viewinject.class);
        if(annotation != null){
            int mainlayoutid = annotation.mainlayoutid();
            if(mainlayoutid > 0){
                mView = initFragmentView(inflater, mainlayoutid);
                bindView(mView);
                afterBindView();
            }else{
                throw new RuntimeException("mainlayoutid < 0");
            }
        }else{
            throw new RuntimeException("annotation == null");
        }
        return mView;
    }

    private View initFragmentView(LayoutInflater inflater, int mainlayoutid) {

        return inflater.inflate(mainlayoutid, null);
    }


    //模板方法设计模式
    public abstract void afterBindView();

    //view的依赖注入绑定
    private void bindView(View mView) {
        ButterKnife.bind(this, mView);

    }
}
