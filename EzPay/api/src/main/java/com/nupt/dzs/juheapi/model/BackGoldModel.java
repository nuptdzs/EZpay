package com.nupt.dzs.juheapi.model;

/**
 * Created by Administrator on 2016/5/21.
 * 银行账户金银数据模型
 * @version 1.0
 * @copyright by ${COMPANY}
 * smaple：{"variety":"美元账户黄金", 品种
        "midpri":"1675.98",			中间价
        "buypri":"1674.48",			买入价
        "sellpri":"1677.48",			卖出价
        "maxpri":"1693.60",			最高价
        "minpri":"1660.95",			最低价
        "todayopen":"1693.37",			今开盘
        "closeyes":"1674.48",			昨收盘
        "quantpri":"0.00",			涨跌量
        "time":"2012-12-19 17:57:59"		更新时间}
 */
public class BackGoldModel {
    /**品种**/
    private String variety;
    /**中间价**/
    private String midpri;
    /**买入价**/
    private String buypri;
    /**卖出价**/
    private String sellpri;
    /**最高价**/
    private String maxpri;
    /**最低价**/
    private String minpri;
    /**今日开盘**/
    private String todayopen;
    /**昨日收盘**/
    private String closeyes;
    /**涨跌**/
    private String quantpri;
    /**更新时间**/
    private String time;

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    public String getMidpri() {
        return midpri;
    }

    public void setMidpri(String midpri) {
        this.midpri = midpri;
    }

    public String getBuypri() {
        return buypri;
    }

    public void setBuypri(String buypri) {
        this.buypri = buypri;
    }

    public String getSellpri() {
        return sellpri;
    }

    public void setSellpri(String sellpri) {
        this.sellpri = sellpri;
    }

    public String getMaxpri() {
        return maxpri;
    }

    public void setMaxpri(String maxpri) {
        this.maxpri = maxpri;
    }

    public String getMinpri() {
        return minpri;
    }

    public void setMinpri(String minpri) {
        this.minpri = minpri;
    }

    public String getTodayopen() {
        return todayopen;
    }

    public void setTodayopen(String todayopen) {
        this.todayopen = todayopen;
    }

    public String getCloseyes() {
        return closeyes;
    }

    public void setCloseyes(String closeyes) {
        this.closeyes = closeyes;
    }

    public String getQuantpri() {
        return quantpri;
    }

    public void setQuantpri(String quantpri) {
        this.quantpri = quantpri;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
