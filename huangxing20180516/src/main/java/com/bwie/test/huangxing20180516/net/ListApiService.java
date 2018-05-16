package com.bwie.test.huangxing20180516.net;


import com.bwie.test.huangxing20180516.Bean;

import io.reactivex.Observable;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ListApiService {
    @GET("nba/")
    Observable<Bean> getUrl(@Query("key") String key, @Query("num") int num);
    }

