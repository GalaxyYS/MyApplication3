package com.bwie.test.huangxing20180510night.ui.classify.contract;

import com.bwie.test.huangxing20180510night.bean.CatagoryBean;
import com.bwie.test.huangxing20180510night.bean.ProductCatagoryBean;
import com.bwie.test.huangxing20180510night.ui.base.BaseContract;

public interface ClassifyContract {

    interface View extends BaseContract.BaseView {
        void getProductCatagorySuccess(ProductCatagoryBean productCatagoryBean);

        void getCatagorySuccess(CatagoryBean catagoryBean);
    }

    interface Presenter extends BaseContract.BasePresenter<View> {
        void getProductCatagory(String cid);

        void getCatagory();
    }
}
