package com.dzs.ezpay.common;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.widget.AbsListView;
import android.widget.ListView;

import com.dzs.ezpay.R;
import com.dzs.ezpay.view.adapter.CommonAdapter;
import com.dzs.ezpay.view.impl.IListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/5/22.
 *
 * @version 1.0
 */
public abstract class RefreshableListActivity<T> extends BaseActivity implements IListView<T>,IRefreshListView<T>{
    protected ListView listView;
    protected SwipeRefreshLayout refreshLayout;
    protected CommonAdapter adapter;
    protected List<T> datalist = new ArrayList<>();
    private boolean loading = false;
    private int currentpage = 1;
    private android.view.View footerView;
    protected ListPresenter presenter;

    public interface ListPresenter{
        void getdata(int page);
    }

    public void setView(ListView listView, SwipeRefreshLayout refreshLayout){
        this.listView = listView;
        this.refreshLayout = refreshLayout;
    }
    public void setPresenter(ListPresenter presenter){
        this.presenter = presenter;
    }
    private MvpView<T> mvpView;
    public void setItemView(MvpView<T> mvpView){
        this.mvpView = mvpView;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void initdata(){
        presenter.getdata(currentpage);
    }
    @Override
    public void loadList(List<T> tList) {
        if (adapter == null) {
            datalist = tList;
            adapter = new CommonAdapter(datalist, mvpView);
            listView.setAdapter(adapter);
            listView.setDividerHeight(0);
            footerView = LayoutInflater.from(getContext()).inflate(R.layout.list_footer_view, null);
            refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {
                    adapter = null;
                    currentpage = 1;
                    presenter.getdata(currentpage);
                }
            });
            listView.setOnScrollListener(new ScrollListener());
            refreshLayout.setRefreshing(false);
        } else {
            datalist.addAll(tList);
            adapter.notifyDataSetChanged();
            if (listView.getFooterViewsCount() > 0) {
                listView.removeFooterView(footerView);
            }
            loading = false;

        }
    }
    public class ScrollListener implements AbsListView.OnScrollListener{

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
                        listView.addFooterView(footerView);
                        presenter.getdata(currentpage);
                    }
                }
            }
        }
    }
}
