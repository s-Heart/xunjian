package com.lingshikeji.xjapp.tested_mgr.presenter;

import com.lingshikeji.xjapp.model.DeviceEntity;
import com.lingshikeji.xjapp.model.User;
import com.lingshikeji.xjapp.net.NetManager;
import com.lingshikeji.xjapp.tested_mgr.frame.ITestedMgrPresenter;
import com.lingshikeji.xjapp.tested_mgr.frame.ITestedMgrView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import rx.Observable;
import rx.Subscriber;

/**
 * <br/>Author: tony(shishaojie@koolearn.com)
 * <br/>Date: 2017/3/22 0022
 * <br/>Time: 13:42
 * <br/>Description:
 * <br/>FIXME
 */

public class TestedMgrPresenterImpl extends ITestedMgrPresenter {

    @Override
    public void attachView(ITestedMgrView iView) {
        super.attachView(iView);
    }

    @Override
    public void detachView() {
        super.detachView();
    }

    @Override
    public void queryDevices() {
        getiView().showProgress();
        Map<String, String> params = new HashMap<>();
        params.put("sort", "id desc");
        params.put("limit", "8");//返回前8条数据
        Observable<List<DeviceEntity>> observable = NetManager.getInstance().getApiService().queryDevices(params);
        NetManager.getInstance().runRxJava(observable, new Subscriber<List<DeviceEntity>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                getiView().hideProgress();
                getiView().toast(e.getMessage());
            }

            @Override
            public void onNext(List<DeviceEntity> devices) {
                getiView().hideProgress();
                getiView().querySuccess(devices);
            }
        });
    }

    @Override
    public void queryDevicePage(int currentLastItemIndex) {
        getiView().showProgress();
        Map<String, String> params = new HashMap<>();
        params.put("sort", "id desc");
        params.put("skip", "" + currentLastItemIndex);
        params.put("limit", "8");
        Observable<List<DeviceEntity>> observable = NetManager.getInstance().getApiService().queryDeviceForPage(params);
        NetManager.getInstance().runRxJava(observable, new Subscriber<List<DeviceEntity>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                getiView().hideProgress();
                getiView().toast(e.getMessage());
            }

            @Override
            public void onNext(List<DeviceEntity> devices) {
                getiView().hideProgress();
                getiView().queryPageSuccess(devices);
            }
        });
    }
}
