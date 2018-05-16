package com.bwie.test.quarterdemo.net;

import com.bwie.test.quarterdemo.bean.JokeBean;


import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Galaxy on 2018/5/12.
 */

public interface JokeApiService {

    @FormUrlEncoded
    @POST("quarter/getJokes")
    Observable<JokeBean>  getJoke(@Field("page")String page);

}
