package com.dzs.ezpay.presenter;


import com.dzs.ezpay.common.EzLog;
import com.dzs.ezpay.model.UserInfo;
import com.dzs.ezpay.view.impl.ILoginActivity;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.LogInListener;

/**
 * Created by Administrator on 2016/4/19.
 *
 * @version 1.0
 * @copyright by ${COMPANY}
 */
public class LoginPresenter {
    private ILoginActivity iLoginActivity;
    private boolean flag;

    public LoginPresenter(final ILoginActivity iLoginActivity) {
        this.iLoginActivity = iLoginActivity;
        flag = true;
    }

    public void login() {
        if (!flag) {
            iLoginActivity.showToast("连接异常");
            return;
        }
        String name = iLoginActivity.getUserName();
        String password = iLoginActivity.getUserPwd();
        if (name.length() == 0 || password.length() == 0) {
            iLoginActivity.showToast("用户名和密码不能为空！");
            return;
        }
        iLoginActivity.showLoading("正在登陆");
        BmobUser.loginByAccount(iLoginActivity.getContext(), name, password, new LogInListener<UserInfo>() {
            @Override
            public void done(UserInfo userInfo, BmobException e) {
                EzLog.e("loginresult:",userInfo.toString());
                iLoginActivity.hideLoading();
                if(userInfo!=null){
                    iLoginActivity.loginSuccess(userInfo);
                }else {
                    iLoginActivity.loginFail(e.getMessage());
                }
            }
        });

    }

}
