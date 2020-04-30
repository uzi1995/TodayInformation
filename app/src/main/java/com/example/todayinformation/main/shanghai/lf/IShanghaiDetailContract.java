package com.example.todayinformation.main.shanghai.lf;


import com.example.annotation.MvpEmptyViewFactory;
import com.example.mvp.mvp.ILifeCircle;
import com.example.mvp.mvp.IMvpView;
import com.example.mvp.mvp.MvpControler;
import com.example.todayinformation.main.shanghai.dto.ShangHaiDetailBean;

public interface IShanghaiDetailContract {

    @MvpEmptyViewFactory
    interface Iview extends IMvpView {


        void showData(ShangHaiDetailBean data);
    }

    interface IPresenter extends ILifeCircle {

        void getNetData(int pagesize);
    }

//    IShanghaiDetailContract.Iview emptyView = new IShanghaiDetailContract.Iview() {
//
//        @Override
//        public void showData(ShangHaiDetailBean data){
//
//        }
//
//        @Override
//        public MvpControler getMvpControler() {
//            return null;
//        }
//    };
}
