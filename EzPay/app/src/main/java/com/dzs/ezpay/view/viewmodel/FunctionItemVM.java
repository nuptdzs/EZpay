package com.dzs.ezpay.view.viewmodel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.dzs.ezpay.R;
import com.dzs.ezpay.common.MvpView;
import com.dzs.ezpay.model.FunctionModel;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/4/27.
 *
 * @version 1.0
 * @copyright by ${COMPANY}
 */
public class FunctionItemVM extends MvpView<FunctionModel> {
    @Bind(R.id.imgFunctionIcon)
    ImageView imgFunctionIcon;
    @Bind(R.id.tvFuncName)
    TextView tvFuncName;

    public FunctionItemVM(Context context) {
        super(context);
    }

    private View rootView;

    @Override
    public void initview() {
        if (rootView == null) {
            rootView = LayoutInflater.from(getContext()).inflate(R.layout.item_funcs, this);
            ButterKnife.bind(this);
        }
    }

    @Override
    public void setData(FunctionModel model) {
        imgFunctionIcon.setImageResource(model.getFunIconRes());
        tvFuncName.setText(model.getFuncName());
    }

    @Override
    public MvpView<FunctionModel> getInstance() {
        return new FunctionItemVM(getContext());
    }
}
