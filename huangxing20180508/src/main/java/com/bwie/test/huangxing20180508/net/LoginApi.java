package com.bwie.test.huangxing20180508.net;

import com.bwie.test.huangxing20180508.bean.LoginBean;

import io.reactivex.Observable;

/**
 * Created by Galaxy on 2018/5/8.
 */

public class LoginApi {


    private static LoginApi loginApi;
    private LoginApiService loginApiService;

    private LoginApi(LoginApiService loginApiService) {
        this.loginApiService = loginApiService;
    }

    public static LoginApi getLoginApi(LoginApiService loginApiService) {
        if (loginApi == null) {
            loginApi = new LoginApi(loginApiService);
        }
        return loginApi;
    }

    public Observable<LoginBean> login(String mobile, String password) {
        return loginApiService.login(mobile, password);
    }
}
