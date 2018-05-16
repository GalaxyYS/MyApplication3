package com.bwie.test.huangxing20180510night.component;

import com.bwie.test.huangxing20180510night.module.HttpModule;
import com.bwie.test.huangxing20180510night.ui.classify.ClassifyFragment;
import com.bwie.test.huangxing20180510night.ui.classify.ListActivity;
import com.bwie.test.huangxing20180510night.ui.homepage.HomePageFragment;

import dagger.Component;

/**
 * Created by Galaxy on 2018/5/10.
 */

@Component (modules= HttpModule.class)
public interface HttpComponent {

    void inject(HomePageFragment homePageFragment);

    void  inject(ClassifyFragment classifyFragment);

    void inject(ListActivity listActivity);
}
