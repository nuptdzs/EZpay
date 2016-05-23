package com.dzs.ezpay.presenter;

import com.dzs.ezpay.R;
import com.dzs.ezpay.model.FunctionModel;
import com.dzs.ezpay.view.activity.FundationListActivity;
import com.dzs.ezpay.view.activity.GoldDataListActivity;
import com.dzs.ezpay.view.activity.H5Activity;
import com.dzs.ezpay.view.activity.SharesActivity;
import com.dzs.ezpay.view.impl.IFinView;
import com.dzs.ezpay.view.impl.IFunctionsView;
import com.nupt.dzs.juheapi.model.FinNewsModel;
import com.nupt.dzs.juheapi.model.ShowApiResponse;
import com.nupt.dzs.juheapi.utils.BaiduApiClient;

import java.util.ArrayList;
import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class FinFragmentPresenter {
    private IFinView finFragment;
    public FinFragmentPresenter(IFinView iFunctionsView){
        finFragment = iFunctionsView;
    }

    public void setFunctions(){
        List<FunctionModel> functionModels = new ArrayList<>();
        functionModels.add(new FunctionModel(0,"金银", R.mipmap.icon_func_jinyin,"key" ,GoldDataListActivity.class));
        functionModels.add(new FunctionModel(1,"股市",R.mipmap.icon_func_gushi,"key" ,SharesActivity.class));
        functionModels.add(new FunctionModel(2,"基金",R.mipmap.icon_func_jijin,"key" ,FundationListActivity.class));
        functionModels.add(new FunctionModel(3,"货币",R.mipmap.icon_func_huobi,"http://q.m.hexun.com/forex/rate_302.html" ,H5Activity.class));
        finFragment.loadFunctions(functionModels);
    }

    public void getNews(int page){
        BaiduApiClient.getFinNews(page)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<ShowApiResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(ShowApiResponse finNewsModelShowApiResponse) {
                        finFragment.loadNews(finNewsModelShowApiResponse.getShowapi_res_body().getPagebean().getContentlist());
                    }
                });
    }
}
