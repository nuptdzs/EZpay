package com.dzs.ezpay.common;

import android.util.Log;

/**
 * Created by Administrator on 2016/5/13.
 *
 * @version 1.0
 * @copyright by ${COMPANY}
 */
public class EzLog {
    public static boolean debugable = false;

    public static void d(String tag,String msg){
        if (debugable){
        Log.d(tag,msg);
        }
    }

    public static void e(String tag,String msg){
        if (debugable){
            Log.e(tag,msg);
        }
    }


}
