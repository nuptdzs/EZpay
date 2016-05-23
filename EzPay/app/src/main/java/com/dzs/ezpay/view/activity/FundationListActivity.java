package com.dzs.ezpay.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

import com.dzs.ezpay.R;
import com.dzs.ezpay.common.BaseActivity;
import com.dzs.ezpay.common.MvpView;
import com.dzs.ezpay.common.RefreshableListActivity;
import com.dzs.ezpay.presenter.FundationListPresenter;
import com.dzs.ezpay.view.adapter.CommonAdapter;
import com.dzs.ezpay.view.impl.IListView;
import com.dzs.ezpay.view.viewmodel.FundItemVM;
import com.nupt.dzs.juheapi.model.FundModel;


import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by dading on 2016/5/22.
 *
 * @version 1.0
 */
public class FundationListActivity extends RefreshableListActivity<FundModel> {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.lvFundations)
    ListView lvFundations;
    @Bind(R.id.refreshLayout)
    SwipeRefreshLayout mrefreshLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fundation_list);
        ButterKnife.bind(this);
        setTitle(toolbar,"基金");
        setView(lvFundations,mrefreshLayout);
        setItemView(new FundItemVM(getContext()));
        setPresenter(new FundationListPresenter(this));
        initdata();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String jid = datalist.get(position).getSymbol();
                String url = "http://q.m.hexun.com/fund/%s.html";
                Intent intent = new Intent(getContext(),H5Activity.class);
                intent.putExtra("data",String.format(url,jid));
                startActivity(intent);
            }
        });
    }

}
