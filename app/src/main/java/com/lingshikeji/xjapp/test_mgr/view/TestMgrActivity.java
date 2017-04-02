package com.lingshikeji.xjapp.test_mgr.view;

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
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lingshikeji.xjapp.R;
import com.lingshikeji.xjapp.base.BaseActivity;
import com.lingshikeji.xjapp.model.DeviceEntity;
import com.lingshikeji.xjapp.model.InstrumentEntity;
import com.lingshikeji.xjapp.test_mgr.frame.ITestMgrPresenter;
import com.lingshikeji.xjapp.test_mgr.frame.ITestMgrView;
import com.lingshikeji.xjapp.test_mgr.presenter.TestMgrPresenterImpl;
import com.lingshikeji.xjapp.test_mgr.uihelper.InstrumentAdapter;

import java.util.List;

/**
 * <br/>Author: tony(shishaojie@koolearn.com)
 * <br/>Date: 2017/3/22 0022
 * <br/>Time: 13:38
 * <br/>Description:
 * <br/>FIXME
 */

public class TestMgrActivity extends BaseActivity implements ITestMgrView {

    protected static final int CREATE_OK = 1;
    public static final int MODIFY_OK = 2;
    public static final int DELETE_OK = 3;
    private ITestMgrPresenter iTestMgrPresenter;
    private TextView titleTextview;
    private ListView lvDevices;
    private InstrumentAdapter instrumentAdapter;
    private RelativeLayout footer;
    private TextView tvFooter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initPresenter();
        initData();
    }

    private void initView() {
        setContentView(R.layout.activity_test_mgr);
        initToolbar();

        lvDevices = (ListView) findViewById(R.id.lv_test_devices);
        instrumentAdapter = new InstrumentAdapter(this);
        lvDevices.setAdapter(instrumentAdapter);

        lvDevices.setOnScrollListener(new AbsListView.OnScrollListener() {
            private int lastItemIndex;

            @Override
            public void onScrollStateChanged(AbsListView absListView, int scrollState) {
                if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE
                        && lastItemIndex == instrumentAdapter.getCount() - 1) {
                    Log.d("index--", "" + lastItemIndex);
                    //加载数据代码，此处省略了
                    if (lastItemIndex < TestMgrPresenterImpl.PageLimitCount - 1) {
                        iTestMgrPresenter.queryInstruments();
                    } else {
                        iTestMgrPresenter.queryInstrumentsPage(lastItemIndex);
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
        titleTextview.setText("测试设备数据库");
        titleTextview.setVisibility(View.VISIBLE);

        TextView addTv = (TextView) toolbar.findViewById(R.id.toolbar_right_menu);
        addTv.setText("新增");
        addTv.setVisibility(View.VISIBLE);
        addTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TestMgrActivity.this, TestDetailActivity.class);
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
            iTestMgrPresenter.queryInstruments();
        }
    }

    private void initData() {
        instrumentAdapter.setPresenter(iTestMgrPresenter);
    }

    private void initPresenter() {
        iTestMgrPresenter = new TestMgrPresenterImpl();
        iTestMgrPresenter.attachView(this);
        iTestMgrPresenter.queryInstruments();
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
    public void querySuccess(List<InstrumentEntity> devices) {
        instrumentAdapter.setDatas(devices);
        instrumentAdapter.notifyDataSetChanged();
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
    public void queryPageSuccess(List<InstrumentEntity> devices) {
        if (devices.size() == 0) {
            tvFooter.setText("已无更多数据，请稍后重试");
            return;
        }
        instrumentAdapter.getDatas().addAll(devices);
        instrumentAdapter.notifyDataSetChanged();
    }

    @Override
    public void startModify(InstrumentEntity instrumentEntity) {
        Intent intent = new Intent(this, TestDetailActivity.class);
        intent.putExtra("instrumentEntity", instrumentEntity);
        startActivityForResult(intent, 1);
    }
}
