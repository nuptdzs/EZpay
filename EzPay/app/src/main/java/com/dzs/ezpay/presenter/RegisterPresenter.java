package com.dzs.ezpay.presenter;


import com.dzs.ezpay.common.EzLog;
import com.dzs.ezpay.view.impl.IRegisterActivity;

import cn.bmob.sms.BmobSMS;
import cn.bmob.sms.exception.BmobException;
import cn.bmob.sms.listener.RequestSMSCodeListener;
import cn.bmob.sms.listener.VerifySMSCodeListener;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by Administrator on 2016/5/13.
 *
 * @version 1.0
 * @copyright by ${COMPANY}
 */
public class RegisterPresenter {
    IRegisterActivity registerActivity;
    public RegisterPresenter(IRegisterActivity iRegisterActivity){
        registerActivity = iRegisterActivity;
    }

    //发送短信验证码
    public void sendSms(){
        if(registerActivity.getPhone().equals("")||registerActivity.getPwd().equals("")){
            registerActivity.showToast("手机号和密码不能为空");
        }else {
            BmobSMS.requestSMSCode(registerActivity.getContext(), registerActivity.getPhone(), "口袋账本", new RequestSMSCodeListener() {
                @Override
                public void done(Integer integer, BmobException e) {
                    if(e == null){
                        registerActivity.sendSmsSuccess();
                    }else {
                        registerActivity.showToast(e.getMessage());
                    }
                }
            });
        }

    }
    //验证短信验证码
    public void verfySmsCode(){
        if(registerActivity.getSmsCode().equals("")){
            registerActivity.showToast("请输入验证码");
        }else {
            registerActivity.showLoading("正在验证");
            BmobSMS.verifySmsCode(registerActivity.getContext(), registerActivity.getPhone(), registerActivity.getSmsCode(), new VerifySMSCodeListener() {
                @Override
                public void done(BmobException e) {
                    if(e==null){
                        register();
                    }else {
                        registerActivity.hideLoading();
                        registerActivity.showToast("短信验证码错误");
                        EzLog.e("registerResult",e.getMessage());
                    }
                }
            });
        }
    }
    //注册
    public void register(){
        BmobUser bmobUser = new BmobUser();
        bmobUser.setUsername(registerActivity.getPhone());
        bmobUser.setMobilePhoneNumber(registerActivity.getPhone());
        bmobUser.setPassword(registerActivity.getPwd());
        bmobUser.signUp(registerActivity.getContext(), new SaveListener() {
            @Override
            public void onSuccess() {
                registerActivity.hideLoading();
                registerActivity.registerSuccess();
            }

            @Override
            public void onFailure(int i, String s) {
                registerActivity.hideLoading();
                registerActivity.showToast(s);
            }
        });
    }
}
