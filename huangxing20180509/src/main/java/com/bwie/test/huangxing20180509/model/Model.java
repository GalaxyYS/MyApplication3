package com.bwie.test.huangxing20180509.model;

import com.bwie.test.huangxing20180509.presenter.DataPresenter;
import com.bwie.test.huangxing20180509.util.OkhtttpUtils;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by Galaxy on 2018/5/9.
 */

public class Model implements InterM {
    @Override
    public void getData(String url, final DataPresenter presenter) {


        OkhtttpUtils.doGet(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();

                Gson gson = new Gson();
                DataBean dataBean = gson.fromJson(json, DataBean.class);
                List<DataBean.NewslistBean> list = dataBean.getNewslist();
                presenter.Success(list);

            }
        });
    }
}
