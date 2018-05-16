package com.bwie.test.huangxing20180508.net;

import com.bwie.test.huangxing20180508.bean.LoginBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Galaxy on 2018/5/8.
 */

public interface LoginApiService {


    @FormUrlEncoded
    @POST("user/login")
    Observable<LoginBean> login(@Field("mobile") String mobile,
                                @Field("password") String password);
}
