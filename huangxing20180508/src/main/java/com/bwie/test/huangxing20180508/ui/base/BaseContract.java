package com.bwie.test.huangxing20180508.ui.base;

/**
 * Created by Galaxy on 2018/5/8.
 */

public interface BaseContract {


    //抽取presenter 共性

    interface  BasePresenter<T  extends  BaseView>{

        void  attachView(T  view);
        void  detachView();
    }


    interface  BaseView{

        void  showLoading();
        void  dismissLoading();
    }
}
