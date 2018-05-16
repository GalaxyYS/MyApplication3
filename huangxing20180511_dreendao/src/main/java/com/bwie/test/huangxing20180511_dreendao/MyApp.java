package com.bwie.test.huangxing20180511_dreendao;

import android.app.Application;

import org.greenrobot.greendao.AbstractDaoMaster;

/**
 * Created by Galaxy on 2018/5/11.
 */

public class MyApp extends Application {


    private DaoMaster daoMaster;
    private static DaoSession daoSession;


    @Override
    public void onCreate() {
        super.onCreate();


        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, "my.db");
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDb());
        daoSession = daoMaster.newSession();


    }
    public  static  DaoSession  getDaoSession(){
        return daoSession;
    }
}
