package com.bwie.test.huangxing20180516.ui;

public class BaseContract {


    interface  BasePresenter<T extends BaseView>{

        void  attachView(T view);

        void  detachView();

    }

    interface  BaseView{

        void  showLoading();
        void  dismissLoading();
    }

}
