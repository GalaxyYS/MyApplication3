package com.bwie.test.quarterdemo.ui.joke.presenter;

import com.bwie.test.quarterdemo.bean.JokeBean;
import com.bwie.test.quarterdemo.net.JokeApi;
import com.bwie.test.quarterdemo.ui.base.BaseContract;
import com.bwie.test.quarterdemo.ui.base.BasePresenter;
import com.bwie.test.quarterdemo.ui.joke.contract.JokeContract;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Galaxy on 2018/5/12.
 */

public class JokePresenter extends BasePresenter<JokeContract.View> implements JokeContract.Presenter{


    private JokeApi  jokeApi;

    @Inject
    public JokePresenter(JokeApi jokeApi) {
        this.jokeApi = jokeApi;
    }





    @Override
    public void getjoke(String page) {

        jokeApi.getjoke(page)
                .observeOn(AndroidSchedulers.mainThread())
                .observeOn(Schedulers.io())
                .subscribe(new Observer<JokeBean>(){


                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(JokeBean jokeBean) {

                        mView.getJokeSuccess(jokeBean);
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
