package com.nupt.dzs.juheapi.utils;

import com.dzs.mylibrary.RetrofitUtils;
import com.nupt.dzs.juheapi.api.BaiduApi;
import com.nupt.dzs.juheapi.model.FinNewsModel;
import com.nupt.dzs.juheapi.model.ShowApiResponse;

import java.util.List;

import rx.Observable;


/**
 * Created by dading on 2016/5/18.
 * 百度api接口客户端
 * @version 1.0
 * @copyright by dading
 */
public class BaiduApiClient {
    public static final String BASE_URL = "http://apis.baidu.com/";
    /**
     * 用于发起请求的接口
     */
    public static BaiduApi baiduApi;
    /**
     * 在百度api store申请获得
     */
    public static final String API_KEY = "3ff9ce7447dbe0138c6c0f37bd0d614c";


    public static final String finNewsChannelId = "5572a108b3cdc86cf39001d0";
    /**
     * 分页查询
     * @param page
     * @return
     */
    public static Observable<ShowApiResponse> getFinNews(int page) {
        return getApi().getNews(API_KEY,finNewsChannelId,"财经","",page,1,1);
    }

    /**
     * 获取retrofit网络请求实例接口
     * @return
     */
    public static BaiduApi getApi(){
        if(baiduApi == null){
            baiduApi = RetrofitUtils.build(BASE_URL).build().create(BaiduApi.class);
        }
        return baiduApi;
    }

}
