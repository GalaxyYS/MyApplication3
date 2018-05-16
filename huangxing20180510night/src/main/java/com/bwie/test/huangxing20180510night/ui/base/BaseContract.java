package com.bwie.test.huangxing20180510night.ui.base;

/**
 * Created by Galaxy on 2018/5/10.
 */

public interface BaseContract {

    interface  BasePresenter<T extends BaseView>{

        void  attachView(T view);

        void  detachView();

    }

    interface  BaseView{

        void  showLoading();
        void  dismissLoading();
    }

}
