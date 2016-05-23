package com.dzs.ezpay.view.impl;

import com.dzs.ezpay.common.IBaseView;

import cn.bmob.v3.BmobUser;

/**
 * Created by Administrator on 2016/5/13.
 *
 * @version 1.0
 * @copyright by ${COMPANY}
 */
public interface ILoginActivity extends IBaseView {
    String getUserName();
    String getUserPwd();
    void login();
    void regist();
    void findPwd();
    void loginSuccess(BmobUser bmobUser);
    void loginFail(String err_msg);
}
