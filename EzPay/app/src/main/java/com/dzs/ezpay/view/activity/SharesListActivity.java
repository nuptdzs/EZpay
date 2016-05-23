package com.dzs.ezpay.view.activity;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

import com.dzs.ezpay.R;
import com.dzs.ezpay.common.BaseActivity;
import com.dzs.ezpay.presenter.SharesListPresenter;
import com.dzs.ezpay.view.adapter.CommonAdapter;
import com.dzs.ezpay.view.impl.IListView;
import com.dzs.ezpay.view.viewmodel.SharesListItemVM;
import com.nupt.dzs.juheapi.model.SharesModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SharesListActivity extends BaseActivity implements IListView<SharesModel> {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.lvShares)
    ListView lvShares;
    int type;
    @Bind(R.id.refreshLayout)
    SwipeRefreshLayout refreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shares_list);
        ButterKnife.bind(this);
        type = _getIntent().getIntExtra("type", 0);
        if (type == 0) {
            setTitle(toolbar, "沪股");
        } else {
            setTitle(toolbar, "深股");
        }
        setPresenter();
    }

    private SharesListPresenter presenter;

    private void setPresenter() {
        presenter = new SharesListPresenter(this);
        presenter.getSharesList(currentpage, type);
    }

    CommonAdapter adapter;
    List<SharesModel> models = new ArrayList<>();
    View footerView;
    private int currentpage = 1;

    @Override
    public void loadList(List<SharesModel> sharesModels) {
        lvShares.setDividerHeight(0);
        if (adapter == null) {
            models = sharesModels;
            adapter = new CommonAdapter<>(models, new SharesListItemVM(this));
            lvShares.setAdapter(adapter);
            lvShares.setOnScrollListener(new ScrollListener());
            lvShares.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String t;
                    switch (type){
                        case 0:
                            t = "sh";
                            break;
                        case 1:
                            t= "sz";
                            break;
                        default:
                            t = "sh";
                            break;
                    }
                    String gid =t+models.get(position).getCode();
                    presenter.getShareDetail(gid);
                }
            });
            footerView = LayoutInflater.from(getContext()).inflate(R.layout.list_footer_view, null);
            refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {
                    adapter = null;
                    currentpage = 1;
                    presenter.getSharesList(currentpage,type);
                }
            });
            refreshLayout.setRefreshing(false);
        } else {
            models.addAll(sharesModels);
            adapter.notifyDataSetChanged();
            if (lvShares.getFooterViewsCount() > 0) {
                lvShares.removeFooterView(footerView);
            }
            loading = false;
        }
    }

    private boolean loading = false;

    private class ScrollListener implements AbsListView.OnScrollListener {
        @Override
        public void onScrollStateChanged(AbsListView view, int scrollState) {

        }

        @Override
        public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
            int totalcount = totalItemCount;
            int lastItemid = view.getLastVisiblePosition();
            if (totalcount == lastItemid + 1) {
                if (totalcount > 0) {
                    if (!loading) {
                        loading = true;
                        currentpage++;
                        lvShares.addFooterView(footerView);
                        presenter.getSharesList(currentpage, type);
                    }
                }
            }
        }
    }
}
