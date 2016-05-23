package com.nupt.dzs.juheapi.model;

/**
 * Created by Administrator on 2016/5/22.
 *
 * @version 1.0
 * @copyright by ${COMPANY}
 */
public class FundModel {
    /*"jjlx":"偏股型基金",
			"nav_a":"0.013",
			"nav_date":"2016-05-20",
			"nav_rate":"1.2658",
			"per_nav":"1.0400",
			"sg_states":"开放",
			"sname":"新华中证环保产业指数分级",
			"symbol":"164304",
			"total_nav":"1.0950",
			"yesterday_nav":"1.027"
		*/
    private String jjlx;
    private String nav_a;
    private String nav_date;
    private String nav_rate;
    private String per_nav;
    private String sg_states;
    private String sname;
    private String symbol;
    private String total_nav;
    private String yesterday_nav;

    public String getJjlx() {
        return jjlx;
    }

    public void setJjlx(String jjlx) {
        this.jjlx = jjlx;
    }

    public String getNav_a() {
        return nav_a;
    }

    public void setNav_a(String nav_a) {
        this.nav_a = nav_a;
    }

    public String getNav_date() {
        return nav_date;
    }

    public void setNav_date(String nav_date) {
        this.nav_date = nav_date;
    }

    public String getNav_rate() {
        return nav_rate;
    }

    public void setNav_rate(String nav_rate) {
        this.nav_rate = nav_rate;
    }

    public String getPer_nav() {
        return per_nav;
    }

    public void setPer_nav(String per_nav) {
        this.per_nav = per_nav;
    }

    public String getSg_states() {
        return sg_states;
    }

    public void setSg_states(String sg_states) {
        this.sg_states = sg_states;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getTotal_nav() {
        return total_nav;
    }

    public void setTotal_nav(String total_nav) {
        this.total_nav = total_nav;
    }


    public String getYesterday_nav() {
        return yesterday_nav;
    }

    public void setYesterday_nav(String yesterday_nav) {
        this.yesterday_nav = yesterday_nav;
    }
}
