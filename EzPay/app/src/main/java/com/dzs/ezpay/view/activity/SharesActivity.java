package com.dzs.ezpay.view.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.dzs.ezpay.R;
import com.dzs.ezpay.common.BaseActivity;
import com.dzs.ezpay.presenter.SharesDapanPresenter;
import com.dzs.ezpay.view.adapter.CommonAdapter;
import com.dzs.ezpay.view.customview.MyListView;
import com.dzs.ezpay.view.impl.ISharesDapanView;
import com.dzs.ezpay.view.viewmodel.SharesDapanItemVM;
import com.nupt.dzs.juheapi.model.HSsharesModel;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SharesActivity extends BaseActivity implements ISharesDapanView {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.lvDapanZhishu)
    MyListView lvDapanZhishu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shares);
        ButterKnife.bind(this);
        setTitle(toolbar,"大盘指数");
        setPresenter();
    }

    SharesDapanPresenter presenter;
    public void setPresenter(){
        presenter = new SharesDapanPresenter(this);
        presenter.getSharesDapan();
    }
    @Override
    public void loadList(List<HSsharesModel> hSsharesModels) {
        lvDapanZhishu.setAdapter(new CommonAdapter<>(hSsharesModels,new SharesDapanItemVM(this)));
        lvDapanZhishu.setDividerHeight(0);
    }
}
