package com.nupt.dzs.juheapi.api;

import com.nupt.dzs.juheapi.model.BankGoldListModel;
import com.nupt.dzs.juheapi.model.FundModel;
import com.nupt.dzs.juheapi.model.HSsharesModel;
import com.nupt.dzs.juheapi.model.HuoBiModel;
import com.nupt.dzs.juheapi.model.JuHeApiResponse;
import com.nupt.dzs.juheapi.model.JuHePageResponse;
import com.nupt.dzs.juheapi.model.JuHeResponse;
import com.nupt.dzs.juheapi.model.SharesDetailModel;
import com.nupt.dzs.juheapi.model.SharesModel;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Administrator on 2016/5/21.
 *
 * @version 1.0
 * @copyright by ${COMPANY}
 */
public interface JuHeApi {
    @GET("/finance/gold/bankgold")
    Observable<JuHeApiResponse<BankGoldListModel>> getBankGoldData(@Query("key")String key);

    @GET("/finance/stock/hs")
    Observable<JuHeResponse<HSsharesModel>> getHS(@Query("key")String key,
                                                  @Query("type")int type);
    /**
     *
     * @param key
     * @param page 页数
     * @param type 每页返回条数,1(20条默认),2(40条),3(60条),4(80条)
     * @return
     */
    @GET("/finance/stock/szall")
    Observable<JuHePageResponse<SharesModel>> querySzList(@Query("key")String key,
                                                          @Query("page")int page,
                                                          @Query("type")int type);

    /**
     *
     * @param key
     * @param page 页数
     * @param type 每页返回条数,1(20条默认),2(40条),3(60条),4(80条)
     * @return
     */
    @GET("/finance/stock/shall")
    Observable<JuHePageResponse<SharesModel>> queryShList(@Query("key")String key,
                                                          @Query("page")int page,
                                                          @Query("type")int type);

    /**
     * 沪深股票详情查询
     * @param key
     * @param gid
     * @return
     */
    @GET("/finance/stock/hs")
    Observable<JuHeApiResponse<SharesDetailModel>> querySharesDetail(@Query("key")String key,
                                                                     @Query("gid")String gid);

    /**
     * 开放式净值数据
     * @param page
     * @param pagesize
     * @param type 基金类型,可选类型为:{债券:zhaiquan,货币:huobi,全部:netvalue,股票:gupiao,QDII:qdii,混合:hunhe},默认为股票型
     * @param key
     * @return
     */
    @GET("/jingzhi/query.from")
    Observable<JuHeApiResponse<FundModel>> queryFundList(@Query("page")int page,
                                                         @Query("pagesize")int pagesize,
                                                         @Query("type")String type,
                                                         @Query("key")String key);

    @GET("/finance/exchange/rmbquot")
    Observable<JuHeApiResponse<Map<String,HuoBiModel>>> queryRMB(@Query("key")String key);
}
