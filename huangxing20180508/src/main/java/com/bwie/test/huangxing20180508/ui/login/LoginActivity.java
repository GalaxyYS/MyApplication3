package com.bwie.test.huangxing20180508.ui.login;

import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.bwie.test.huangxing20180508.R;
import com.bwie.test.huangxing20180508.bean.LoginBean;
import com.bwie.test.huangxing20180508.ui.base.BaseActivity;
import com.bwie.test.huangxing20180508.ui.login.contract.LoginContract;
import com.bwie.test.huangxing20180508.ui.login.presenter.LoginPresenter;

public class LoginActivity extends BaseActivity<LoginPresenter> implements View.OnClickListener,LoginContract.View{



    private EditText mMobile;
    private EditText mPassword;
    private Button mBtLogin;


    @Override
    public void onClick(View view) {

        switch(view.getId()){

            default:  break;
            case R.id.btLogin:
                //需要调用P层，去完成接口调用
                String mobile = mMobile.getText().toString();
                String password = mPassword.getText().toString();
                mPresenter.login(mobile, password);
                break;
        }

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        initView();
    }

    private void initView() {

        mMobile = (EditText) findViewById(R.id.mobile);
        mPassword = (EditText) findViewById(R.id.password);
        mBtLogin = (Button) findViewById(R.id.btLogin);
        mBtLogin.setOnClickListener(this);

    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_login;
    }


    @Override
    public void LoginSuccess(LoginBean loginBean) {

    }
}
