package com.dzs.ezpay.view.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.dzs.ezpay.R;
import com.dzs.ezpay.common.MvpView;
import com.dzs.ezpay.view.activity.SharesListActivity;
import com.nupt.dzs.juheapi.model.HSsharesModel;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/5/21.
 * 沪深大盘指数
 */
public class SharesDapanItemVM extends MvpView<HSsharesModel> {
    @Bind(R.id.tvGoldName)
    TextView tvGoldName;
    @Bind(R.id.tvLookMore)
    TextView tvLookMore;
    @Bind(R.id.tvPri)
    TextView tvPri;
    @Bind(R.id.tvIncrePer)
    TextView tvIncrePer;
    @Bind(R.id.tvIncrease)
    TextView tvIncrease;
    @Bind(R.id.tvTime)
    TextView tvTime;
    @Bind(R.id.tvDealNum)
    TextView tvDealNum;
    @Bind(R.id.tvDealPri)
    TextView tvDealPri;
    @Bind(R.id.tvMaxPri)
    TextView tvMaxPri;
    @Bind(R.id.tvMinPri)
    TextView tvMinPri;
    @Bind(R.id.tvPriYes)
    TextView tvPriYes;
    @Bind(R.id.tvPriOpenToday)
    TextView tvPriOpenToday;
    private View rootView;

    public SharesDapanItemVM(Context context) {
        super(context);
    }

    @Override
    public void initview() {
        if (rootView == null) {
            rootView = LayoutInflater.from(getContext()).inflate(R.layout.item_hs_dapan, this);
            ButterKnife.bind(this);
        }
    }

    @Override
    public void setData(final HSsharesModel model) {
        tvDealNum.setText(model.getDealNum()+"");
        tvDealPri.setText(model.getDealPri()+"");
        tvGoldName.setText(model.getName()+"");
        tvIncrease.setText(model.getIncrease()+"");
        tvIncrePer.setText(model.getIncrePer()+"%");
        tvTime.setText("更新时间："+model.getTime()+"");
        tvMaxPri.setText(model.getHighPri()+"");
        tvMinPri.setText(model.getLowpri()+"");
        tvPriYes.setText(model.getYesPri()+"");
        tvPriOpenToday.setText(model.getOpenPri()+"");
        tvPri.setText(model.getNowpri()+"");
        String i = model.getIncrePer().charAt(0)+"";
        if(i.equals("-")){
            setColor(false);
        }else {
            setColor(true);
        }
        tvLookMore.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), SharesListActivity.class);
                if(model.getName().equals("上证指数")){
                    intent.putExtra("type",0);
                }else {
                    intent.putExtra("type",1);
                }
                getContext().startActivity(intent);
            }
        });
    }

    private void setColor(boolean isIncrease){
        if(isIncrease){
            tvPri.setTextColor(getResources().getColor(R.color.text_color_red));
            tvIncrePer.setTextColor(getResources().getColor(R.color.text_color_red));
            tvIncrease.setTextColor(getResources().getColor(R.color.text_color_red));
        }else {
            tvPri.setTextColor(getResources().getColor(R.color.green));
            tvIncrePer.setTextColor(getResources().getColor(R.color.green));
            tvIncrease.setTextColor(getResources().getColor(R.color.green));
        }
    }
    @Override
    public MvpView<HSsharesModel> getInstance() {
        return new SharesDapanItemVM(getContext());
    }
}
