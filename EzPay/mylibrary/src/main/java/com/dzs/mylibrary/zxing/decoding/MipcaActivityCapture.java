package com.dzs.mylibrary.zxing.decoding;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Handler;

import com.dzs.mylibrary.zxing.view.ViewfinderView;
import com.google.zxing.Result;

/**
 * Created by Administrator on 2016/5/23.
 *
 * @version 1.0
 * @copyright by ${COMPANY}
 */
public interface MipcaActivityCapture {
    Handler getHandler();

    void handleDecode(Result obj, Bitmap barcode);

    void startActivity(Intent intent);

    void finish();

    void setResult(int resultOk, Intent obj);

    void drawViewfinder();

    ViewfinderView getViewfinderView();
}
