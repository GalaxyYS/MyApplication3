package com.bwie.test.huangxing20180516.ui;

import com.bwie.test.huangxing20180516.net.ListApi;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;

public class ListPresenter extends BasePresenter<ListContract.View> implements
        ListContract.Presenter {
    ListApi listApi;


    @Inject
    public ListPresenter(ListApi listApi) {
        this.listApi = listApi;
    }



    @Override
    public void getDuanzi(String page) {

        listApi(page)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<JokesBean>() {

                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(JokesBean jokesBean) {
                        mView.getJokesSuccess(jokesBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
