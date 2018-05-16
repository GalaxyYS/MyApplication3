package com.bwie.test.huangxing20180514.ui;

import com.bwie.test.huangxing20180514.base.BasePresenter;
import com.bwie.test.huangxing20180514.bean.JokesBean;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class JokesPresenter extends BasePresenter<JokesContract.View> implements
        JokesContract.Presenter {
    JokesApi jokesApi;

    @Inject
    public JokesPresenter(JokesApi jokesApi) {
        this.jokesApi = jokesApi;
    }

    @Override
    public void getJokes(String page) {

        jokesApi.getJokes(page)
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
