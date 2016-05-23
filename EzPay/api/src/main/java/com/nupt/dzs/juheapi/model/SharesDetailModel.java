package com.nupt.dzs.juheapi.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/5/21.
 *
 * @version 1.0
 * @copyright by ${COMPANY}
 */
public class SharesDetailModel implements Serializable{

    public SharesData data;
    public Gopicture gopicture;
    public SharesDapandata dapandata;
    public class SharesData implements Serializable{
        public String buyFive;
		public String buyFivePri;
		public String buyFour;
        public String buyFourPri;
        public String buyOne;
        public String buyOnePri;
        public String buyThree;
        public String buyThreePri;
        public String buyTwo;
        public String buyTwoPri;
        public String competitivePri;
        public String date;
        public String gid;
        public String increPer;
        public String increase;
        public String name;
        public String nowPri;
        public String reservePri;
        public String sellFive;
        public String sellFivePri;
        public String sellFour;
        public String sellFourPri;
        public String sellOne;
        public String sellOnePri;
        public String sellThree;
        public String sellThreePri;
        public String sellTwo;
        public String sellTwoPri;
        public String time;
        public String todayMax;
        public String todayMin;
        public String todayStartPri;
        public String traAmount;
        public String traNumber;
        public String yestodEndPri;

    }

    public class SharesDapandata implements Serializable{
        public String dot;
        public String name;
        public String nowPic;
        public String rate;
        public String traAmount;
        public String traNumber;

        public String getDot() {
            return dot;
        }

        public void setDot(String dot) {
            this.dot = dot;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getNowPic() {
            return nowPic;
        }

        public void setNowPic(String nowPic) {
            this.nowPic = nowPic;
        }

        public String getRate() {
            return rate;
        }

        public void setRate(String rate) {
            this.rate = rate;
        }

        public String getTraAmount() {
            return traAmount;
        }

        public void setTraAmount(String traAmount) {
            this.traAmount = traAmount;
        }

        public String getTraNumber() {
            return traNumber;
        }

        public void setTraNumber(String traNumber) {
            this.traNumber = traNumber;
        }
    }

    public class Gopicture implements Serializable{
        public String minurl;
        public String dayurl;
        public String weekurl;
        public String monthurl;

        public String getMinurl() {
            return minurl;
        }

        public void setMinurl(String minurl) {
            this.minurl = minurl;
        }

        public String getDayurl() {
            return dayurl;
        }

        public void setDayurl(String dayurl) {
            this.dayurl = dayurl;
        }

        public String getWeekurl() {
            return weekurl;
        }

        public void setWeekurl(String weekurl) {
            this.weekurl = weekurl;
        }

        public String getMonthurl() {
            return monthurl;
        }

        public void setMonthurl(String monthurl) {
            this.monthurl = monthurl;
        }
    }
}
