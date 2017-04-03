package com.lingshikeji.xjapp.view_add_test.view;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.lingshikeji.xjapp.R;
import com.lingshikeji.xjapp.base.BaseActivity;
import com.lingshikeji.xjapp.model.DeviceEntity;
import com.lingshikeji.xjapp.model.InstrumentEntity;
import com.lingshikeji.xjapp.model.StandardEntity;
import com.lingshikeji.xjapp.net.NetManager;
import com.lingshikeji.xjapp.test_mgr.view.TestMgrActivity;
import com.lingshikeji.xjapp.tested_mgr.view.TestedMgrActivity;
import com.lingshikeji.xjapp.util.DialogUtil;
import com.lingshikeji.xjapp.util.materialdialog.IPromptDilaog;
import com.lingshikeji.xjapp.util.materialdialog.PromptDialog;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by tony on 2017/4/3.
 */

public class AddTestActivity extends BaseActivity {
    private static final int CHOOSE_TESTED = 1;
    private static final int CHOOSE_TEST = 2;
    public static final int CHOOSE_DEVICE_OK = 1;
    public static final int CHOOSE_INSTRUMENT_OK = 2;
    private TextView titleTextview;
    private RelativeLayout rlTested;
    private RelativeLayout rlTest;
    private RelativeLayout rlStandard;
    private EditText edTemp;
    private EditText edHum;
    private EditText edCycle;
    private EditText edNum;
    private TextView tvStartTime;
    private EditText edTempSensorNum;
    private EditText edHumSensorNum;
    private EditText edTestTemp;
    private EditText edTestHum;
    private TextView tvTested;
    private TextView tvTest;
    private TextView tvStandard;
    private DeviceEntity deviceEntity;
    private InstrumentEntity instrumentEntity;
    private StandardEntity currentStandard;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == CHOOSE_DEVICE_OK) {
            deviceEntity = (DeviceEntity) data.getSerializableExtra("deviceEntity");
            tvTested.setText(deviceEntity.getName());
        }

        if (resultCode == CHOOSE_INSTRUMENT_OK) {
            instrumentEntity = (InstrumentEntity) data.getSerializableExtra("instrumentEntity");
            tvTest.setText(instrumentEntity.getName());
        }
    }

    private void initView() {
        setContentView(R.layout.activity_add_test_detail);
        initToolbar();

        rlTested = (RelativeLayout) findViewById(R.id.rl_tested);
        rlTest = (RelativeLayout) findViewById(R.id.rl_test);
        rlStandard = (RelativeLayout) findViewById(R.id.rl_standard);
        tvTested = (TextView) rlTested.findViewById(R.id.tv_tested);
        tvTest = (TextView) rlTest.findViewById(R.id.tv_test);
        tvStandard = (TextView) rlStandard.findViewById(R.id.tv_standard);

        edTemp = (EditText) findViewById(R.id.ed_temp);
        edHum = (EditText) findViewById(R.id.ed_hum);
        edCycle = (EditText) findViewById(R.id.ed_cycle);
        edNum = (EditText) findViewById(R.id.ed_num);
        tvStartTime = (TextView) findViewById(R.id.tv_starttime);
        edTempSensorNum = (EditText) findViewById(R.id.ed_temp_sensor_number);
        edHumSensorNum = (EditText) findViewById(R.id.ed_hum_sensor_number);
        edTestTemp = (EditText) findViewById(R.id.ed_test_temp);
        edTestHum = (EditText) findViewById(R.id.ed_test_hum);

        rlTested.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddTestActivity.this, TestedMgrActivity.class);
                intent.putExtra("fromAddTest", true);
                startActivityForResult(intent, CHOOSE_TESTED);
            }
        });
        rlTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddTestActivity.this, TestMgrActivity.class);
                intent.putExtra("fromAddTest", true);
                startActivityForResult(intent, CHOOSE_TEST);
            }
        });
        rlStandard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getStandardList();
            }
        });

        tvStartTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //获取一个日历对象
                final Calendar dateAndTime = Calendar.getInstance(Locale.CHINA);
                //当点击DatePickerDialog控件的设置按钮时，调用该方法
                DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        //修改日历控件的年，月，日
                        //这里的year,monthOfYear,dayOfMonth的值与DatePickerDialog控件设置的最新值一致
                        dateAndTime.set(Calendar.YEAR, year);
                        dateAndTime.set(Calendar.MONTH, monthOfYear);
                        dateAndTime.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                        //将页面TextView的显示更新为最新时间
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        tvStartTime.setText(sdf.format(dateAndTime.getTime()));
                    }
                };
                //生成一个DatePickerDialog对象，并显示。显示的DatePickerDialog控件可以选择年月日，并设置
                new DatePickerDialog(AddTestActivity.this,

                        onDateSetListener,
                        dateAndTime.get(Calendar.YEAR),
                        dateAndTime.get(Calendar.MONTH),
                        dateAndTime.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }

    /**
     * 获取技术文件
     */
    private void getStandardList() {
        showLoadingDialog();
        Observable<List<StandardEntity>> observable = NetManager.getInstance().getApiService().standard();
        NetManager.getInstance().runRxJava(observable, new Subscriber<List<StandardEntity>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                hideLoadingDialog();
                Toast.makeText(AddTestActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNext(List<StandardEntity> standardEntities) {
                hideLoadingDialog();
                showSelectDialog(standardEntities);
            }
        });
    }

    private void showSelectDialog(final List<StandardEntity> standardEntities) {
        final List<String> chooseList = new ArrayList<>();
        for (StandardEntity standardEntity : standardEntities) {
            chooseList.add(standardEntity.getName());
        }
        final PromptDialog.Builder dialog = DialogUtil.createDialog(this, "选择依据技术文件",
                "", "确定", "取消",
                new IPromptDilaog() {

                    @Override
                    public void onOK() {
                        if (currentStandard != null) {
                            tvStandard.setText(currentStandard.getName());
                        } else {
                            Toast.makeText(AddTestActivity.this, "请选择依据技术文件", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancle() {
                    }
                }, true);
        dialog.setOnListItemClickListener(new PromptDialog.OnListDialogItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                currentStandard = standardEntities.get(position);
                if (dialog.getListViewAdapter() != null) {
                    dialog.getListViewAdapter().setSelectPosition(position);
                    dialog.getListViewAdapter().refreshAdapter();
                }
            }
        });
        dialog.setDialogType(PromptDialog.DialogType.LIST_DIALOG);
        dialog.setListItemData(chooseList);
        dialog.show();

        if (dialog.getListViewAdapter() != null) {
            currentStandard = standardEntities.get(0);
            dialog.getListViewAdapter().setSelectPosition(0);
            dialog.getListViewAdapter().refreshAdapter();
        }
    }


    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        titleTextview = (TextView) toolbar.findViewById(R.id.toolbar_title);
        titleTextview.setText("设置采集信息");
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
