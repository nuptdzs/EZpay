package com.nupt.dzs.juheapi.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dading on 2016/5/21.
 *
 * @version 1.0
 * @copyright by ${COMPANY}
 */
public class BankGoldListModel {
    @SerializedName("1")
    private BackGoldModel _1;
    @SerializedName("2")
    private BackGoldModel _2;
    @SerializedName("3")
    private BackGoldModel _3;
    @SerializedName("4")
    private BackGoldModel _4;
    @SerializedName("5")
    private BackGoldModel _5;
    @SerializedName("6")
    private BackGoldModel _6;
    @SerializedName("7")
    private BackGoldModel _7;
    @SerializedName("8")
    private BackGoldModel _8;

    public List<BackGoldModel> formList(){
        ArrayList<BackGoldModel> models = new ArrayList<>();
        models.add(_1);
        models.add(_2);
        models.add(_3);
        models.add(_4);
        models.add(_5);
        models.add(_6);
        models.add(_7);
        models.add(_8);
        return models;


    }
}
