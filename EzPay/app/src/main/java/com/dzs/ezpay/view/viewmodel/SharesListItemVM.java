package com.dzs.ezpay.view.viewmodel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.dzs.ezpay.R;
import com.dzs.ezpay.common.MvpView;
import com.nupt.dzs.juheapi.model.SharesModel;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/5/21.
 *
 * @version 1.0
 * @copyright by ${COMPANY}
 */
public class SharesListItemVM extends MvpView<SharesModel> {
    @Bind(R.id.tvName)
    TextView tvName;
    @Bind(R.id.tvId)
    TextView tvId;
    @Bind(R.id.tvTrade)
    TextView tvTrade;
    @Bind(R.id.tvChangePercent)
    TextView tvChangePercent;
    private View rootView;

    public SharesListItemVM(Context context) {
        super(context);
    }

    @Override
    public void initview() {
        if (rootView == null) {
            rootView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_shares, this);
            ButterKnife.bind(this);
        }
    }

    @Override
    public void setData(SharesModel model) {
        tvName.setText(model.getName()+"");
        tvChangePercent.setText(model.getChangepercent()+"");
        tvId.setText(model.getCode()+"");
        tvTrade.setText(model.getTrade()+"");
        String n = model.getChangepercent().charAt(0)+"";
        if(n.equals("-")){
           tvChangePercent.setTextColor(getResources().getColor(R.color.green));
        }else {
            tvChangePercent.setTextColor(getResources().getColor(R.color.text_color_red));

        }
    }

    @Override
    public MvpView<SharesModel> getInstance() {
        return new SharesListItemVM(getContext());
    }
}
