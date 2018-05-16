package com.bwie.test.quarterdemo.ui.base;

/**
 * Created by Galaxy on 2018/5/12.
 */

public class BasePresenter <T  extends BaseContract.BaseView>  implements  BaseContract.BasePresenter<T>{

    protected   T  mView;


    @Override
    public void attachView(T view) {
        this.mView=view;
    }

    @Override
    public void detachView() {

        if(mView !=null){
            mView=null;
        }
    }
}
