package com.bwie.test.huangxing20180508_test;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by Galaxy on 2018/5/8.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

       Fresco.initialize(this);
    }
}
