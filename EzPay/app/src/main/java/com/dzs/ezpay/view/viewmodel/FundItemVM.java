package com.dzs.ezpay.view.viewmodel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.dzs.ezpay.R;
import com.dzs.ezpay.common.MvpView;
import com.nupt.dzs.juheapi.model.FundModel;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/5/22.
 *
 * @version 1.0
 * @copyright by ${COMPANY}
 */
public class FundItemVM extends MvpView<FundModel> {


    @Bind(R.id.tvGoldName)
    TextView tvGoldName;
    @Bind(R.id.tvNavRate)
    TextView tvNavRate;
    @Bind(R.id.tvNavA)
    TextView tvNavA;
    @Bind(R.id.tvTime)
    TextView tvTime;
    @Bind(R.id.tvPerNav)
    TextView tvPerNav;
    @Bind(R.id.tvTotalNav)
    TextView tvTotalNav;
    @Bind(R.id.tvYesNav)
    TextView tvYesNav;
    @Bind(R.id.tvSgStatus)
    TextView tvSgStatus;
    @Bind(R.id.tvJJLX)
    TextView tvJJLX;

    public FundItemVM(Context context) {
        super(context);
    }

    private View rootview;

    @Override
    public void initview() {
        if (rootview == null) {
            rootview = LayoutInflater.from(getContext()).inflate(R.layout.item_fundation, this);
            ButterKnife.bind(this);
        }
    }

    @Override
    public void setData(FundModel model) {
        tvGoldName.setText(model.getSname()+" "+model.getSymbol());
        tvJJLX.setText(model.getJjlx());
        tvNavA.setText(model.getNav_a());
        tvNavRate.setText(model.getNav_rate());
        tvTime.setText(model.getNav_date());
        tvPerNav.setText(model.getPer_nav());
        tvTotalNav.setText(model.getTotal_nav());
        tvYesNav.setText(model.getYesterday_nav());
        tvSgStatus.setText(model.getSg_states());
        String i = model.getNav_rate().charAt(0)+"";
        if(i.equals("-")){
            tvNavRate.setText(model.getNav_rate()+"%");
            tvGoldName.setBackgroundColor(getResources().getColor(R.color.green));
            tvNavA.setTextColor(getResources().getColor(R.color.green));
            tvNavRate.setTextColor(getResources().getColor(R.color.green));
        }else if(i.equals("0")){
            tvNavRate.setText(model.getNav_rate()+"%");
            tvGoldName.setBackgroundColor(getResources().getColor(R.color.blue));
            tvNavA.setTextColor(getResources().getColor(R.color.blue_dark));
            tvNavRate.setTextColor(getResources().getColor(R.color.blue_dark));
        } else {
            tvNavA.setText("+"+model.getNav_a());
            tvNavRate.setText("+"+model.getNav_rate()+"%");
            tvGoldName.setBackgroundColor(getResources().getColor(R.color.text_color_red));
            tvNavA.setTextColor(getResources().getColor(R.color.text_color_red));
            tvNavRate.setTextColor(getResources().getColor(R.color.text_color_red));
        }

    }

    @Override
    public MvpView<FundModel> getInstance() {
        return new FundItemVM(getContext());
    }
}
