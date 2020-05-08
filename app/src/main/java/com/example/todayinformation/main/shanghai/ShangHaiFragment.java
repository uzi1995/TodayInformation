package com.example.todayinformation.main.shanghai;


import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todayinformation.R;
import com.example.todayinformation.base.BaseFragment;
import com.example.todayinformation.base.Viewinject;
import com.example.todayinformation.base.tools.AnimationUtil;
import com.example.todayinformation.base.tools.DoubleClickListener;
import com.example.todayinformation.main.shanghai.adapter.ShanghaiAdapter2;
import com.example.todayinformation.main.shanghai.lf.IPlayerServiceContract;
import com.example.todayinformation.main.shanghai.presenter.PlayerServicePresenter;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import butterknife.BindView;

@Viewinject(mainlayoutid = R.layout.fragment_shanghai)
public class ShangHaiFragment extends BaseFragment implements IPlayerServiceContract.Iview{

    IPlayerServiceContract.IPresenter mPresenter = new PlayerServicePresenter(this);

    @BindView(R.id.tv_shanghai_welcome)
    TextView tvShanghaiWelcome;
    @BindView(R.id.shanghai_collapsingtoolbarlayout)
    CollapsingToolbarLayout shanghaiCollapsingtoolbarlayout;
    @BindView(R.id.shanghai_app_barlayout)
    AppBarLayout shanghaiAppBarlayout;
    @BindView(R.id.shanghai_recyclerview)
    RecyclerView mRecyclerview;
    @BindView(R.id.tv_marquee_title)
    TextView mTvTitle;
    private boolean mIsPlaying;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void afterBindView() {
        initRecyclerView();
        initListener();
    }

    private void initRecyclerView() {
        mRecyclerview.setLayoutManager(new LinearLayoutManager(mContext));

//        mRecyclerview.setAdapter(new ShanghaiAdapter(getActivity(), ShanghaiDataManager.getData(), false));
        mRecyclerview.setAdapter(new ShanghaiAdapter2());
    }

    private void initListener() {
        shanghaiAppBarlayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                if (-i < appBarLayout.getMeasuredHeight() / 2) {
                    tvShanghaiWelcome.setVisibility(View.INVISIBLE);
                    mTvTitle.setVisibility(View.INVISIBLE);
                } else {
                    tvShanghaiWelcome.setVisibility(View.VISIBLE);
                    if (mIsPlaying) {
                        mTvTitle.setVisibility(View.VISIBLE);
                    }
                }
            }
        });
        tvShanghaiWelcome.setOnClickListener(new DoubleClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTvTitle.clearAnimation();
                tvShanghaiWelcome.clearAnimation();
                if (mIsPlaying) {
                    //关闭音视频动画
                    mTvTitle.setVisibility(View.GONE);
                    AnimationUtil.startTranslationXAnim(tvShanghaiWelcome,tvShanghaiWelcome.getTranslationX(),tvShanghaiWelcome.getTranslationX() + 150,null);
                    AnimationUtil.startTranslationXAnim(mTvTitle,mTvTitle.getTranslationX(),mTvTitle.getTranslationX() + 150,null);
                    mPresenter.playOrPaused();

                } else {
                    //播放音视频动画
                    AnimationUtil.startTranslationXAnim(tvShanghaiWelcome,tvShanghaiWelcome.getTranslationX(),tvShanghaiWelcome.getTranslationX() - 150,null);
                    AnimationUtil.startTranslationXAnim(mTvTitle, mTvTitle.getTranslationX(), mTvTitle.getTranslationX() - 150, new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            mTvTitle.setVisibility(View.VISIBLE);
                            //启动Service 去 播放后台音乐
                            mPresenter.bindService(mContext);
                        }
                    });
                }
                mIsPlaying = !mIsPlaying;
            }
        }));
    }
}
