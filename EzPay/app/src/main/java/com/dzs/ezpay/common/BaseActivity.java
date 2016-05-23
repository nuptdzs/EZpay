package com.dzs.ezpay.common;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.dzs.ezpay.R;

import cn.bmob.v3.Bmob;


public class BaseActivity extends AppCompatActivity implements IBaseView {

    Activity mActivity;
    ProgressDialog progressDialog;
    Toast toast;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = this;
        Bmob.initialize(this,MyApplication.BOMB_APPKEY);
    }

    @Override
    public void showToast(String msg) {
        if(null == toast){
            toast = Toast.makeText(getBaseContext(),msg,Toast.LENGTH_SHORT);
        }else {
            toast.setText(msg);
        }
        toast.show();
    }

    @Override
    public void showLoading(String msg) {
        if(null == progressDialog){
            progressDialog = new ProgressDialog(this);
        }
        progressDialog.setMessage(msg);
        progressDialog.show();
    }

    @Override
    public void hideLoading() {
        if(null != progressDialog){
            progressDialog.dismiss();
        }
    }

    @Override
    public Context getContext() {
        return mActivity;
    }

    @Override
    public Intent _getIntent() {
        return getIntent();
    }

    public void intent2Activity(Class c){
        Intent intent = new Intent(this,c);
        startActivity(intent);
    }

    protected void setTitle(Toolbar toolbar,String title){
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        toolbar.setNavigationIcon(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
