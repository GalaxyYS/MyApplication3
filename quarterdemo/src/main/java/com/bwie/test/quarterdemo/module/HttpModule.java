package com.bwie.test.quarterdemo.module;

import com.bwie.test.quarterdemo.net.Api;
import com.bwie.test.quarterdemo.net.JokeApi;
import com.bwie.test.quarterdemo.net.JokeApiService;
import com.bwie.test.quarterdemo.net.MyInterceptor;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Galaxy on 2018/5/12.
 */


@Module
public class HttpModule {

    @Provides
    OkHttpClient.Builder okhttpClientBuilder(){

        return new OkHttpClient.Builder()
                .writeTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20,TimeUnit.SECONDS)
                .connectTimeout(10,TimeUnit.SECONDS);
    }


    @Provides
    JokeApi  provideJokeApi(OkHttpClient.Builder builder){
        builder.addInterceptor( new MyInterceptor());
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(Api.BASEURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();


        JokeApiService jokeApiService = retrofit.create(JokeApiService.class);

        return JokeApi.jokeApi(jokeApiService);

    }
}
