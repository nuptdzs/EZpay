package com.dzs.ezpay.view.viewmodel;

import android.content.Context;
import android.widget.ImageView;

import com.dzs.ezpay.common.MvpView;
import com.nupt.dzs.juheapi.model.FinNewsModel;
import com.squareup.picasso.Picasso;

/**
 * Created by dading on 2016/5/18.
 * gridview展示图片的适配器
 * @version 1.0
 * @copyright by ${COMPANY}
 */
public class GvImageItemVM extends MvpView<FinNewsModel.ImageUrl> {
    public GvImageItemVM(Context context) {
        super(context);
    }

    private ImageView imageView;
    @Override
    public void initview() {
        imageView = new ImageView(getContext());
        addView(imageView);
    }

    @Override
    public void setData(FinNewsModel.ImageUrl model) {
        Picasso.with(getContext()).load(model.getUrl()).into(imageView);
    }

    @Override
    public MvpView<FinNewsModel.ImageUrl> getInstance() {
        return this;
    }
}
