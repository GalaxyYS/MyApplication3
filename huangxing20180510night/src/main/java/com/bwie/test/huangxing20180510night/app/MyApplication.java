package com.bwie.test.huangxing20180510night.app;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by Galaxy on 2018/5/10.
 */

public class MyApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();

        Fresco.initialize(this);

        //初始化Zxing库

       // ZXingLibrary.initDisplayOpinion(this);
    }
}
