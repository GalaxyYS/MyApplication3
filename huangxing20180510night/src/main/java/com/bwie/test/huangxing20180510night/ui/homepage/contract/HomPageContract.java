package com.bwie.test.huangxing20180510night.ui.homepage.contract;


import com.bwie.test.huangxing20180510night.bean.AdBean;
import com.bwie.test.huangxing20180510night.bean.CatagoryBean;
import com.bwie.test.huangxing20180510night.ui.base.BaseContract;

public interface HomPageContract {
    interface View extends BaseContract.BaseView {
        void getAdSuccess(AdBean adBean);

        void getCatagorySuccess(CatagoryBean catagoryBean);
    }

    interface Presenter extends BaseContract.BasePresenter<View> {
        void getAd();

        void getCatagory();
    }

}
