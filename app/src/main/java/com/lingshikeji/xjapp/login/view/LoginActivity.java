package com.lingshikeji.xjapp.login.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;

import com.lingshikeji.xjapp.R;
import com.lingshikeji.xjapp.login.frame.ILoginPresenter;
import com.lingshikeji.xjapp.login.frame.ILoginView;
import com.lingshikeji.xjapp.login.presenter.LoginPresenterImpl;

/**
 * <br/>Author: tony(shishaojie@koolearn.com)
 * <br/>Date: 2017/3/22 0022
 * <br/>Time: 13:38
 * <br/>Description:
 * <br/>FIXME
 */

public class LoginActivity extends Activity implements ILoginView {

    private ILoginPresenter iLoginPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
        initPresenter();
    }

    private void initView() {
        setContentView(R.layout.activity_login);
    }

    private void initData() {

    }

    private void initPresenter() {
        iLoginPresenter = new LoginPresenterImpl();
        iLoginPresenter.attachView(this);
//        iLoginPresenter.doSubmit();
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public void toast(String str) {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }
}
