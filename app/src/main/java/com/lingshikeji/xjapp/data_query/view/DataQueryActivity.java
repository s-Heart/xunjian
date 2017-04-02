package com.lingshikeji.xjapp.data_query.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

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
    private TextView titleTextview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
        initPresenter();
    }

    private void initView() {
        setContentView(R.layout.activity_data_query);
        initToolbar();
    }

    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        titleTextview = (TextView) toolbar.findViewById(R.id.toolbar_title);
        titleTextview.setText("数据查询");
        titleTextview.setVisibility(View.VISIBLE);


        ImageView search = (ImageView) toolbar.findViewById(R.id.toolbar_right_search);
        search.setVisibility(View.VISIBLE);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DataQueryActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });
        toolbar.setNavigationIcon(R.drawable.ic_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
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
        hideLoadingDialog();
    }
}
