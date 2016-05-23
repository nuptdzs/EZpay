package com.dzs.ezpay.view.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;


import com.dzs.ezpay.common.MvpView;

import java.util.List;

/**
 * Created by dading on 2016/4/18.
 *
 * @version 1.0
 * @copyright by ${COMPANY}
 */
public class CommonAdapter<MODEL> extends BaseAdapter {

    private MvpView<MODEL> instance;
    private List<MODEL> modelList;
    public CommonAdapter(List<MODEL> models,MvpView<MODEL> t){
        instance = t;
        modelList = models;
    }

    @Override
    public int getCount() {
        return modelList.size();
    }

    @Override
    public Object getItem(int i) {
        return modelList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        MvpView<MODEL> t = null;
        if(view == null){
            t = instance.getInstance();
            t.initview();
        }else{
            t = (MvpView<MODEL>) view;
        }
        t.setData(modelList.get(i));
        return t;
    }
}
