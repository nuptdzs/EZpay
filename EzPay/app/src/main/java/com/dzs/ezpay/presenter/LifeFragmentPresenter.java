package com.dzs.ezpay.presenter;

/**
 * Created by Administrator on 2016/5/18.
 *
 * @version 1.0
 * @copyright by ${COMPANY}
 */

import com.dzs.ezpay.R;
import com.dzs.ezpay.model.FunctionModel;
import com.dzs.ezpay.view.activity.H5Activity;
import com.dzs.ezpay.view.impl.IFunctionsView;

import java.util.ArrayList;
import java.util.List;

/**
 * 生活模块展示器
 */
public class LifeFragmentPresenter {
    private IFunctionsView iLifeFragment;
    public LifeFragmentPresenter(IFunctionsView lifeFragment){
        this.iLifeFragment = lifeFragment;
    }

    public void setFunctions(){
        List<FunctionModel> functionModels = new ArrayList<>();
        functionModels.add(new FunctionModel(0,"火车票", R.mipmap.icon_func_train,"http://m.ctrip.com/webapp/train/" ,H5Activity.class));
        functionModels.add(new FunctionModel(1,"加油卡充值",R.mipmap.icon_funcs_addoil,"key" ,H5Activity.class));
        functionModels.add(new FunctionModel(2,"手机充值",R.mipmap.icon_mobileaccount,"key" ,H5Activity.class));
        functionModels.add(new FunctionModel(3,"违章代缴",R.mipmap.icon_func_weizhang,"key" ,H5Activity.class));
        functionModels.add(new FunctionModel(4,"水电煤",R.mipmap.icon_func_sdm,"" ,H5Activity.class));
        functionModels.add(new FunctionModel(4,"电影票",R.mipmap.icon_funcs_movie,"http://m.maoyan.com/#type=movies" ,H5Activity.class));
        functionModels.add(new FunctionModel(4,"快递查询",R.mipmap.icon_funcs_kuaidi,"http://wap.guoguo-app.com/" ,H5Activity.class));
        functionModels.add(new FunctionModel(4,"邮编查询",R.mipmap.icon_func_youbian,"" ,H5Activity.class));
        functionModels.add(new FunctionModel(4,"今日油价",R.mipmap.icon_funcs_oil,"" ,H5Activity.class));
        functionModels.add(new FunctionModel(4,"美食",R.mipmap.icon_func_meals,"" ,H5Activity.class));
        functionModels.add(new FunctionModel(4,"出行",R.mipmap.icon_func_lvyou,"http://m.ctrip.com/" ,H5Activity.class));
        iLifeFragment.loadFunctions(functionModels);
    }
}
