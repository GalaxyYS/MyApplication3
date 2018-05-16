package com.bwie.test.huangxing20180508.ui.login.contract;

import com.bwie.test.huangxing20180508.bean.LoginBean;
import com.bwie.test.huangxing20180508.ui.base.BaseContract;

/**
 * Created by Galaxy on 2018/5/8.
 */

public interface LoginContract {

    interface  View  extends BaseContract.BaseView{
        void  LoginSuccess(LoginBean  loginBean);
    }

    interface  Presenter  extends BaseContract.BasePresenter<View>{

        void  login(String  mobile,String  password);
    }

}
