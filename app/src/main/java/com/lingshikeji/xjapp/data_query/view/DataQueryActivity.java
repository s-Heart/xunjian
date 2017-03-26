package com.lingshikeji.xjapp.data_query.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.lingshikeji.xjapp.R;
import com.lingshikeji.xjapp.base.BaseActivity;
import com.lingshikeji.xjapp.data_query.frame.IDataQueryPresenter;
import com.lingshikeji.xjapp.data_query.frame.IDataQueryView;
import com.lingshikeji.xjapp.data_query.presenter.DataQueryPresenterImpl;

/**
 * <br/>Author: tony(shishaojie@koolearn.com)
 * <br/>Date: 2017/3/22 0022
 * <br/>Time: 13:38
 * <br/>Description:
 * <br/>FIXME
 */

public class DataQueryActivity extends BaseActivity implements IDataQueryView {

    private IDataQueryPresenter iDataQueryPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
        initPresenter();
    }

    private void initView() {
        setContentView(R.layout.activity_data_query);
    }

    private void initData() {

    }

    private void initPresenter() {
        iDataQueryPresenter = new DataQueryPresenterImpl();
        iDataQueryPresenter.attachView(this);
//        iDataQueryPresenter.doSubmit();
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
