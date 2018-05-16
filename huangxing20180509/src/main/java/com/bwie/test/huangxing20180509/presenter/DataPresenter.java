package com.bwie.test.huangxing20180509.presenter;

import com.bwie.test.huangxing20180509.model.DataBean;

import java.util.List;

/**
 * Created by Galaxy on 2018/5/9.
 */

public interface DataPresenter {

    void Success(List<DataBean.NewslistBean> list);
    void Error();

}
