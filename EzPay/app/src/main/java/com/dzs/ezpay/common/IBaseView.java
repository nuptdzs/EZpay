package com.dzs.ezpay.common;

import android.content.Context;
import android.content.Intent;

/**
 * Created by Administrator on 2016/4/23.
 *
 * @version 1.0
 * @copyright by ${COMPANY}
 */
public interface IBaseView {
    void showToast(String msg);
    void showLoading(String msg);
    void hideLoading();
    Context getContext();
    Intent _getIntent();
}
