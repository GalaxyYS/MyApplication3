package com.bwie.test.huangxing20180514.ui;

import com.bwie.test.huangxing20180514.bean.JokesBean;

import io.reactivex.Observable;

public class JokesApi {

    private static JokesApi jokesApi;
    private JokesApiService jokesApiService;

    private JokesApi(JokesApiService jokesService) {
        this.jokesApiService = jokesService;
    }

    public static JokesApi getJokesApi(JokesApiService jokesService) {
        if (jokesApi == null) {
            jokesApi = new JokesApi(jokesService);
        }
        return jokesApi;
    }

    public Observable<JokesBean> getJokes(String page) {
        return jokesApiService.DuanZi(page);
    }
}
