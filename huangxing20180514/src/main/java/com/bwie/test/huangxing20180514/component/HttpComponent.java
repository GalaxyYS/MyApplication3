package com.bwie.test.huangxing20180514.component;

import com.bwie.test.huangxing20180514.MainActivity;
import com.bwie.test.huangxing20180514.module.HttppModule;

import dagger.Component;
import dagger.Module;


@Component(modules = HttppModule.class)
public interface HttpComponent {



    void inject(MainActivity mainActivity);
}
