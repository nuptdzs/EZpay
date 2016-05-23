package com.dzs.ezpay.view.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dzs.ezpay.R;
import com.dzs.ezpay.common.BaseFragment;
import com.dzs.ezpay.model.FunctionModel;
import com.dzs.ezpay.presenter.PayFragmentPresenter;
import com.dzs.ezpay.view.adapter.CommonAdapter;
import com.dzs.ezpay.view.customview.MyGridView;
import com.dzs.ezpay.view.impl.IFunctionsView;
import com.dzs.ezpay.view.impl.IPayFragment;
import com.dzs.ezpay.view.viewmodel.FunctionItemVM;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class MenuPayFragment extends BaseFragment implements IFunctionsView {


    @Bind(R.id.gvFuncs)
    MyGridView gvFuncs;
    @Bind(R.id.tvDay)
    TextView tvDay;
    @Bind(R.id.tvWeekDay)
    TextView tvWeekDay;
    @Bind(R.id.tvOutPay)
    TextView tvOutPay;
    @Bind(R.id.tvInCome)
    TextView tvInCome;
    @Bind(R.id.tvAccountTip)
    TextView tvAccountTip;
    @Bind(R.id.llTakeAccount)
    LinearLayout llTakeAccount;

    public MenuPayFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_menu_pay, container, false);
        }
        ButterKnife.bind(this, rootView);
        initView();
        return rootView;
    }

    PayFragmentPresenter presenter ;
    @Override
    protected void initView() {
        presenter = new PayFragmentPresenter(this);
        presenter.setFuncions();
    }

    @Override
    public void loadFunctions(final List<FunctionModel> functionModelList) {
        gvFuncs.setAdapter(new CommonAdapter<>(functionModelList, new FunctionItemVM(getContext())));
        gvFuncs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                intent.putExtra("data",functionModelList.get(position).getData());
                intent.setClass(getContext(),functionModelList.get(position).getActivity());
                startActivity(intent);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick(R.id.llTakeAccount)
    public void onClick() {

    }
}
