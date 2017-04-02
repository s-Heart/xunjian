package com.lingshikeji.xjapp.tested_mgr.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.RelativeLayout;
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

    protected static final int CREATE_OK = 1;
    private ITestedMgrPresenter iTestedMgrPresenter;
    private TextView titleTextview;
    private ListView lvDevices;
    private DeviceAdapter deviceAdapter;
    private int lastItemIndex;
    private RelativeLayout footer;
    private TextView tvFooter;

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

        lvDevices.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int scrollState) {
                if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE
                        && lastItemIndex == deviceAdapter.getCount() - 1) {
                    //加载数据代码，此处省略了
                    iTestedMgrPresenter.queryDevicePage(lastItemIndex);
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem,
                                 int visibleItemCount, int totalItemCount) {
                //ListView 的FooterView也会算到visibleItemCount中去，所以要再减去一
                lastItemIndex = firstVisibleItem + visibleItemCount - 1 - 1;
            }
        });
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
                startActivityForResult(intent, CREATE_OK);
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == CREATE_OK) {
            iTestedMgrPresenter.queryDevices();
        }
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
        hideLoadingDialog();
    }

    @Override
    public void querySuccess(List<DeviceEntity> devices) {
        deviceAdapter.setDatas(devices);
        deviceAdapter.notifyDataSetChanged();
        if (footer == null) {
            footer = (RelativeLayout) LayoutInflater.from(this).inflate(R.layout.lv_footer, null);
            tvFooter = (TextView) footer.findViewById(R.id.tv_footer);
            lvDevices.addFooterView(footer);
        } else {
            tvFooter.setText("下拉加载更多...");
        }
    }

    @Override
    public void queryPageSuccess(List<DeviceEntity> devices) {
        if (devices.size() == 0) {
            tvFooter.setText("已无更多数据，请稍后重试");
            return;
        }
        deviceAdapter.getDatas().addAll(devices);
        deviceAdapter.notifyDataSetChanged();
    }
}
