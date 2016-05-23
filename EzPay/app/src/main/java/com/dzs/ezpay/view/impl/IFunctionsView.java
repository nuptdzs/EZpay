package com.dzs.ezpay.view.impl;

import com.dzs.ezpay.common.IBaseView;
import com.dzs.ezpay.model.FunctionModel;

import java.util.List;

/**
 * Created by Administrator on 2016/5/18.
 *
 * @version 1.0
 * @copyright by ${COMPANY}
 */
public interface IFunctionsView extends IBaseView {
    void loadFunctions(List<FunctionModel> functionModels);
}
