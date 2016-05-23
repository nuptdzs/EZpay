package com.dzs.ezpay.presenter;

import com.dzs.ezpay.view.impl.IListView;
import com.nupt.dzs.juheapi.model.HuoBiModel;
import com.nupt.dzs.juheapi.model.JuHeApiResponse;
import com.nupt.dzs.juheapi.utils.JuHeApiClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2016/5/22.
 *
 * @version 1.0
 * @copyright by ${COMPANY}
 */
public class HuoBiPresenter {
    private IListView<HuoBiModel> iListView;
    public HuoBiPresenter(IListView<HuoBiModel> view){
        iListView = view;
    }

    public void getData(){
        JuHeApiClient.queryRMB()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JuHeApiResponse<Map<String, HuoBiModel>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(JuHeApiResponse<Map<String, HuoBiModel>> mapJuHeApiResponse) {
                        List<HuoBiModel> models = new ArrayList<HuoBiModel>();
                        for(HuoBiModel huoBiModel :mapJuHeApiResponse.getResult().get(0).values()){
                            models.add(huoBiModel);
                        }
                        iListView.loadList(models);
                    }
                });
    }
}
