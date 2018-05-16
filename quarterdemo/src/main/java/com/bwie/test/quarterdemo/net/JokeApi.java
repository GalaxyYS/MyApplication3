package com.bwie.test.quarterdemo.net;

import com.bwie.test.quarterdemo.bean.JokeBean;
import io.reactivex.Observable;

/**
 * Created by Galaxy on 2018/5/12.
 */

public class JokeApi {

    private static  JokeApi  jokeApi;
    private JokeApiService jokeApiService;

    public JokeApi(JokeApiService jokeApiService) {
        this.jokeApiService = jokeApiService;
    }

    public static  JokeApi jokeApi(JokeApiService jokeApiService){

        if(jokeApi==null){
            jokeApi=new JokeApi(jokeApiService);

        }

        return  jokeApi;


    }
    public Observable<JokeBean> getjoke(String page){


        return jokeApiService.getJoke(page);
    }
}

