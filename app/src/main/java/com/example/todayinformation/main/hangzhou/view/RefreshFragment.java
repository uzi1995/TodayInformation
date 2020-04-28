package com.example.todayinformation.main.hangzhou.view;



import com.example.refresh.GodRefreshLayout;
import com.example.todayinformation.R;
import com.example.todayinformation.base.BaseFragment;
import com.example.todayinformation.base.Viewinject;
import com.example.todayinformation.main.hangzhou.refresh.MeiTuanRefreshManager;
import com.example.todayinformation.main.shanghai.dto.ShangHaiDetailBean;
import com.example.todayinformation.main.shanghai.lf.IShanghaiDetailContract;
import com.example.todayinformation.main.shanghai.presenter.ShanghaiDetailPresenter;

import butterknife.BindView;



@Viewinject(mainlayoutid = R.layout.fragment_refresh)
public class RefreshFragment extends BaseFragment implements IShanghaiDetailContract.Iview{

    IShanghaiDetailContract.IPresenter mPresenter = new ShanghaiDetailPresenter(this);

    @BindView(R.id.god_refresh)
    GodRefreshLayout godRefresh;
//    @BindView(R.id.refresh_recyclerview)
//    RecyclerView mRecyclerView;

    @Override
    public void afterBindView() {
        initRecyclerView();
        initRefreshLayout();

    }

    private void initRefreshLayout() {
        //1、采用默认的方式
        //godRefresh.setRefreshManager();
        //2、要支持用户自定义
        godRefresh.setRefreshManager(new MeiTuanRefreshManager(mContext));
        godRefresh.setRefreshListener(new GodRefreshLayout.RefreshingListener() {
            @Override
            public void onRefreshing() {
                //mPresenter.getNetData(20);
                godRefresh.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        godRefresh.refreshOver();
                    }
                }, 2000);
            }
        });
    }

    private void initRecyclerView() {
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
//        mPresenter.getNetData(20);
    }

    @Override
    public void showData(ShangHaiDetailBean data) {
//        if (mRecyclerView.getAdapter() == null) {
//            ZhiHuAdapter adapter = new ZhiHuAdapter(data.result.data);
//            mRecyclerView.setAdapter(adapter);
//        }
//        godRefresh.refreshOver();
    }
}
