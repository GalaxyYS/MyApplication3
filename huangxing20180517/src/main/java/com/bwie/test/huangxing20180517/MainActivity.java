package com.bwie.test.huangxing20180517;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bwie.test.huangxing20180517.bean.ProductBean;
import com.bwie.test.huangxing20180517.component.DaggerHttpComponent;
import com.bwie.test.huangxing20180517.module.HttpModule;
import com.bwie.test.huangxing20180517.ui.base.BaseActivity;
import com.bwie.test.huangxing20180517.ui.contract.ListContract;
import com.bwie.test.huangxing20180517.ui.contract.ListPresenter;
import com.bwie.test.huangxing20180517.ui.contract.MyAdapter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity <ListPresenter> implements ListContract.View {

    private RecyclerView rev;
    private int pscid;
    private boolean isRefresh = true;
    private MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        initView();

    }
    private void initView() {
       rev=findViewById(R.id.rev);
        //设置布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rev.setLayoutManager(linearLayoutManager);

        //设置刷新和加载更多监听


    }
    @Override
    public int getContentLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void inject() {
        DaggerHttpComponent.builder()
                .httpModule(new HttpModule())
                .build()
                .inject(this);
    }



    @Override
    public void onSuccess(List<ProductBean> list) {
        rev.setAdapter(adapter);
    }
}
