package com.bwie.test.huangxing20180514.module;


import com.bwie.test.huangxing20180514.net.MyInterceptor;
import com.bwie.test.huangxing20180514.ui.JokesApi;
import com.bwie.test.huangxing20180514.ui.JokesApiService;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class HttppModule {

    @Provides
    OkHttpClient.Builder provideOkHttpClientBuilder() {
        return new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS);

    }

    @Provides
    JokesApi provideJokesApi(OkHttpClient.Builder builder) {
        builder.addInterceptor(new MyInterceptor());
        JokesApiService jokesService = new Retrofit.Builder()
                .baseUrl("https://www.zhaoapi.cn/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(builder.build())
                .build()
                .create(JokesApiService.class);

        return JokesApi.getJokesApi(jokesService);
    }
}
