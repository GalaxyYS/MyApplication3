package com.bwie.test.huangxing20180516.component;

import com.bwie.test.huangxing20180516.MainActivity;
import com.bwie.test.huangxing20180516.module.HttpModule;

import dagger.Component;

@Component(modules = HttpModule.class)
public interface HttpComponent {

    void inject(MainActivity mainActivity);
}
