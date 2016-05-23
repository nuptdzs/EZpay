package com.nupt.dzs.juheapi.model;

/**
 * Created by Administrator on 2016/5/22.
 *
 * @version 1.0
 * @copyright by ${COMPANY}
 */
public class HuoBiModel {
    private String name; 				 /*货币名称*/
    private String fBuyPri; 			 /*现汇买入价*/
    private String mBuyPri;			 /*现钞买入价*/
    private String fSellPri; 			 /*现汇卖出价*/
    private String mSellPri;			 /*现钞卖出价*/
    private String bankConversionPri;		 /*银行折算价/中间价*/
    private String date;	   		 /*发布日期*/
    private String time;  			 /*发布时间*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getfBuyPri() {
        return fBuyPri;
    }

    public void setfBuyPri(String fBuyPri) {
        this.fBuyPri = fBuyPri;
    }

    public String getmBuyPri() {
        return mBuyPri;
    }

    public void setmBuyPri(String mBuyPri) {
        this.mBuyPri = mBuyPri;
    }

    public String getfSellPri() {
        return fSellPri;
    }

    public void setfSellPri(String fSellPri) {
        this.fSellPri = fSellPri;
    }

    public String getmSellPri() {
        return mSellPri;
    }

    public void setmSellPri(String mSellPri) {
        this.mSellPri = mSellPri;
    }

    public String getBankConversionPri() {
        return bankConversionPri;
    }

    public void setBankConversionPri(String bankConversionPri) {
        this.bankConversionPri = bankConversionPri;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
