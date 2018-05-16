package com.bwie.test.huangxing20180516.net;

import com.bwie.test.huangxing20180516.Bean;

import io.reactivex.Observable;

public class ListApi {

    private static ListApi listApi;
    private ListApiService listApiService;

    private ListApi(ListApiService listApiService) {
        this.listApiService = listApiService;
    }

    public static ListApi getListApi(ListApiService listApiService) {
        if (listApi == null) {
            listApi = new ListApi(listApiService);
        }
        return listApi;
    }


}
