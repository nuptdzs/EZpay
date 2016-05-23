package com.nupt.dzs.juheapi.model;

/**
 * Created by 大丁 on 2016/5/21.
 *
 * @version 1.0
 * 股票
 */
public class SharesModel {
  /*  *//**//*"symbol": "sh600004",*//**//*代码*//**//*
    "name": "白云机场",*//**//*名称*//**//*
            "trade": "11.590",*//**//*最新价*//**//*
            "pricechange": "-0.130",*//**//*涨跌额*//**//*
            "changepercent": "-1.109",*//**//*涨跌幅*//**//*
            "buy": "11.590",*//**//*买入*//**//*
            "sell": "11.600",*//**//*卖出*//**//*
            "settlement": "11.720",*//**//*昨收*//**//*
            "open": "11.670",*//**//*今开*//**//*
            "high": "11.800",*//**//*最高*//**//*
            "low": "11.570",*//**//*最低*//**//*
            "volume": 38781,*//**//*成交量*//**//*
            "amount": 45385925,*//**//*成效额*//**//*
            "code": "600004",*//**//*简码*//**//*
            "ticktime": "15:00:00"*//**//*时间***///*//**//*/
    /**代码*/
    private String symbol;
    /**/
    private String name;
    private String trade;
    private String pricechange;
    private String changepercent;
    private String buy;
    private String sell;
    private String settlement;
    private String open;
    private String high;
    private String low;
    private long volume;
    private long amount;
    private String code;
    private String ticktime;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTrade() {
        return trade;
    }

    public void setTrade(String trade) {
        this.trade = trade;
    }

    public String getPricechange() {
        return pricechange;
    }

    public void setPricechange(String pricechange) {
        this.pricechange = pricechange;
    }

    public String getChangepercent() {
        return changepercent;
    }

    public void setChangepercent(String changepercent) {
        this.changepercent = changepercent;
    }

    public String getBuy() {
        return buy;
    }

    public void setBuy(String buy) {
        this.buy = buy;
    }

    public String getSell() {
        return sell;
    }

    public void setSell(String sell) {
        this.sell = sell;
    }

    public String getSettlement() {
        return settlement;
    }

    public void setSettlement(String settlement) {
        this.settlement = settlement;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public long getVolume() {
        return volume;
    }

    public void setVolume(long volume) {
        this.volume = volume;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTicktime() {
        return ticktime;
    }

    public void setTicktime(String ticktime) {
        this.ticktime = ticktime;
    }
}
