package com.example.todayinformation.main.shanghai.lf;


import com.example.mvp.mvp.ILifeCircle;
import com.example.mvp.mvp.IMvpView;
import com.example.mvp.mvp.MvpControler;

public interface IShanghaiDetailContract {

    interface Iview extends IMvpView {


    }

    interface IPresenter extends ILifeCircle {

        void getNetData();
    }

    IShanghaiDetailContract.Iview emptyView = new IShanghaiDetailContract.Iview() {


        @Override
        public MvpControler getMvpControler() {
            return null;
        }
    };
}
