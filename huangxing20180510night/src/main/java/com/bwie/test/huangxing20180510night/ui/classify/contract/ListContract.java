package com.bwie.test.huangxing20180510night.ui.classify.contract;

import com.bwie.test.huangxing20180510night.bean.ProductsBean;
import com.bwie.test.huangxing20180510night.ui.base.BaseContract;

import java.util.List;

public interface ListContract {

    interface  View  extends BaseContract.BaseView{

        void  onSuccess(List<ProductsBean.DataBean> dataBeans);
    }

    interface  Presenter  extends  BaseContract.BasePresenter<View>{

        void  getProducts(String  pscid);
    }
}
