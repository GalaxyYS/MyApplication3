package com.bwie.test.huangxing20180514.app;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

public class MyApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();

        Fresco.initialize(this);
    }
}
