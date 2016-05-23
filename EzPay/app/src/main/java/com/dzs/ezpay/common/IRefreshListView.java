package com.dzs.ezpay.common;

import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.ListView;

/**
 * Created by Administrator on 2016/5/22.
 *
 * @version 1.0
 * @copyright by ${COMPANY}
 */
public interface IRefreshListView<T> {
    void setView(ListView listView, SwipeRefreshLayout refreshLayout);
    void setPresenter(RefreshableListActivity.ListPresenter listPresenter);
    void setItemView(MvpView<T> tMvpView);
    void initdata();
}
