package com.dzs.ezpay.model;

import cn.bmob.v3.BmobUser;

/**
 * 用户信息
 */
public class UserInfo extends BmobUser{
    private boolean sex;
    private int age;
    private String head_img;
    private String introduction;

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHead_img() {
        return head_img;
    }

    public void setHead_img(String head_img) {
        this.head_img = head_img;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "sex=" + sex +
                ", age=" + age +
                ", head_img='" + head_img + '\'' +
                ", introduction='" + introduction + '\'' +
                '}';
    }
}
