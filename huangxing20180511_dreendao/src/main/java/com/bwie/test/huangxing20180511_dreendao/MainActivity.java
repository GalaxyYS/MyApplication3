package com.bwie.test.huangxing20180511_dreendao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener{



    private Button mBtInsert;
    private Button mBtDel;
    private Button mBtUpdate;
    private Button mBtSelect;
    private DaoSession daoSession;
    private UserDao userDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

         daoSession = MyApp.getDaoSession();

         userDao = daoSession.getUserDao();
    }

    public  void  initView(){
        mBtInsert = (Button) findViewById(R.id.btInsert);
        mBtInsert.setOnClickListener(this);
        mBtDel = (Button) findViewById(R.id.btDel);
        mBtDel.setOnClickListener(this);
        mBtUpdate = (Button) findViewById(R.id.btUpdate);
        mBtUpdate.setOnClickListener(this);
        mBtSelect = (Button) findViewById(R.id.btSelect);
        mBtSelect.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {


        switch (view.getId()){
            default:
                break;
            case  R.id.btInsert:

                for (int i=1;i<=10;i++){
                    User  user=new User();
                    user.setName("name_"+i);
                    user.setAge("age_"+i);
                    userDao.insert(user);

                }
                break;

            case  R.id.btDel:
                User  user=new  User();
                user.setId(1L);
                user.setName("name_1");
                userDao.deleteByKey(3L);

                break;

            case  R.id.btUpdate:
                User  user1=new User();
                user1.setId(1L);
                user1.setName("张三");
                user1.setAge("22");
                userDao.update(user1);
                break;


            case R.id.btSelect:

                User user2=new User();

                select();
                break;
        }
    }

    private void select() {

        List<User> list= userDao.queryBuilder().build().list();

        for(int i=0;i<list.size();i++){
            Log.i("MainActivity",list.get(i).toString());
        }

    }


}
