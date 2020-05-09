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

import com.example.ipc.CallBack;
import com.example.ipc.IpcManager;
import com.example.ipc.requst.IpcRequest;
import com.example.ipc.result.IResult;
import com.example.todayinformation.R;
import com.example.todayinformation.base.BaseActivity;
import com.example.todayinformation.base.Viewinject;
import com.example.todayinformation.main.shanghai.dto.ShangHaiDetailBean;
import com.example.todayinformation.main.shanghai.lf.IShanghaiDetailContract;
import com.example.todayinformation.main.shanghai.manager.GetXiaoHuaTask;
import com.example.todayinformation.main.shanghai.module.ShangHaiDetailHttpTask;
import com.example.todayinformation.main.shanghai.presenter.ShanghaiDetailPresenter;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import butterknife.BindView;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
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
        initIpc();
    }

    private void initIpc() {
        IpcRequest request = new IpcRequest("shanghaiDetail");
        IpcManager.getInstance(this).excuteAsync(request, new CallBack() {
            @Override
            public void callBack(IResult result) {
                String data = result.data();
                Log.e("数据请求", data);
            }
        });
    }

    private void initPostNetData() {

    }

    //发送网络请求数据
    private void initGetNetData() {
        // TODO: 2020/4/26 和老师的不一样 
        //mPresenter.getNetData();

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
        OkHttpClient client = new OkHttpClient(); // okhttp 配置一些默认
        //2、构建请求 1）url 2）参数
        HttpUrl.Builder builder = HttpUrl.parse("https://www.baidu.com").newBuilder();
//        builder.addQueryParameter("sort", "desc");
//        builder.addQueryParameter("page", "1");
//        builder.addQueryParameter("pagesize", "1");
//        builder.addQueryParameter("time", "" + System.currentTimeMillis()/1000);
//        builder.addQueryParameter("key", "bbc57dd5e4f05991aff09eafd2e667e0");
        //3、构建Request
        Request request = new Request.Builder()
                .url(builder.build())
                .get()
                .build(); //建造者设计模式
        //4、构建Call
        Call call = client.newCall(request);
        //5 执行网络请求
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("initGetNetData","onFailure" + e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.e("initGetNetData","onResponse" + response.body().string());
            }
        });
    }

    private void initAnima() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            //ViewCompat.setTransitionName(ivShanghaiDetail, mActivityOptionsCompat);
            //开启转场动画
            startPostponedEnterTransition();
        }
    }

    //用于Android5.0系统的界面转场动画：共享元素动画
    public static void start_5_0(Activity activity, View view){

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            Intent intent = new Intent(activity, ShanghaiDetailActivity.class);
            Pair pair = new Pair(view, mActivityOptionsCompat);
            ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(activity, pair);
            ActivityCompat.startActivity(activity, intent, optionsCompat.toBundle());
        }
    }

    @Override
    public void showData(ShangHaiDetailBean data) {

    }
}
