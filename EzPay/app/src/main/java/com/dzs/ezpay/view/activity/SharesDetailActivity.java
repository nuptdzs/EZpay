package com.dzs.ezpay.view.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.dzs.ezpay.R;
import com.dzs.ezpay.common.BaseActivity;
import com.nupt.dzs.juheapi.model.SharesDetailModel;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SharesDetailActivity extends BaseActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.tvPri)
    TextView tvPri;
    @Bind(R.id.tvIncrease)
    TextView tvIncrease;
    @Bind(R.id.tvIncrePer)
    TextView tvIncrePer;
    @Bind(R.id.tvPriOpenToday)
    TextView tvPriOpenToday;
    @Bind(R.id.tvPriYes)
    TextView tvPriYes;
    @Bind(R.id.tvTraNumber)
    TextView tvTraNumber;
    @Bind(R.id.tvNowPic)
    TextView tvNowPic;
    @Bind(R.id.tvTodayMax)
    TextView tvTodayMax;
    @Bind(R.id.tvTodayMin)
    TextView tvTodayMin;
    @Bind(R.id.tvAvgPri)
    TextView tvAvgPri;
    @Bind(R.id.tvCompetitivePri)
    TextView tvCompetitivePri;
    @Bind(R.id.tvRate)
    TextView tvRate;
    @Bind(R.id.tvDot)
    TextView tvDot;
    @Bind(R.id.tvTraAmount)
    TextView tvTraAmount;
    @Bind(R.id.tvReservePri)
    TextView tvReservePri;
    @Bind(R.id.imgPicture)
    ImageView imgPicture;
    @Bind(R.id.tvBuyOnePri)
    TextView tvBuyOnePri;
    @Bind(R.id.tvBuyOne)
    TextView tvBuyOne;
    @Bind(R.id.tvBuyTwoPri)
    TextView tvBuyTwoPri;
    @Bind(R.id.tvBuyTwo)
    TextView tvBuyTwo;
    @Bind(R.id.tvBuyOneThree)
    TextView tvBuyOneThree;
    @Bind(R.id.tvBuyThree)
    TextView tvBuyThree;
    @Bind(R.id.tvBuyFourPri)
    TextView tvBuyFourPri;
    @Bind(R.id.tvBuyFour)
    TextView tvBuyFour;
    @Bind(R.id.tvBuyFivePri)
    TextView tvBuyFivePri;
    @Bind(R.id.tvBuyFive)
    TextView tvBuyFive;
    @Bind(R.id.tvSellOnePri)
    TextView tvSellOnePri;
    @Bind(R.id.tvSellOne)
    TextView tvSellOne;
    @Bind(R.id.tvSellTwoPri)
    TextView tvSellTwoPri;
    @Bind(R.id.tvSellTwo)
    TextView tvSellTwo;
    @Bind(R.id.tvBuySellThree)
    TextView tvBuySellThree;
    @Bind(R.id.tvSellThree)
    TextView tvSellThree;
    @Bind(R.id.tvSellFourPri)
    TextView tvSellFourPri;
    @Bind(R.id.tvSellFour)
    TextView tvSellFour;
    @Bind(R.id.tvSellFivePri)
    TextView tvSellFivePri;
    @Bind(R.id.tvSellFive)
    TextView tvSellFive;
    @Bind(R.id.rgPics)
    RadioGroup rgPics;
    @Bind(R.id.tvTime)
    TextView tvTime;
    @Bind(R.id.rbMinPic)
    RadioButton rbMinPic;
    @Bind(R.id.rbDayPic)
    RadioButton rbDayPic;
    @Bind(R.id.rbWeekPic)
    RadioButton rbWeekPic;
    @Bind(R.id.rbMonthPic)
    RadioButton rbMonthPic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shares_detail);
        ButterKnife.bind(this);
        initdata();
    }

    public void initdata() {
        final SharesDetailModel model = (SharesDetailModel) getIntent().getSerializableExtra("data");
        setTitle(toolbar, model.data.name + "(" + model.data.gid + ")");
        tvPri.setText(model.data.nowPri + "");
        tvTodayMax.setText(model.data.todayMax + "");
        tvTodayMin.setText(model.data.todayMin + "");
        tvPriOpenToday.setText(model.data.todayStartPri + "");
        tvPriYes.setText(model.data.yestodEndPri + "");
        tvTraNumber.setText(model.dapandata.traNumber);
        tvTraAmount.setText(model.dapandata.traAmount);
        tvDot.setText(model.dapandata.dot);
        tvRate.setText(model.dapandata.rate + "%");
        tvReservePri.setText(model.data.reservePri + "");
        tvCompetitivePri.setText(model.data.competitivePri + "");
        tvBuyOne.setText(model.data.buyOne + "");
        tvBuyOnePri.setText(model.data.buyOnePri + "");
        tvBuyTwo.setText(model.data.buyTwo + "");
        tvBuyTwoPri.setText(model.data.buyTwoPri + "");
        tvBuyThree.setText(model.data.buyThree + "");
        tvBuyOneThree.setText(model.data.buyThreePri + "");
        tvBuyFour.setText(model.data.buyFour + "");
        tvBuyFourPri.setText(model.data.buyFourPri + "");
        tvBuyFive.setText(model.data.buyFive + "");
        tvBuyFivePri.setText(model.data.buyFivePri + "");
        tvSellOne.setText(model.data.sellOne + "");
        tvSellOnePri.setText(model.data.sellOnePri + "");
        tvSellTwo.setText(model.data.sellTwo + "");
        tvSellTwoPri.setText(model.data.sellTwoPri + "");
        tvSellThree.setText(model.data.sellThree + "");
        tvBuySellThree.setText(model.data.sellThreePri + "");
        tvSellFour.setText(model.data.sellFour + "");
        tvSellFourPri.setText(model.data.sellFourPri + "");
        tvSellFive.setText(model.data.sellFive + "");
        tvSellFivePri.setText(model.data.sellFivePri + "");
        tvTime.setText(model.data.date+" "+model.data.time);
        rgPics.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rbMinPic:
                        Picasso.with(getContext()).load(model.gopicture.getMinurl()).into(imgPicture);
                        break;
                    case R.id.rbDayPic:
                        Picasso.with(getContext()).load(model.gopicture.getDayurl()).into(imgPicture);

                        break;
                    case R.id.rbWeekPic:
                        Picasso.with(getContext()).load(model.gopicture.getWeekurl()).into(imgPicture);
                        break;
                    case R.id.rbMonthPic:
                        Picasso.with(getContext()).load(model.gopicture.getMonthurl()).into(imgPicture);
                        break;
                }
            }
        });
        tvIncrease.setText(model.data.increase + "");
        tvIncrePer.setText(model.data.increPer + "%");
        String i = model.data.increase.charAt(0) + "";
        if (i.equals("-")) {
            tvIncrePer.setTextColor(getResources().getColor(R.color.green));
            tvPri.setTextColor(getResources().getColor(R.color.green));
            tvIncrease.setTextColor(getResources().getColor(R.color.green));
        } else {
            tvIncrePer.setTextColor(getResources().getColor(R.color.text_color_red));
            tvPri.setTextColor(getResources().getColor(R.color.text_color_red));
            tvIncrease.setTextColor(getResources().getColor(R.color.text_color_red));
        }
        Picasso.with(getContext()).load(model.gopicture.getMinurl()).into(imgPicture);

    }
}
