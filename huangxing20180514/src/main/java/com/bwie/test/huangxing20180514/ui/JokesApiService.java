package com.bwie.test.huangxing20180514.ui;

import com.bwie.test.huangxing20180514.bean.JokesBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface JokesApiService {

    @FormUrlEncoded
    @POST("quarter/getJokes")
    Observable<JokesBean> DuanZi(@Field("page") String page);
}
