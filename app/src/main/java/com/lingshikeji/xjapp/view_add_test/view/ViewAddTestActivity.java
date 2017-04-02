package com.lingshikeji.xjapp.view_add_test.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.lingshikeji.xjapp.R;
import com.lingshikeji.xjapp.base.BaseActivity;
import com.lingshikeji.xjapp.view_add_test.frame.IViewAddTestPresenter;
import com.lingshikeji.xjapp.view_add_test.frame.IViewAddTestView;
import com.lingshikeji.xjapp.view_add_test.presenter.ViewAddTestPresenterImpl;

/**
 * <br/>Author: tony(shishaojie@koolearn.com)
 * <br/>Date: 2017/3/22 0022
 * <br/>Time: 13:38
 * <br/>Description:
 * <br/>FIXME
 */

public class ViewAddTestActivity extends BaseActivity implements IViewAddTestView {

    private IViewAddTestPresenter iViewAddTestPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
        initPresenter();
    }

    private void initView() {
        setContentView(R.layout.activity_view_add_test);
    }

    private void initData() {

    }

    private void initPresenter() {
        iViewAddTestPresenter = new ViewAddTestPresenterImpl();
        iViewAddTestPresenter.attachView(this);
//        iViewAddTestPresenter.doSubmit();
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
        hideLoadingDialog();
    }
}
