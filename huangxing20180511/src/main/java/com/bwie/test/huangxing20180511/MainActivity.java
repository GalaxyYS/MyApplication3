package com.bwie.test.huangxing20180511;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bwie.test.huangxing20180511.model.DataBean;
import com.bwie.test.huangxing20180511.presenter.MyDataPersenter;
import com.bwie.test.huangxing20180511.view.DataView;
import com.facebook.drawee.backends.pipeline.Fresco;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

public class MainActivity extends AppCompatActivity implements DataView,MyAdapter.OnClickListener{


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

            //调用适配器中的点击事件
            myAdapter.OnClick((MyAdapter.OnClickListener) MainActivity.this);
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
        my_rcv = findViewById(R.id.my_rcv);
        my_srl = findViewById(R.id.my_srl);

        my_srl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //控制使它显示刷新
                my_srl.setRefreshing(true);
            }
        });

        //设置管理器
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

        my_srl.setRefreshing(false);
    }


    @Override
    public void OnItemClick(int position) {

        Evens evens = new Evens();
        String title = list.get(position).getTitle();
        String url = list.get(position).getPicUrl();
        evens.setName(title);
        evens.setUrl(R.mipmap.ic_launcher);
        evens.setUrl2(R.mipmap.ic_launcher);

        EventBus.getDefault().postSticky(evens);//发送粘性事件

        //实现跳转
        Intent intent = new Intent(MainActivity.this,Main2Activity.class);
        startActivity(intent);
    }
}
