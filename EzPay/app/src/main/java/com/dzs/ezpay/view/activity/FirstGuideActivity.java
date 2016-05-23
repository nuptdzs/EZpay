package com.dzs.ezpay.view.activity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.dzs.ezpay.R;
import com.dzs.ezpay.common.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class FirstGuideActivity extends BaseActivity {

    @Bind(R.id.viewpager)
    ViewPager viewpager;
    @Bind(R.id.btEnter)
    Button btEnter;
    @Bind(R.id.llContainer)
    LinearLayout llContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_guide);
        ButterKnife.bind(this);
        SharedPreferences setting = getSharedPreferences("Version",
                Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = setting.edit();
        editor.putBoolean("FIRST", false).commit();
        getPics();


    }

    /**
     * 添加引导页图片资源
     */
    private void getPics() {

    }

    @OnClick(R.id.btEnter)
    public void onClick() {
        intent2Activity(MainActivity.class);
        finish();
    }

}
