package com.dzs.ezpay.view.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

import com.dzs.ezpay.R;
import com.dzs.ezpay.common.BaseFragment;
import com.dzs.ezpay.model.FunctionModel;
import com.dzs.ezpay.presenter.FinFragmentPresenter;
import com.dzs.ezpay.view.activity.H5Activity;
import com.dzs.ezpay.view.adapter.CommonAdapter;
import com.dzs.ezpay.view.customview.MyGridView;
import com.dzs.ezpay.view.impl.IFinView;
import com.dzs.ezpay.view.viewmodel.FunctionItemVM;
import com.dzs.ezpay.view.viewmodel.NewsListItemVM;
import com.nupt.dzs.juheapi.model.FinNewsModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 理财模块
 */
public class MenuFinFragment extends BaseFragment implements IFinView {


    @Bind(R.id.gvFuncs)
    MyGridView gvFuncs;
    @Bind(R.id.lvNewsList)
    ListView lvNewsList;
    @Bind(R.id.refreshLayout)
    SwipeRefreshLayout refreshLayout;
    private View footerView;

    public MenuFinFragment() {
        // Required empty public constructor
    }

    private FinFragmentPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_menu_fin, container, false);
        }
        ButterKnife.bind(this, rootView);
        initView();
        return rootView;
    }

    int currentPage = 1;

    /**
     * 加载展示器，并进行数据展示操作
     */
    @Override
    protected void initView() {
        presenter = new FinFragmentPresenter(this);
        presenter.setFunctions();
        presenter.getNews(currentPage);
    }

    /**
     * 加载顶部功能按键
     *
     * @param functionModels
     */
    @Override
    public void loadFunctions(final List<FunctionModel> functionModels) {
        gvFuncs.setAdapter(new CommonAdapter<>(functionModels, new FunctionItemVM(getContext())));
        gvFuncs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                intent.putExtra("data", functionModels.get(position).getData());
                intent.setClass(getContext(), functionModels.get(position).getActivity());
                startActivity(intent);
            }
        });
    }

    /**
     * 接触view的关联
     */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    CommonAdapter adapter;
    List<FinNewsModel> newsModels = new ArrayList<>();

    /**
     * 将获取的数据加载进入listview进行展示，并设置item点击事件跳转详情界面，加载源网页信息
     *
     * @param models
     */
    @Override
    public void loadNews(final List<FinNewsModel> models) {
        if (adapter == null) {
            newsModels = models;
            adapter = new CommonAdapter<>(newsModels, new NewsListItemVM(getContext()));
            lvNewsList.setAdapter(adapter);
            footerView = LayoutInflater.from(getContext()).inflate(R.layout.list_footer_view, null);
            lvNewsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(getContext(), H5Activity.class);
                    intent.putExtra("data", models.get(position).getLink());
                    startActivity(intent);
                }
            });
            refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {
                    adapter = null;
                    currentPage = 1;
                    presenter.getNews(currentPage);
                }
            });
            refreshLayout.setRefreshing(false);
            lvNewsList.setOnScrollListener(new ScrollListener());
        } else {
            newsModels.addAll(models);
            adapter.notifyDataSetChanged();
            if (lvNewsList.getFooterViewsCount() > 0) {
                lvNewsList.removeFooterView(footerView);
            }
            loading = false;
        }

    }

    private boolean loading = false;

    /**
     * 滑动事件监听 滑动到底部自动加载
     */
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
                        currentPage++;
                        lvNewsList.addFooterView(footerView);
                        presenter.getNews(currentPage);
                    }
                }
            }
        }
    }
}
