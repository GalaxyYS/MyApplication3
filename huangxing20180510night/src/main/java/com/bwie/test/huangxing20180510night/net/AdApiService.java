package com.bwie.test.huangxing20180510night.net;

import com.bwie.test.huangxing20180510night.bean.AdBean;


import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by Galaxy on 2018/5/10.
 */

public interface AdApiService {

    @GET("ad/getAd")
    Observable<AdBean> getAd();
}
