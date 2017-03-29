package com.lingshikeji.xjapp.login.presenter;

import android.util.Log;

import com.google.gson.Gson;
import com.lingshikeji.xjapp.login.frame.ILoginPresenter;
import com.lingshikeji.xjapp.login.frame.ILoginView;
import com.lingshikeji.xjapp.model.User;
import com.lingshikeji.xjapp.net.api_service.LoginService;
import com.lingshikeji.xjapp.net.NetManager;
import com.lingshikeji.xjapp.net.uicallback.ServerException;

import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okio.BufferedSink;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.HttpException;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

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
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(NetManager.BASE_URL_DEV)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        LoginService loginService = retrofit.create(LoginService.class);
        Map<String, String> params = new HashMap<>();
        params.put("identifier", userName);
        params.put("password", pwd);
        String payload = new Gson().toJson(params);
        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), payload);
        loginService.login(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<User>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        ResponseBody body = ((HttpException) throwable).response().errorBody();
                        try {
                            JSONObject response = new JSONObject(body.string());
                            String msg = (String) response.get("message");
                            getiView().toast(msg);
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }

                    }

                    @Override
                    public void onNext(User user) {
                        Log.d("rx", "success");
                        getiView().loginSuccess(user);
                    }
                });
    }
}
