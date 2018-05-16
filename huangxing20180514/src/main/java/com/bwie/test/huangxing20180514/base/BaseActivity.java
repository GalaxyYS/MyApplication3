package com.bwie.test.huangxing20180514.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.bwie.test.huangxing20180514.inter.IBase;

import javax.inject.Inject;

public abstract class BaseActivity <T extends BaseContract.BasePresenter> extends AppCompatActivity
        implements IBase, BaseContract.BaseView{


    @Inject
    protected T mPresenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentLayout());
        inject();
        //绑定
        mPresenter.attchView(this);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void dismissLoading() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //解绑
        mPresenter.detachView();
    }
}
