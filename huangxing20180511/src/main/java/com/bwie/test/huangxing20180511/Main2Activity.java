package com.bwie.test.huangxing20180511;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class Main2Activity extends AppCompatActivity {

    private TextView my_title;
    private ImageView my_img;
    int index=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        my_title = findViewById(R.id.my_title);
        my_img = findViewById(R.id.my_img);

        //注册
        EventBus.getDefault().register(this);
    }



    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true) //在ui线程执行
    public void onEvens(Evens evens) {

        //获取Evens传来的数据，进行赋值
        my_title.setText(evens.getName());
        if(index%2==0){
            Glide.with(this).load(evens.getUrl()).into(my_img);
        }else{
            Glide.with(this).load(evens.getUrl2()).into(my_img);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        //反注册，进行销毁
        EventBus.getDefault().unregister(this);
    }
}
