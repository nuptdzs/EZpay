package com.dzs.ezpay.presenter;

import com.dzs.ezpay.R;
import com.dzs.ezpay.model.FunctionModel;
import com.dzs.ezpay.view.activity.H5Activity;
import com.dzs.ezpay.view.impl.IFunctionsView;
import com.dzs.ezpay.view.impl.IPayFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/4/27.
 *
 * @version 1.0
 * @copyright by ${COMPANY}
 */
public class PayFragmentPresenter {
    IFunctionsView payFragment;
    public PayFragmentPresenter(IFunctionsView iPayFragment){
        payFragment = iPayFragment;
    }

    public void setFuncions(){
        List<FunctionModel> functionModels = new ArrayList<>();
        functionModels.add(new FunctionModel(0,"淘宝", R.mipmap.icon_taobao,"https://m.taobao.com/?v=0#index" ,H5Activity.class));
        functionModels.add(new FunctionModel(1,"天猫",R.mipmap.icon_tianmao,"https://www.tmall.com/" ,H5Activity.class));
        functionModels.add(new FunctionModel(2,"苏宁",R.mipmap.icon_suning,"http://m.suning.com/" ,H5Activity.class));
        functionModels.add(new FunctionModel(3,"京东",R.mipmap.icon_jd,"http://m.jd.com/" ,H5Activity.class));
        functionModels.add(new FunctionModel(4,"手机充值",R.mipmap.icon_mobileaccount,"" ,H5Activity.class));
        payFragment.loadFunctions(functionModels);
    }
}
