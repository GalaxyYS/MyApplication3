package com.bwie.test.huangxing20180510night.net;

import com.bwie.test.huangxing20180510night.bean.AdBean;

import io.reactivex.Observable;


/**
 * Created by Galaxy on 2018/5/10.
 */

public class AdApi {

    private static AdApi adApi;
    private AdApiService adApiService;

    private AdApi(AdApiService adApiService) {
        this.adApiService = adApiService;
    }

    public static AdApi getAdApi(AdApiService adApiService) {
        if (adApi == null) {
            adApi = new AdApi(adApiService);
        }
        return adApi;
    }

    public Observable<AdBean> getAd() {
        return adApiService.getAd();
    }
}
