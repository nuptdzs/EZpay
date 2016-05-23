package com.nupt.dzs.juheapi.model;

/**
 * Created by Administrator on 2016/5/21.
 *
 * @version 1.0
 * @copyright by ${COMPANY}
 */
public class HSsharesModel {
    /*"error_code":0,
	"reason":"SUCCESSED!",
	"result":{
		"dealNum":"14998232160",
		"dealPri":"242144764148.247",
		"highPri":"9816.752",
		"increPer":"0.85",
		"increase":"83.016",
		"lowpri":"9628.984",
		"name":"深证成指",
		"nowpri":"9816.752",
		"openPri":"9657.745",
		"time":"2016-05-20 16:30:03",
		"yesPri":"9733.736"
	}*/

    private String dealNum;
    private String dealPri;
    private String highPri;
    private String increPer;
    private String increase;
    private String lowpri;
    private String name;
    private String nowpri;
    private String openPri;
    private String time;
    private String yesPri;

    public String getDealNum() {
        return dealNum;
    }

    public void setDealNum(String dealNum) {
        this.dealNum = dealNum;
    }

    public String getDealPri() {
        return dealPri;
    }

    public void setDealPri(String dealPri) {
        this.dealPri = dealPri;
    }

    public String getHighPri() {
        return highPri;
    }

    public void setHighPri(String highPri) {
        this.highPri = highPri;
    }

    public String getIncrePer() {
        return increPer;
    }

    public void setIncrePer(String increPer) {
        this.increPer = increPer;
    }

    public String getIncrease() {
        return increase;
    }

    public void setIncrease(String increase) {
        this.increase = increase;
    }

    public String getLowpri() {
        return lowpri;
    }

    public void setLowpri(String lowpri) {
        this.lowpri = lowpri;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNowpri() {
        return nowpri;
    }

    public void setNowpri(String nowpri) {
        this.nowpri = nowpri;
    }

    public String getOpenPri() {
        return openPri;
    }

    public void setOpenPri(String openPri) {
        this.openPri = openPri;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getYesPri() {
        return yesPri;
    }

    public void setYesPri(String yesPri) {
        this.yesPri = yesPri;
    }
}
