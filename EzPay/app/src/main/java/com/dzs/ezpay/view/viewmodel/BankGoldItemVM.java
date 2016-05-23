package com.dzs.ezpay.view.viewmodel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.dzs.ezpay.R;
import com.dzs.ezpay.common.MvpView;
import com.nupt.dzs.juheapi.model.BackGoldModel;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/5/21.
 *
 * @version 1.0
 * @copyright by ${COMPANY}
 */
public class BankGoldItemVM extends MvpView<BackGoldModel> {
    @Bind(R.id.tvGoldName)
    TextView tvGoldName;
    @Bind(R.id.tvPri)
    TextView tvPri;
    @Bind(R.id.tvQuanPri)
    TextView tvQuanPri;
    @Bind(R.id.tvTime)
    TextView tvTime;
    @Bind(R.id.tvBuyPri)
    TextView tvBuyPri;
    @Bind(R.id.tvSellPri)
    TextView tvSellPri;
    @Bind(R.id.tvMaxPri)
    TextView tvMaxPri;
    @Bind(R.id.tvMinPri)
    TextView tvMinPri;
    @Bind(R.id.tvPriYes)
    TextView tvPriYes;
    @Bind(R.id.tvPriOpenToday)
    TextView tvPriOpenToday;

    public BankGoldItemVM(Context context) {
        super(context);
    }

    private View rootView;

    @Override
    public void initview() {
        if (rootView == null) {
            rootView = LayoutInflater.from(getContext()).inflate(R.layout.item_gold_data, this);
            ButterKnife.bind(this);
        }
    }

    @Override
    public void setData(BackGoldModel model) {
        tvGoldName.setText(model.getVariety()+"");
        tvTime.setText("最近更新："+model.getTime()+"");
        tvBuyPri.setText(model.getBuypri()+"");
        tvSellPri.setText(model.getSellpri()+"");
        tvMinPri.setText(model.getMinpri()+"");
        tvMaxPri.setText(model.getMaxpri()+"");
        tvPri.setText(model.getMidpri()+"");
        tvPriYes.setText(model.getCloseyes()+"");
        tvPriOpenToday.setText(model.getTodayopen()+"");
        tvQuanPri.setText(model.getQuantpri()+"");
        String quanPri = model.getQuantpri();
        String n = quanPri.charAt(0)+"";
        if(n.equals("-")){
            tvGoldName.setBackgroundColor(getResources().getColor(R.color.green));
        }else {
            tvGoldName.setBackgroundColor(getResources().getColor(R.color.text_color_red));
        }

    }

    @Override
    public MvpView<BackGoldModel> getInstance() {
        return new BankGoldItemVM(getContext());
    }
}
