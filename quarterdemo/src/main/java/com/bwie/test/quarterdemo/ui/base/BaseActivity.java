package com.bwie.test.quarterdemo.ui.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.bwie.test.quarterdemo.inter.IBase;

import javax.inject.Inject;

/**
 * Created by Galaxy on 2018/5/12.
 */

public  abstract class BaseActivity<T  extends BaseContract.BasePresenter> extends AppCompatActivity implements IBase,BaseContract.BaseView{


    @Inject
    protected  T mPresenter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        inject();

        if(mPresenter!=null){
            mPresenter.attachView(this);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        mPresenter.detachView();
    }

    @Override
    public void initView(View view) {


    }

    @Override
    public void showLoading() {

    }

    @Override
    public void dismissLoading() {

    }
}
