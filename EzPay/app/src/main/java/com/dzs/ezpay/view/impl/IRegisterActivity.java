package com.dzs.ezpay.view.impl;

import com.dzs.ezpay.common.IBaseView;

/**
 * Created by Administrator on 2016/5/13.
 *
 * @version 1.0
 * @copyright by ${COMPANY}
 */
public interface IRegisterActivity extends IBaseView {
    String getPhone();
    String getPwd();
    String getSmsCode();
    void register();
    void sendSmsSuccess();
    void verfySmsSuccess();
    void registerSuccess();

}
