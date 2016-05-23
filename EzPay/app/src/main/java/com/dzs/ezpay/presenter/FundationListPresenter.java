package com.dzs.ezpay.presenter;

import com.dzs.ezpay.common.RefreshableListActivity;
import com.dzs.ezpay.view.impl.IListView;
import com.nupt.dzs.juheapi.model.FundModel;
import com.nupt.dzs.juheapi.model.JuHeApiResponse;
import com.nupt.dzs.juheapi.utils.JuHeApiClient;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by dading on 2016/5/22.
 *
 * @version 1.0
 */
public class FundationListPresenter implements RefreshableListActivity.ListPresenter{
    IListView<FundModel> iListView;
    public FundationListPresenter(IListView<FundModel> view){
        iListView = view;
    }

    public void getdata(int page){
        JuHeApiClient.queryFundList(page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JuHeApiResponse<FundModel>>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        iListView.showToast("error:"+e.getMessage());
                    }

                    @Override
                    public void onNext(JuHeApiResponse<FundModel> fundModelJuHeApiResponse) {
                        iListView.loadList(fundModelJuHeApiResponse.getResult());
                    }
                });
    }
}
