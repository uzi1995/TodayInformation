package com.example.todayinformation.main;


import androidx.fragment.app.Fragment;

import com.example.todayinformation.R;
import com.example.todayinformation.main.shanghai.BeiJingFragment;
import com.example.todayinformation.main.shanghai.HangZhouFragment;
import com.example.todayinformation.main.shanghai.ShangHaiFragment;
import com.example.todayinformation.main.shanghai.ShenZhenFragment;
import com.example.todayinformation.mvp.base.BaseMvpPresenter;

public class MainActivityPresenter extends BaseMvpPresenter<IMainActivityContract.Iview> implements IMainActivityContract.IPresenter{

    //当前fragment的角标
    private int mCurrentFragmentIndex;
    private Fragment[] mFragments = new Fragment[4];
    private int mCurrentCheckedId;
    private int mTopPosition;
    private int mBottomPosition;


    public MainActivityPresenter(IMainActivityContract.Iview view) {
        super(view);
    }

    @Override
    protected IMainActivityContract.Iview getEmptyView() {
        return IMainActivityContract.emptyView;
    }

    @Override
    public void initHomeFragment() {
        mCurrentFragmentIndex = 0;
        replaceFragment(mCurrentFragmentIndex);
    }

    @Override
    public int getCurrentCheckedId() {
        return mCurrentCheckedId;
    }


    //切换fragment的方法
    @Override
    public void replaceFragment(int mCurrentFragmentIndex) {
        for(int i = 0; i < mFragments.length; i++){
            if(mCurrentFragmentIndex != i){
                if(mFragments[i] != null){
                    hideFragment(mFragments[i]);
                }
            }
        }
        Fragment mFragment = mFragments[mCurrentFragmentIndex];
        if(mFragment != null){
            addAndShowFragment(mFragment);
            setCurChecked(mCurrentFragmentIndex);
        }else{
            newCurrentFragment(mCurrentFragmentIndex);
            setCurChecked(mCurrentFragmentIndex);
        }
    }

    @Override
    public int getCurrentCheckedIndex() {
        return mCurrentFragmentIndex;
    }

    @Override
    public int getTopPosition() {
        return mTopPosition;
    }

    @Override
    public int getBottomPosition() {
        return mBottomPosition;
    }

    //记录当前角标
    private void setCurChecked(int mCurrentFragmentIndex) {
        this.mCurrentFragmentIndex = mCurrentFragmentIndex;
        switch(mCurrentFragmentIndex){
            case 0:
                mCurrentCheckedId = R.id.rb_main_shanghai;
                mTopPosition = 0;
                break;
            case 1:
                mCurrentCheckedId = R.id.rb_main_hangzhou;
                mTopPosition = 1;
                break;
            case 2:
                mCurrentCheckedId = R.id.rb_main_nav_home_beijing;
                mBottomPosition = 2;
                break;
            case 3:
                mCurrentCheckedId = R.id.rb_main_nav_car_source_shenzhen;
                mBottomPosition = 3;
                break;
        }

    }

    //创建当前fragment
    private void newCurrentFragment(int mCurrentFragmentIndex) {
        Fragment fragment = null;
        switch(mCurrentFragmentIndex){
            case 0:
                fragment = new ShangHaiFragment();
                break;
            case 1:
                fragment = new HangZhouFragment();
                break;
            case 2:
                fragment = new BeiJingFragment();
                break;
            case 3:
                fragment = new ShenZhenFragment();
                break;
        }
        mFragments[mCurrentFragmentIndex] = fragment;
        addAndShowFragment(fragment);
    }

    //显示fragment
    private void addAndShowFragment(Fragment mFragment) {
        if(mFragment.isAdded()){
            getView().showFragment(mFragment);
        }else{
            getView().addFragment(mFragment);
        }
    }

    //隐藏fragment
    private void hideFragment(Fragment mFragment) {
        if(mFragment != null && mFragment.isVisible()){
            getView().hideFragment(mFragment);
        }
    }
}
