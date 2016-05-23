package com.nupt.dzs.juheapi.api;

import com.nupt.dzs.juheapi.model.ShowApiResponse;

import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by dading on 2016/5/18.
 *
 * @version 1.0
 */
public interface BaiduApi {

    /**
     * 新闻列表查询接口
     * @param apikey 在百度apistore申请的apikey 需要加入header
     * @param channelId 新闻频道id
     * @param channelName 新闻频道名称 模糊查询
     * @param title 新闻标题模糊查询
     * @param page 页数
     * @param needContent 是否需要内容
     * @param needHtml 是否需要html资源
     * @return
     */
    @GET("/showapi_open_bus/channel_news/search_news")
    Observable<ShowApiResponse> getNews(@Header("apikey")String apikey,
                                                      @Query("channelId")String channelId,
                                                      @Query("channelName")String channelName,
                                                      @Query("title")String title,
                                                      @Query("page")int page,
                                                      @Query("needContent")int needContent,
                                                      @Query("needHtml")int needHtml
                                           );
}
