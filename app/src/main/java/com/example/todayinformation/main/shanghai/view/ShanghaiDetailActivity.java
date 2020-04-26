package com.example.todayinformation.main.shanghai.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;
import androidx.core.view.ViewCompat;

import com.example.todayinformation.R;
import com.example.todayinformation.base.BaseActivity;
import com.example.todayinformation.base.Viewinject;
import com.example.todayinformation.main.shanghai.lf.IShanghaiDetailContract;
import com.example.todayinformation.main.shanghai.manager.GetXiaoHuaTask;
import com.example.todayinformation.main.shanghai.module.ShangHaiDetailHttpTask;
import com.example.todayinformation.main.shanghai.presenter.ShanghaiDetailPresenter;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import butterknife.BindView;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Viewinject(mainlayoutid = R.layout.activity_shanghai_detail)
public class ShanghaiDetailActivity extends BaseActivity implements IShanghaiDetailContract.Iview {

    IShanghaiDetailContract.IPresenter mPresenter = new ShanghaiDetailPresenter(this);


    public static String mActivityOptionsCompat = "ShanghaiDetailActivity";

    @BindView(R.id.iv_shanghai_detail)
    ImageView ivShanghaiDetail;

    @Override
    public void afterBindView() {
        initAnima();
        initGetNetData();
//        initPostNetData();
    }

    private void initPostNetData() {

    }

    //发送网络请求数据
    private void initGetNetData() {
        // TODO: 2020/4/26 和老师的不一样 
        mPresenter.getNetData();

//        GetXiaoHuaTask task = new GetXiaoHuaTask();
//        task.execute("desc", "1", "1");
//        Object desc = new ShangHaiDetailHttpTask().getXiaoHuaList("desc", "1", "1");
//
//        if(desc instanceof Response){
//            Response response = (Response) desc;
//            Log.e("initGetNetData", response.body().toString());
//        }

//        OkHttpClient client = new OkHttpClient();
//        Request request = new Request.Builder().url("http://www.baidu.com").get().build();
//        Call call = client.newCall(request);
//        call.enqueue(new Callback() {
//            @Override
//            public void onFailure(@NotNull Call call, @NotNull IOException e) {
//                Log.e("initGetNetData", "onFailure" + e);
//            }
//
//            @Override
//            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
//                Log.e("initGetNetData", "onResponse" + response.body().string());
//            }
//        });
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
