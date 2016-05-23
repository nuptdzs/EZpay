package com.dzs.ezpay.view.impl;

import com.dzs.ezpay.common.IBaseView;

import java.util.List;

/**
 * Created by Administrator on 2016/5/21.
 *
 * @version 1.0
 * @copyright by ${COMPANY}
 */
public interface IListView<T> extends IBaseView{
    void loadList(List<T> tList);
}
