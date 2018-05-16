package com.bwie.test.huangxing20180510night.net;

import com.bwie.test.huangxing20180510night.bean.CatagoryBean;

import io.reactivex.Observable;

/**
 * Created by Galaxy on 2018/5/10.
 */

public class CatagoryApi {

    private static CatagoryApi catagoryApi;
    private CatagoryApiService catagoryApiService;

    private CatagoryApi(CatagoryApiService catagoryApiService) {
        this.catagoryApiService = catagoryApiService;
    }

    public static CatagoryApi getCatagoryApi(CatagoryApiService catagoryApiService) {
        if (catagoryApi == null) {
            catagoryApi = new CatagoryApi(catagoryApiService);
        }
        return catagoryApi;
    }

    public Observable<CatagoryBean> getCatagory() {
        return catagoryApiService.getCatagory();
    }
    }

