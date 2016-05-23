package com.dzs.ezpay.view.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.dzs.ezpay.R;
import com.dzs.ezpay.common.BaseFragment;
import com.dzs.ezpay.model.FunctionModel;
import com.dzs.ezpay.presenter.LifeFragmentPresenter;
import com.dzs.ezpay.view.adapter.CommonAdapter;
import com.dzs.ezpay.view.customview.MyGridView;
import com.dzs.ezpay.view.impl.IFunctionsView;
import com.dzs.ezpay.view.viewmodel.FunctionItemVM;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 生活模块
 */
public class MenuLifeFragment extends BaseFragment implements IFunctionsView {


    @Bind(R.id.gvFuncs)
    MyGridView gvFuncs;
    private LifeFragmentPresenter presenter;

    public MenuLifeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_menu_life, container, false);
        }
        ButterKnife.bind(this, rootView);
        initView();
        return rootView;
    }

    @Override
    protected void initView() {
        presenter = new LifeFragmentPresenter(this);
        presenter.setFunctions();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void loadFunctions(final List<FunctionModel> functionModels) {
        gvFuncs.setAdapter(new CommonAdapter<>(functionModels, new FunctionItemVM(getContext())));
        gvFuncs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                intent.putExtra("data",functionModels.get(position).getData());
                intent.setClass(getContext(),functionModels.get(position).getActivity());
                startActivity(intent);
            }
        });
    }
}
