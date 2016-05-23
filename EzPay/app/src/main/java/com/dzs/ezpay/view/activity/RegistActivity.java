package com.dzs.ezpay.view.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.dzs.ezpay.R;
import com.dzs.ezpay.common.BaseActivity;
import com.dzs.ezpay.common.MyApplication;
import com.dzs.ezpay.presenter.RegisterPresenter;
import com.dzs.ezpay.view.impl.IRegisterActivity;

import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.sms.BmobSMS;

public class RegistActivity extends BaseActivity implements IRegisterActivity{

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.etRegistName)
    EditText etRegistName;
    @Bind(R.id.etRegistPwd)
    EditText etRegistPwd;
    @Bind(R.id.etSmsCode)
    EditText etSmsCode;
    @Bind(R.id.tvSmsCode)
    TextView tvSmsCode;
    @Bind(R.id.btRegister)
    Button btRegister;

    private RegisterPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        BmobSMS.initialize(this, MyApplication.BOMB_APPKEY);
        toolbar.setNavigationIcon(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        presenter = new RegisterPresenter(this);
    }

    @OnClick({R.id.tvSmsCode, R.id.btRegister})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tvSmsCode:
                sendSmsCode();
                break;
            case R.id.btRegister:
                register();
                break;
        }
    }

    private void sendSmsCode(){
        presenter.sendSms();
    }

    @Override
    public String getPhone() {
        return etRegistName.getText().toString().trim();
    }

    @Override
    public String getPwd() {
        return etRegistPwd.getText().toString().trim();
    }

    @Override
    public String getSmsCode() {
        return etSmsCode.getText().toString().trim();
    }

    @Override
    public void register() {
        presenter.verfySmsCode();
    }

    @Override
    public void sendSmsSuccess() {
        tvSmsCode.setClickable(false);
        tvSmsCode.setBackgroundColor(getResources().getColor(R.color.text_color_gray));
        startCount();
    }

    @Override
    public void verfySmsSuccess() {

    }

    @Override
    public void registerSuccess() {
        finish();
    }

    Timer timer;
    CountHandler handler = new CountHandler(this);
    TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {
            count--;
            handler.sendEmptyMessage(1111);
        }
    };

    private static class CountHandler extends Handler{
        WeakReference<RegistActivity> weakReference;
        public CountHandler(RegistActivity registActivity){
            weakReference = new WeakReference<RegistActivity>(registActivity);
        }
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1111:
                    int leftSeconds = weakReference.get().count;
                    if (leftSeconds>0){
                        weakReference.get().tvSmsCode.setText(leftSeconds+"s后重新发送");

                    }else {
                        weakReference.get().resetCount();
                    }
                    break;
            }
        }
    }
    int count = 60;
    void resetCount(){
        timer.cancel();
        tvSmsCode.setText("发送验证码");
        tvSmsCode.setClickable(true);
        tvSmsCode.setBackgroundColor(getResources().getColor(R.color.blue));
        count = 60;
    }
    void startCount(){
        timer = new Timer();
        timer.schedule(timerTask,0,1000);
    }
}
