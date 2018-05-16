package com.bwie.test.quarterdemo.ui.joke;

import android.icu.text.DateTimePatternGenerator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.bwie.test.quarterdemo.R;
import com.bwie.test.quarterdemo.bean.JokeBean;
import com.bwie.test.quarterdemo.component.DaggerHttpComponent;
import com.bwie.test.quarterdemo.inter.IBase;
import com.bwie.test.quarterdemo.module.HttpModule;
import com.bwie.test.quarterdemo.ui.base.BaseActivity;
import com.bwie.test.quarterdemo.ui.joke.contract.JokeContract;
import com.bwie.test.quarterdemo.ui.joke.presenter.JokePresenter;

import dagger.internal.DaggerCollections;

public class MainActivity extends BaseActivity<JokePresenter> implements JokeContract.View{


    private RecyclerView recv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        mPresenter.getjoke("1");

        recv=findViewById(R.id.recv);
    }

    @Override
    public int getContentLayoout() {
        return R.layout.activity_main;
    }

    @Override
    public void inject() {

        DaggerHttpComponent.builder()
                .httpModule(new HttpModule())
                .build()
                .intject(MainActivity.this);



    }

    @Override
    public void getJokeSuccess(JokeBean jokeBean) {

    }
}
