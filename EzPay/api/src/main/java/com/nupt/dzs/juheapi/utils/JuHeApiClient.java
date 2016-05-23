package com.nupt.dzs.juheapi.utils;

import com.dzs.mylibrary.RetrofitUtils;
import com.nupt.dzs.juheapi.api.JuHeApi;
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

import rx.Observable;

/**
 * Created by dading on 2016/5/21.
 *
 * @version 1.0
 */
public class JuHeApiClient {
    public static final String BASE_URL = "http://web.juhe.cn:8080/";
    public static final String FUND_URL = "http://japi.juhe.cn/";
    /**金银数据请求key*/
    public static final String APPKEY_GOLD = "044a69ef1a7048f7a77381e95d3f355b";
    /**股票接口的key*/
    public static final String APPKEY_SHARES = "b84fa2bd99428dd060183bde77ae5abd";
    /**基金净值数据*/
    public static final String APPKEY_FUND = "5c3916a4b4afafd9663a50dee84ead10";
    public static final String APPKEY_HUOBI = "ff341c7bb10adc8509f50f0dcb698a62";
    /**
     * 用于发起请求的接口
     */
    public static JuHeApi juHeApi;

    public static JuHeApi getApi(){
        if(juHeApi == null){
            juHeApi = RetrofitUtils.build(BASE_URL).build().create(JuHeApi.class);
        }
        return juHeApi;
    }

    public static  Observable<JuHeApiResponse<BankGoldListModel>> getBackGoldListModel(){
        return getApi().getBankGoldData(APPKEY_GOLD);
    }

    /**
     * 获取沪深指数
     * @param which 0 沪 1深圳
     * @return
     */
    public static Observable<JuHeResponse<HSsharesModel>> getHSzhishu(int which){
        return getApi().getHS(APPKEY_SHARES,which);
    }

    /**
     * 获取沪深股市股票列表
     * @param which
     * @param page
     * @param type
     * @return
     */
    public static Observable<JuHePageResponse<SharesModel>> getSharesList(int which,int page,int type){
        switch (which){
            case 0:
                return getApi().queryShList(APPKEY_SHARES,page,type);
            case 1:
                return getApi().querySzList(APPKEY_SHARES,page,type);
            default:
                return getApi().queryShList(APPKEY_SHARES,page,type);
        }
    }

    /**
     * 查询股票详情
     * @param gid
     * @return
     */
    public static Observable<JuHeApiResponse<SharesDetailModel>> querySharesDetail(String gid){
        return getApi().querySharesDetail(APPKEY_SHARES,gid);
    }

    /**
     * 查询全部类型基金列表
     * @param page
     * @return
     */
    public static Observable<JuHeApiResponse<FundModel>> queryFundList(int page){
        return RetrofitUtils.build(FUND_URL).build().create(JuHeApi.class)
                .queryFundList(page,10,"netvalue",APPKEY_FUND);
    }

    /**
     * 查询人民币牌价
     * @return
     */
    public static Observable<JuHeApiResponse<Map<String,HuoBiModel>>> queryRMB(){
        return getApi().queryRMB(APPKEY_HUOBI);
    }
}
