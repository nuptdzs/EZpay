package com.dzs.ezpay.view.activity;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import com.dzs.ezpay.R;
import com.dzs.ezpay.common.BaseActivity;
import com.dzs.ezpay.presenter.GoldDataListPresenter;
import com.dzs.ezpay.view.adapter.CommonAdapter;
import com.dzs.ezpay.view.impl.IGoldListView;
import com.dzs.ezpay.view.viewmodel.BankGoldItemVM;
import com.nupt.dzs.juheapi.model.BackGoldModel;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class GoldDataListActivity extends BaseActivity implements IGoldListView {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.lvGoldData)
    ListView lvGoldData;
    @Bind(R.id.refreshLayout)
    SwipeRefreshLayout refreshLayout;

    private GoldDataListPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gold_data_list);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("贵金属");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        toolbar.setNavigationIcon(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.getData();
            }
        });
        setPresenter();
        refreshLayout.setRefreshing(true);
    }

    @Override
    public void hideLoading() {
        super.hideLoading();
        refreshLayout.setRefreshing(false);
    }

    public void setPresenter() {
        presenter = new GoldDataListPresenter(this);
        presenter.getData();
    }

    @Override
    public void loadList(List<BackGoldModel> backGoldModels) {
        lvGoldData.setDividerHeight(0);
        lvGoldData.setAdapter(new CommonAdapter<>(backGoldModels, new BankGoldItemVM(this)));
    }
}
