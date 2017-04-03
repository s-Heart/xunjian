package com.lingshikeji.xjapp.tested_mgr.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
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
import com.lingshikeji.xjapp.view_add_test.view.AddTestDetailActivity;

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
    public static final int MODIFY_OK = 2;
    public static final int DELETE_OK = 3;
    private ITestedMgrPresenter iTestedMgrPresenter;
    private TextView titleTextview;
    private ListView lvDevices;
    private DeviceAdapter deviceAdapter;
    private RelativeLayout footer;
    private TextView tvFooter;
    private Button btnAddToTest;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initPresenter();
        initData();
        getIntentFromOther();
    }

    private void getIntentFromOther() {
        Intent intent = getIntent();
        if (intent != null) {
            boolean fromAddTestDetail = intent.getBooleanExtra("fromAddTestDetail", false);
            if (fromAddTestDetail) {
                btnAddToTest.setVisibility(View.VISIBLE);
            } else {
                btnAddToTest.setVisibility(View.GONE);
            }
        }
    }

    private void initView() {
        setContentView(R.layout.activity_tested_mgr);
        initToolbar();

        btnAddToTest = (Button) findViewById(R.id.btn_add_to_test);
        btnAddToTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (deviceAdapter.getSelectedData() == null) {
                    toast("请选择被测设备");
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra("deviceEntity", deviceAdapter.getSelectedData());
                setResult(AddTestDetailActivity.CHOOSE_DEVICE_OK, intent);
                finish();
            }
        });


        lvDevices = (ListView) findViewById(R.id.lv_tested_devices);
        deviceAdapter = new DeviceAdapter(this);
        lvDevices.setAdapter(deviceAdapter);

        lvDevices.setOnScrollListener(new AbsListView.OnScrollListener() {
            private int lastItemIndex;

            @Override
            public void onScrollStateChanged(AbsListView absListView, int scrollState) {
                if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE
                        && lastItemIndex == deviceAdapter.getCount() - 1) {
                    Log.d("index--", "" + lastItemIndex);
                    //加载数据代码，此处省略了
                    if (lastItemIndex < TestedMgrPresenterImpl.PageLimitCount - 1) {
                        iTestedMgrPresenter.queryDevices();
                    } else {
                        iTestedMgrPresenter.queryDevicePage(lastItemIndex);
                    }
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
        if (resultCode == CREATE_OK || resultCode == MODIFY_OK || resultCode == DELETE_OK) {
            iTestedMgrPresenter.queryDevices();
        }
    }

    private void initData() {
        deviceAdapter.setPresenter(iTestedMgrPresenter);
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

        if (devices.size() <= 7) {
            tvFooter.setText("已无更多数据，请稍后重试");
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

    @Override
    public void startModify(DeviceEntity deviceEntity) {
        Intent intent = new Intent(this, TestedDetailActivity.class);
        intent.putExtra("deviceEntity", deviceEntity);
        startActivityForResult(intent, 1);
    }
}
