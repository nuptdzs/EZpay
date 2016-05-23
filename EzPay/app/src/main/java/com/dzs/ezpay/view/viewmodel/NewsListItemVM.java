package com.dzs.ezpay.view.viewmodel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.dzs.ezpay.R;
import com.dzs.ezpay.common.MvpView;
import com.dzs.ezpay.view.adapter.CommonAdapter;
import com.nupt.dzs.juheapi.model.FinNewsModel;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by dading on 2016/5/18.
 * 新闻展示页
 */
public class NewsListItemVM extends MvpView<FinNewsModel> {

    @Bind(R.id.tvTitle)
    TextView tvTitle;
    @Bind(R.id.gvImages)
    GridView gvImages;
    @Bind(R.id.tvChannelName)
    TextView tvChannelName;
    @Bind(R.id.tvTime)
    TextView tvTime;
    @Bind(R.id.tvComments)
    TextView tvComments;
    @Bind(R.id.img)
    ImageView img;
    @Bind(R.id.tvDesc)
    TextView tvDesc;

    public NewsListItemVM(Context context) {
        super(context);
    }

    private View rootView;

    @Override
    public void initview() {
        if (rootView == null) {
            rootView = LayoutInflater.from(getContext()).inflate(R.layout.news_list_item, this);
            ButterKnife.bind(this);
        }
    }

    @Override
    public void setData(FinNewsModel model) {
        tvTitle.setText(model.getTitle() + "");
        if(model.getPudDate() == null){
            model.setPudDate("");
        }
        tvTime.setText(model.getPudDate() + "");
        tvDesc.setText(model.getDesc()+"");
        if (model.getImageurls() != null && model.getImageurls().size() > 0) {
            if (model.getImageurls().size() < 3) {
                img.setVisibility(VISIBLE);
                Picasso.with(getContext().getApplicationContext()).load(model.getImageurls().get(0).getUrl()).into(img);
            } else {
                gvImages.setAdapter(new CommonAdapter<>(model.getImageurls(), new GvImageItemVM(getContext())));
                gvImages.setVisibility(VISIBLE);
            }
        } else {
            img.setVisibility(GONE);
            gvImages.setVisibility(GONE);
        }
    }

    @Override
    public MvpView<FinNewsModel> getInstance() {
        return new NewsListItemVM(getContext());
    }
}
