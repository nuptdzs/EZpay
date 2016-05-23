package com.dzs.ezpay.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.dzs.ezpay.R;
import com.dzs.ezpay.common.BaseActivity;
import com.dzs.ezpay.presenter.LoginPresenter;
import com.dzs.ezpay.view.impl.ILoginActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.BmobUser;

public class LoginActivity extends BaseActivity implements ILoginActivity {

    @Bind(R.id.imgLogo)
    ImageView imgLogo;
    @Bind(R.id.etLoginName)
    EditText etLoginName;
    @Bind(R.id.etLoginPwd)
    EditText etLoginPwd;
    @Bind(R.id.btn_login)
    Button btnLogin;
    @Bind(R.id.tvRegist)
    TextView tvRegist;
    @Bind(R.id.tvFindPwd)
    TextView tvFindPwd;

    private LoginPresenter mLoginPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        mLoginPresenter = new LoginPresenter(this);
    }

    @Override
    public String getUserName() {
        return etLoginName.getText().toString().trim();
    }

    @Override
    public String getUserPwd() {
        return etLoginPwd.getText().toString().trim();
    }

    /**
     * 登录
     */
    @Override
    public void login() {
        mLoginPresenter.login();
    }

    /**
     * 注册
     */
    @Override
    public void regist() {
        Intent intent = new Intent();
        intent.setClass(this,RegistActivity.class);
        startActivity(intent);
    }

    /**
     * 找回密码
     */
    @Override
    public void findPwd() {
        Intent intent = new Intent();
        intent.setClass(this,FindPwdActivity.class);
        startActivity(intent);
    }
    /**
     * 登录成功
     */
    @Override
    public void loginSuccess(BmobUser bmobUser) {
        showToast("登陆成功");
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    /**
     * 登录失败
     */
    @Override
    public void loginFail(String err_msg) {
        showToast(err_msg);
    }




    @OnClick({R.id.tvRegist, R.id.tvFindPwd, R.id.btn_login})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tvRegist:
                regist();
                break;
            case R.id.tvFindPwd:
                findPwd();
                break;
            case R.id.btn_login:
                login();
                break;
        }
    }
}
