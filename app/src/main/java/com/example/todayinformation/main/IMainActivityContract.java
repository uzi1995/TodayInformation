package com.example.todayinformation.main;


import androidx.fragment.app.Fragment;

import com.example.annotation.MvpEmptyViewFactory;
import com.example.mvp.mvp.ILifeCircle;
import com.example.mvp.mvp.IMvpView;


public interface IMainActivityContract {


    @MvpEmptyViewFactory
    interface Iview extends IMvpView {

        void showFragment(Fragment mFragment);

        void addFragment(Fragment mFragment);

        void hideFragment(Fragment mFragment);
    }

    interface IPresenter extends ILifeCircle {
        void initHomeFragment();

        int getCurrentCheckedId();

        void replaceFragment(int mCurrentFragmentIndex);

        int getCurrentCheckedIndex();

        int getTopPosition();

        int getBottomPosition();
    }

//    Iview emptyView = new Iview() {
//
//        @Override
//        public void showFragment(Fragment mFragment){
//
//        }
//
//        @Override
//        public void addFragment(Fragment mFragment){
//
//        }
//
//        @Override
//        public void hideFragment(Fragment mFragment) {
//
//        }
//
//        @Override
//        public MvpControler getMvpControler() {
//            return null;
//        }
//    };
}
