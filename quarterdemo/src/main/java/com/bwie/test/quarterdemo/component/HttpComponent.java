package com.bwie.test.quarterdemo.component;

import com.bwie.test.quarterdemo.module.HttpModule;
import com.bwie.test.quarterdemo.ui.joke.MainActivity;

import dagger.Component;

/**
 * Created by Galaxy on 2018/5/12.
 */


@Component(modules = HttpModule.class)
public interface HttpComponent {

    void  intject(MainActivity  mainActivity);
}
