package com.bwie.test.huangxing20180514.base;

public interface BaseContract {


    interface BasePresenter<T extends BaseView> {
        void attchView(T view);
        void detachView();
    }

    //抽取所有View的共性，比如显示进度条和关闭进度
    interface BaseView {
        void showLoading();
        void dismissLoading();
    }
}
