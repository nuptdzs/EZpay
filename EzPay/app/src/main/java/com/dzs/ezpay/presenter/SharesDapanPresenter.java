package com.dzs.ezpay.presenter;

import com.dzs.ezpay.view.impl.ISharesDapanView;
import com.nupt.dzs.juheapi.api.JuHeApi;
import com.nupt.dzs.juheapi.model.HSsharesModel;
import com.nupt.dzs.juheapi.model.JuHeResponse;
import com.nupt.dzs.juheapi.utils.JuHeApiClient;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
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
public class SharesDapanPresenter{
    private ISharesDapanView view;
    public SharesDapanPresenter(ISharesDapanView iSharesDapanView){
        view = iSharesDapanView;
    }
    List<HSsharesModel> models = new ArrayList<>();
    public void getSharesDapan(){
        models.clear();
        JuHeApiClient.getHSzhishu(0)
                .subscribeOn(Schedulers.io())
                .flatMap(new Func1<JuHeResponse<HSsharesModel>, Observable<JuHeResponse<HSsharesModel>>>() {
                    @Override
                    public Observable<JuHeResponse<HSsharesModel>> call(JuHeResponse<HSsharesModel> hSsharesModelJuHeResponse) {
                        models.add(hSsharesModelJuHeResponse.getResult());
                        return JuHeApiClient.getHSzhishu(1);
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JuHeResponse<HSsharesModel>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(JuHeResponse<HSsharesModel> hSsharesModelJuHeResponse) {
                        models.add(hSsharesModelJuHeResponse.getResult());
                        view.loadList(models);
                    }
                });
    }
}
