package com.dzs.ezpay.view.activity;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import com.dzs.ezpay.R;
import com.dzs.ezpay.common.BaseActivity;
import com.dzs.ezpay.presenter.HuoBiPresenter;
import com.dzs.ezpay.view.impl.IListView;
import com.nupt.dzs.juheapi.model.HuoBiModel;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class HuoBiActivity extends BaseActivity implements IListView<HuoBiModel> {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.lvHuobi)
    ListView lvHuobi;
    @Bind(R.id.refreshLayout)
    SwipeRefreshLayout refreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_huo_bi);
        ButterKnife.bind(this);
        setPresenter();
    }

    private HuoBiPresenter presenter;
    private void setPresenter(){
        presenter = new HuoBiPresenter(this);
        presenter.getData();
    }
    @Override
    public void loadList(List<HuoBiModel> huoBiModels) {

    }
}
