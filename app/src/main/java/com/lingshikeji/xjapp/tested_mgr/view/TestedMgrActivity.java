package com.lingshikeji.xjapp.tested_mgr.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.lingshikeji.xjapp.R;
import com.lingshikeji.xjapp.base.BaseActivity;
import com.lingshikeji.xjapp.model.DeviceEntity;
import com.lingshikeji.xjapp.tested_mgr.frame.ITestedMgrPresenter;
import com.lingshikeji.xjapp.tested_mgr.frame.ITestedMgrView;
import com.lingshikeji.xjapp.tested_mgr.presenter.TestedMgrPresenterImpl;
import com.lingshikeji.xjapp.tested_mgr.uihelper.DeviceAdapter;

import java.util.List;

/**
 * <br/>Author: tony(shishaojie@koolearn.com)
 * <br/>Date: 2017/3/22 0022
 * <br/>Time: 13:38
 * <br/>Description:
 * <br/>FIXME
 */

public class TestedMgrActivity extends BaseActivity implements ITestedMgrView {

    private ITestedMgrPresenter iTestedMgrPresenter;
    private TextView titleTextview;
    private ListView lvDevices;
    private DeviceAdapter deviceAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
        initPresenter();
    }

    private void initView() {
        setContentView(R.layout.activity_tested_mgr);
        initToolbar();

        lvDevices = (ListView) findViewById(R.id.lv_tested_devices);
        deviceAdapter = new DeviceAdapter(this);
        lvDevices.setAdapter(deviceAdapter);

    }

    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        titleTextview = (TextView) toolbar.findViewById(R.id.toolbar_title);
        titleTextview.setText("被测设备数据库");
        titleTextview.setVisibility(View.VISIBLE);

        TextView addTv = (TextView) toolbar.findViewById(R.id.toolbar_right_menu);
        addTv.setText("新增");
        addTv.setVisibility(View.VISIBLE);
        addTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TestedMgrActivity.this, TestedDetailActivity.class);
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
        iTestedMgrPresenter = new TestedMgrPresenterImpl();
        iTestedMgrPresenter.attachView(this);
        iTestedMgrPresenter.queryDevices();
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

    @Override
    public void querySuccess(List<DeviceEntity> devices) {
        deviceAdapter.setDatas(devices);
        deviceAdapter.notifyDataSetChanged();
    }
}
