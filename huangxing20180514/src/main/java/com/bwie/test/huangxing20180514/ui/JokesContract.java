package com.bwie.test.huangxing20180514.ui;

import com.bwie.test.huangxing20180514.base.BaseContract;
import com.bwie.test.huangxing20180514.bean.JokesBean;

public class JokesContract {

    public interface View extends BaseContract.BaseView {
        void getJokesSuccess(JokesBean duanZiBean);
    }

    public interface Presenter extends BaseContract.BasePresenter<View> {
        void getJokes(String page);
    }
}
