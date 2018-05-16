package com.bwie.test.huangxing20180514;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import com.bwie.test.huangxing20180514.base.BaseActivity;
import com.bwie.test.huangxing20180514.bean.JokesBean;
import com.bwie.test.huangxing20180514.component.DaggerHttpComponent;
import com.bwie.test.huangxing20180514.module.HttppModule;
import com.bwie.test.huangxing20180514.ui.JokesContract;
import com.bwie.test.huangxing20180514.ui.JokesPresenter;
import com.bwie.test.huangxing20180514.ui.MyAdapter;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity<JokesPresenter> implements JokesContract.View {


    private int num = 1;
    private XRecyclerView mRecyclerDuanzi;
    boolean falg = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        getSupportActionBar().hide();
        initView();

        mRecyclerDuanzi.setPullRefreshEnabled(true);
        mRecyclerDuanzi.setLoadingMoreEnabled(true);
        mRecyclerDuanzi.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        mRecyclerDuanzi.setLoadingMoreProgressStyle(ProgressStyle.Pacman);
    }

    private void initView() {

        mRecyclerDuanzi = (XRecyclerView) findViewById(R.id.recycler_duanzi);
        //请求数据
        initData();
    }

    private void initData() {
        mPresenter.getJokes(String.valueOf(101));
    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void inject() {
        DaggerHttpComponent.builder()
                .httppModule(new HttppModule())
                .build()
                .inject(this);
    }

    @Override
    public void getJokesSuccess(JokesBean duanZiBean) {

        final List<JokesBean.DataBean> duanZiBeans = new ArrayList<>();

        List<JokesBean.DataBean> data = duanZiBean.getData();
        duanZiBeans.addAll(data);
        mRecyclerDuanzi.setLayoutManager(new LinearLayoutManager(MainActivity.this,
                LinearLayoutManager.VERTICAL,false));
        MyAdapter adapter = new MyAdapter(MainActivity.this,duanZiBeans);
        mRecyclerDuanzi.setAdapter(adapter);

        mRecyclerDuanzi.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                mPresenter.getJokes(num+"");
                mRecyclerDuanzi.refreshComplete();
                duanZiBeans.clear();
                Toast.makeText(MainActivity.this, "刷新成功", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLoadMore() {
                num++;
                mPresenter.getJokes(num+"");
                mRecyclerDuanzi.refreshComplete();
                Toast.makeText(MainActivity.this, "加载成功", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
