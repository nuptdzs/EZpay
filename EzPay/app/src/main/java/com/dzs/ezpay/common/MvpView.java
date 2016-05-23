package com.dzs.ezpay.common;


import android.content.Context;
import android.widget.LinearLayout;

/**
 * Created by Administrator on 2016/4/18.
 *
 * @version 1.0
 * @copyright by ${COMPANY}
 */
public abstract class MvpView<T> extends LinearLayout {
    public MvpView(Context context) {
        super(context);
        initview();
    }

    public abstract void initview();
    public abstract void setData(T model);
    public abstract MvpView<T> getInstance();
}
