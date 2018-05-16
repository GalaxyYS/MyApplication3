package com.bwie.test.huangxing20180508.component;


import com.bwie.test.huangxing20180508.module.HttpModule;
import com.bwie.test.huangxing20180508.ui.login.LoginActivity;

import dagger.Component;

@Component(modules = HttpModule.class)
public interface HttpComponent {
    void inject(LoginActivity loginActivity);
}
