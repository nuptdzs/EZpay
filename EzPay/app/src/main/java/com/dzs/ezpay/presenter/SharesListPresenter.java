package com.dzs.ezpay.presenter;

import android.content.Intent;

import com.dzs.ezpay.view.activity.SharesDetailActivity;
import com.dzs.ezpay.view.impl.IListView;
import com.nupt.dzs.juheapi.model.JuHeApiResponse;
import com.nupt.dzs.juheapi.model.JuHePageResponse;
import com.nupt.dzs.juheapi.model.SharesDetailModel;
import com.nupt.dzs.juheapi.model.SharesModel;
import com.nupt.dzs.juheapi.utils.JuHeApiClient;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2016/5/21.
 *
 * @version 1.0
 * @copyright by ${COMPANY}
 */
public class SharesListPresenter  {
    private IListView<SharesModel> iListView;
    public SharesListPresenter(IListView<SharesModel> iListView){
        this.iListView = iListView;
    }
    public void getSharesList(int page,int which){
        JuHeApiClient.getSharesList(which,page,0)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JuHePageResponse<SharesModel>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(JuHePageResponse<SharesModel> sharesModelJuHePageResponse) {
                        iListView.loadList(sharesModelJuHePageResponse.getResult().getData());
                    }
                });
    }

    public void getShareDetail(String name){
        iListView.showLoading("正在加载");
        JuHeApiClient.querySharesDetail(name)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JuHeApiResponse<SharesDetailModel>>() {
                    @Override
                    public void onCompleted() {
                        iListView.hideLoading();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(JuHeApiResponse<SharesDetailModel> sharesDetailModelJuHeApiResponse) {
                        Intent intent = new Intent(iListView.getContext(), SharesDetailActivity.class);
                        intent.putExtra("data",sharesDetailModelJuHeApiResponse.getResult().get(0));
                        iListView.getContext().startActivity(intent);
                    }
                });
    }
}
