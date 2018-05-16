package com.bwie.test.huangxing20180509.view;

import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bwie.test.huangxing20180509.R;
import com.bwie.test.huangxing20180509.model.DataBean;
import com.bwie.test.huangxing20180509.presenter.MyDataPersenter;
import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.List;

public class MainActivity extends AppCompatActivity implements DataView {



    private RecyclerView my_rcv;
    String url = "https://api.tianapi.com/wxnew/?key=fe7aac932e1e94f10a4f8d0f2d5fe924&num=10";
    private MyAdapter myAdapter;
    private List<DataBean.NewslistBean> list;

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            list = (List<DataBean.NewslistBean>) msg.obj;
            myAdapter = new MyAdapter(MainActivity.this, list);
            my_rcv.setAdapter(myAdapter);


        }
    };
    private SwipeRefreshLayout my_srl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fresco.initialize(this);
        setContentView(R.layout.activity_main);

        //找到资源控件的ID
        my_rcv = findViewById(R.id.my_rev);

        my_rcv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        //初始化P层，将url和本类传过去
        MyDataPersenter persenter = new MyDataPersenter(this);
        persenter.netWork(url);
    }

    @Override
    public void toBackHome(List<DataBean.NewslistBean> list) {


        Message msg = new Message();
        msg.obj=list;
        handler.sendMessage(msg);
    }
}
