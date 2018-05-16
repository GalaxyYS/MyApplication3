package com.bwie.test.quarterdemo.ui.joke.contract;

import com.bwie.test.quarterdemo.bean.JokeBean;
import com.bwie.test.quarterdemo.ui.base.BaseContract;

/**
 * Created by Galaxy on 2018/5/12.
 */

public interface JokeContract {

    interface  View  extends BaseContract.BaseView{

        void  getJokeSuccess(JokeBean jokeBean);
    }

    interface Presenter extends BaseContract.BasePresenter<View>{

        void  getjoke(String  page);
    }
}
