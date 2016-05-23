package com.dzs.ezpay.presenter;

import com.dzs.ezpay.view.impl.IGoldListView;
import com.nupt.dzs.juheapi.model.BackGoldModel;
import com.nupt.dzs.juheapi.model.BankGoldListModel;
import com.nupt.dzs.juheapi.model.JuHeApiResponse;
import com.nupt.dzs.juheapi.utils.JuHeApiClient;

import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;


/**
 * Created by Administrator on 2016/5/21.
 *
 * @version 1.0
 * @copyright by ${COMPANY}
 */
public class GoldDataListPresenter {
    private IGoldListView iGoldListView;
    public GoldDataListPresenter(IGoldListView iGoldListView){
        this.iGoldListView = iGoldListView;
    }
    public void getData(){
        JuHeApiClient.getBackGoldListModel()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Func1<JuHeApiResponse<BankGoldListModel>, List<BackGoldModel>>() {
                    @Override
                    public List<BackGoldModel> call(JuHeApiResponse<BankGoldListModel> bankGoldListModelJuHeApiResponse) {
                        if(bankGoldListModelJuHeApiResponse.getResult()!=null&&bankGoldListModelJuHeApiResponse.getResult().size()>0){
                            return bankGoldListModelJuHeApiResponse.getResult().get(0).formList();
                        }else {
                            return null;
                        }
                    }
                })
                .subscribe(new Observer<List<BackGoldModel>>() {
                    @Override
                    public void onCompleted() {
                        iGoldListView.hideLoading();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<BackGoldModel> models) {
                        iGoldListView.loadList(models);
                    }
                });
    }
}
