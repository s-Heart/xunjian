package com.lingshikeji.xjapp.view_add_test.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.lingshikeji.xjapp.R;
import com.lingshikeji.xjapp.base.BaseActivity;
import com.lingshikeji.xjapp.register.view.RegisterActivity;
import com.lingshikeji.xjapp.view_add_test.frame.IViewAddTestedPresenter;
import com.lingshikeji.xjapp.view_add_test.frame.IViewAddTestedView;
import com.lingshikeji.xjapp.view_add_test.presenter.ViewAddTestedPresenterImpl;

/**
 * <br/>Author: tony(shishaojie@koolearn.com)
 * <br/>Date: 2017/3/22 0022
 * <br/>Time: 13:38
 * <br/>Description:
 * <br/>FIXME
 */

public class ViewAddTestedActivity extends BaseActivity implements IViewAddTestedView {

    private IViewAddTestedPresenter iViewAddTestedPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
        initPresenter();
    }

    private void initView() {
        setContentView(R.layout.activity_view_add_tested);
    }

    private void initData() {

    }

    private void initPresenter() {
        iViewAddTestedPresenter = new ViewAddTestedPresenterImpl();
        iViewAddTestedPresenter.attachView(this);
//        iViewAddTestedPresenter.doSubmit();
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
