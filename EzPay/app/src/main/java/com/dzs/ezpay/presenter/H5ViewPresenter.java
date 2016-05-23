package com.dzs.ezpay.presenter;

import com.dzs.ezpay.view.impl.IH5View;

/**
 * Created by Administrator on 2016/4/27.
 *
 * @version 1.0
 * @copyright by ${COMPANY}
 */
public class H5ViewPresenter {
    IH5View mH5View;

    public H5ViewPresenter(IH5View ih5View) {
        mH5View = ih5View;
    }

    public void onCreateWebView() {
        String url = mH5View._getIntent().getStringExtra("data");
        mH5View.loadWeb(url);
    }
}
