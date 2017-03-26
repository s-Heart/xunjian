package com.lingshikeji.xjapp.test.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.lingshikeji.xjapp.R;
import com.lingshikeji.xjapp.base.BaseActivity;
import com.lingshikeji.xjapp.test.frame.ITestPresenter;
import com.lingshikeji.xjapp.test.frame.ITestView;
import com.lingshikeji.xjapp.test.presenter.TestPresenterImpl;

/**
 * <br/>Author: tony(shishaojie@koolearn.com)
 * <br/>Date: 2017/3/22 0022
 * <br/>Time: 13:38
 * <br/>Description:
 * <br/>FIXME
 */

public class TestActivity extends BaseActivity implements ITestView {

    private ITestPresenter iTestPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
        initPresenter();
    }

    private void initView() {
        setContentView(R.layout.activity_test);
    }

    private void initData() {

    }

    private void initPresenter() {
        iTestPresenter = new TestPresenterImpl();
        iTestPresenter.attachView(this);
//        iTestPresenter.doSubmit();
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
        showLoadingDialog();
    }

    @Override
    public void hideProgress() {
        dismissLoadingDialog();
    }
}
