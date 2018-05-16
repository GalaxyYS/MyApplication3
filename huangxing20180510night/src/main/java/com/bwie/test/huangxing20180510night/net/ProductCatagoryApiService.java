package com.bwie.test.huangxing20180510night.net;

import com.bwie.test.huangxing20180510night.bean.ProductCatagoryBean;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ProductCatagoryApiService {

    @FormUrlEncoded
    @POST("product/getProductCatagory")
    io.reactivex.Observable<ProductCatagoryBean> getProductCatagory(@Field("cid") String cid);
}
