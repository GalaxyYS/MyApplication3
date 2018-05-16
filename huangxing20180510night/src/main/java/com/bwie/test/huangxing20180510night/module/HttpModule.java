package com.bwie.test.huangxing20180510night.module;

import com.bwie.test.huangxing20180510night.net.AdApi;
import com.bwie.test.huangxing20180510night.net.AdApiService;
import com.bwie.test.huangxing20180510night.net.Api;
import com.bwie.test.huangxing20180510night.net.CatagoryApi;
import com.bwie.test.huangxing20180510night.net.CatagoryApiService;
import com.bwie.test.huangxing20180510night.net.ListApi;
import com.bwie.test.huangxing20180510night.net.ListApiService;
import com.bwie.test.huangxing20180510night.net.ProductCatagoryApi;
import com.bwie.test.huangxing20180510night.net.ProductCatagoryApiService;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Galaxy on 2018/5/10.
 */


@Module
public class HttpModule {

    @Provides
    OkHttpClient.Builder provideOkHttpClientBuilder(){
        return new OkHttpClient.Builder()
                .writeTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS);
    }

    @Provides
    AdApi  provideAdApi(OkHttpClient.Builder builder){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASEURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();
        AdApiService adApiService = retrofit.create(AdApiService.class);
        return AdApi.getAdApi(adApiService);

    }

    @Provides
    CatagoryApi providerCatagoryApi(OkHttpClient.Builder builder){

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(Api.BASEURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();

        CatagoryApiService catagoryApiService=retrofit.create(CatagoryApiService.class);
        return  CatagoryApi.getCatagoryApi(catagoryApiService);
    }


    @Provides
    ProductCatagoryApi provideProductCatagoryApi(OkHttpClient.Builder builder) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASEURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();
        ProductCatagoryApiService productCatagoryApiService = retrofit.create(ProductCatagoryApiService.class);
        return ProductCatagoryApi.getProductCatagoryApi(productCatagoryApiService);
    }

    @Provides
    ListApi provideListApi(OkHttpClient.Builder builder) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASEURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();
        ListApiService listApiService = retrofit.create(ListApiService.class);
        return ListApi.getListApi(listApiService);
    }
}
