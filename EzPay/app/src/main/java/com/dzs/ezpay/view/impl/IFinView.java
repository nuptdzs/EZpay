package com.dzs.ezpay.view.impl;

import com.nupt.dzs.juheapi.model.FinNewsModel;

import java.util.List;

/**
 * Created by Administrator on 2016/5/18.
 *
 * @version 1.0
 * @copyright by ${COMPANY}
 */
public interface IFinView  extends IFunctionsView{
    void loadNews(List<FinNewsModel> models);
}
