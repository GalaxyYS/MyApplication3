package com.bwie.test.huangxing20180509.presenter;

import com.bwie.test.huangxing20180509.model.DataBean;
import com.bwie.test.huangxing20180509.model.Model;
import com.bwie.test.huangxing20180509.view.DataView;

import java.util.List;

/**
 * Created by Galaxy on 2018/5/9.
 */

public class MyDataPersenter implements  DataPresenter{

    //创建构造器
    DataView dataView;
    private final Model model;
    public MyDataPersenter(DataView dataView) {
        this.dataView=dataView;
        model = new Model();
    }

    //成功的方法
    @Override
    public void Success(List<DataBean.NewslistBean> list) {
        //调用V层接收数据的方法
        dataView.toBackHome(list);
    }

    //失败的方法
    @Override
    public void Error() {}

    //接收url
    public void netWork(String url){
        //调用M层请求数据的方法
        model.getData(url,this);
    }
}
