package com.example.todayinformation.main.shanghai.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;

import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;
import androidx.core.view.ViewCompat;

import com.example.todayinformation.R;
import com.example.todayinformation.base.BaseActivity;
import com.example.todayinformation.base.Viewinject;

import butterknife.BindView;

@Viewinject(mainlayoutid = R.layout.activity_shanghai_detail)
public class ShanghaiDetailActivity extends BaseActivity {

    public static String mActivityOptionsCompat = "ShanghaiDetailActivity";

    @BindView(R.id.iv_shanghai_detail)
    ImageView ivShanghaiDetail;

    @Override
    public void afterBindView() {
        initAnima();
    }

    private void initAnima() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            ViewCompat.setTransitionName(ivShanghaiDetail, mActivityOptionsCompat);
            //开启转场动画
            startPostponedEnterTransition();
        }
    }

    //用于Android5.0系统的界面转场动画：共享元素动画
    public static void start(Activity activity, View view){

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            Intent intent = new Intent(activity, ShanghaiDetailActivity.class);
            Pair pair = new Pair(view, mActivityOptionsCompat);
            ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(activity, pair);
            ActivityCompat.startActivity(activity, intent, optionsCompat.toBundle());
        }
    }
}
