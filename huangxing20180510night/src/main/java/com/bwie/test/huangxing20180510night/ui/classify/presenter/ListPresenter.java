package com.bwie.test.huangxing20180510night.ui.classify.presenter;

import com.bwie.test.huangxing20180510night.bean.ProductsBean;
import com.bwie.test.huangxing20180510night.net.ListApi;
import com.bwie.test.huangxing20180510night.ui.base.BasePresenter;
import com.bwie.test.huangxing20180510night.ui.classify.contract.ListContract;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class ListPresenter extends BasePresenter<ListContract.View> implements  ListContract.Presenter{
    private ListApi listApi;

    @Inject
    public ListPresenter(ListApi listApi) {
        this.listApi = listApi;
    }

    @Override
    public void getProducts(String pscid) {
        listApi.getProduct(pscid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Function<ProductsBean, List<ProductsBean.DataBean>>() {
                    @Override
                    public List<ProductsBean.DataBean> apply(ProductsBean productsBean) throws Exception {
                        return productsBean.getData();
                    }
                }).subscribe(new Consumer<List<ProductsBean.DataBean>>() {
            @Override
            public void accept(List<ProductsBean.DataBean> dataBeans) throws Exception {
                if (mView != null) {
                    mView.onSuccess(dataBeans);
                }
            }
        });

    }
}
