package com.lingshikeji.xjapp.tested_mgr.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.lingshikeji.xjapp.R;
import com.lingshikeji.xjapp.base.BaseActivity;
import com.lingshikeji.xjapp.model.DeviceEntity;
import com.lingshikeji.xjapp.net.NetManager;

import java.util.HashMap;
import java.util.Map;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by tony on 2017/3/26.
 */

public class TestedDetailActivity extends BaseActivity {
    private TextView titleTextview;
    private EditText edContact;
    private EditText edAddress;
    private EditText edDevice;
    private EditText edModel;
    private EditText edSerialNum;
    private EditText edManufacture;
    private EditText edRemark;
    private Button btnSave;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        setContentView(R.layout.activity_tested_detail);
        initToolbar();

        edContact = (EditText) findViewById(R.id.ed_contact);
        edAddress = (EditText) findViewById(R.id.ed_address);
        edDevice = (EditText) findViewById(R.id.ed_device);
        edModel = (EditText) findViewById(R.id.ed_model);
        edSerialNum = (EditText) findViewById(R.id.ed_serial_number);
        edManufacture = (EditText) findViewById(R.id.ed_manufacture);
        edRemark = (EditText) findViewById(R.id.ed_remark);

        btnSave = (Button) findViewById(R.id.btn_save);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edContact.getText().toString().isEmpty() ||
                        edAddress.getText().toString().isEmpty() ||
                        edDevice.getText().toString().isEmpty() ||
                        edModel.getText().toString().isEmpty() ||
                        edSerialNum.getText().toString().isEmpty() ||
                        edManufacture.getText().toString().isEmpty() ||
                        edRemark.getText().toString().isEmpty()) {
                    Toast.makeText(TestedDetailActivity.this, "请检查所填信息", Toast.LENGTH_SHORT).show();
                    return;
                }

                createDevice();

            }
        });
    }

    /**
     * 创建测试设备
     */
    private void createDevice() {
        showLoadingDialog();
        Map<String, String> params = new HashMap<>();
        params.put("name", edDevice.getText().toString());
        params.put("contact", edContact.getText().toString());
        params.put("address", edAddress.getText().toString());
        params.put("model", edModel.getText().toString());
        params.put("serialnumber", edSerialNum.getText().toString());
        params.put("manufacture", edManufacture.getText().toString());
        params.put("remark", edRemark.getText().toString());
        Observable<DeviceEntity> observable = NetManager.getInstance().getApiService().createDevice(params);
        NetManager.getInstance().runRxJava(observable, new Subscriber<DeviceEntity>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                hideLoadingDialog();
                Toast.makeText(TestedDetailActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNext(DeviceEntity deviceEntity) {
                hideLoadingDialog();
                Toast.makeText(TestedDetailActivity.this, "创建成功", Toast.LENGTH_SHORT).show();
                setResult(TestedMgrActivity.CREATE_OK);
                finish();
            }
        });
    }

    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        titleTextview = (TextView) toolbar.findViewById(R.id.toolbar_title);
        titleTextview.setText("被测试设备信息");
        titleTextview.setVisibility(View.VISIBLE);
        toolbar.setNavigationIcon(R.drawable.ic_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
