package com.bwie.test.huangxing20180516.ui;

import com.bwie.test.huangxing20180516.Bean;

import java.util.List;

public interface ListContract {

    interface View extends BaseContract.BaseView {
        void onSuccess(List<Bean.NewslistBean> list);
    }

    interface Presenter extends BaseContract.BasePresenter<View> {
        void getDuanzi(String page);
    }
}
