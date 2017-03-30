package com.lingshikeji.xjapp.register.presenter;

import com.lingshikeji.xjapp.model.User;
import com.lingshikeji.xjapp.net.NetManager;
import com.lingshikeji.xjapp.register.frame.IRegisterPresenter;
import com.lingshikeji.xjapp.register.frame.IRegisterView;

import java.util.HashMap;
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

public class RegisterPresenterImpl extends IRegisterPresenter {

    @Override
    public void attachView(IRegisterView iView) {
        super.attachView(iView);
    }

    @Override
    public void detachView() {
        super.detachView();
    }

    @Override
    public void register(String email, String pwd) {
        getiView().showProgress();
        Map<String, String> params = new HashMap<>();
        params.put("username", email);
        params.put("email", email);
        params.put("password", pwd);
        Observable<User> observable = NetManager.getInstance().getApiService().register(params);
        NetManager.getInstance().runRxJava(observable, new Subscriber<User>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                getiView().hideProgress();
                getiView().toast(e.getMessage());
            }

            @Override
            public void onNext(User user) {
                getiView().hideProgress();
                getiView().registerSuccess(user);
            }
        });
    }
}
