package com.lingshikeji.xjapp.login.presenter;

import com.lingshikeji.xjapp.login.frame.ILoginPresenter;
import com.lingshikeji.xjapp.login.frame.ILoginView;
import com.lingshikeji.xjapp.model.User;
import com.lingshikeji.xjapp.net.NetManager;
import com.lingshikeji.xjapp.net.ApiService;

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

public class LoginPresenterImpl extends ILoginPresenter {

    @Override
    public void attachView(ILoginView iView) {
        super.attachView(iView);
    }

    @Override
    public void detachView() {
        super.detachView();
    }

    @Override
    public void doLogin(String userName, String pwd) {
        getiView().showProgress();
        Map<String, String> params = new HashMap<>();
        params.put("identifier", userName);
        params.put("password", pwd);
        Observable<User> observable = NetManager.getInstance().getApiService().login(params);
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
                getiView().loginSuccess(user);
            }
        });

    }
}
