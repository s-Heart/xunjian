package com.lingshikeji.xjapp.data_query.view;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.lingshikeji.xjapp.R;
import com.lingshikeji.xjapp.base.BaseActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


/**
 * Author: tony(110618445@qq.com)
 * Date: 2017/4/4
 * Time: 下午3:37
 * Description:
 */
public class SearchActivity extends BaseActivity {
    private TextView titleTextview;
    private EditText edConsumer;
    private EditText edInstrument;
    private EditText edModel;
    private EditText edSerialNumber;
    private TextView tvStartTime;
    private TextView tvEndTime;
    private EditText edTmp;
    private EditText edHumidity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
    }


    private void updateLabel() {

    }

    private void initData() {
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
                new DatePickerDialog(SearchActivity.this,
                        onDateSetListener,
                        dateAndTime.get(Calendar.YEAR),
                        dateAndTime.get(Calendar.MONTH),
                        dateAndTime.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        tvEndTime.setOnClickListener(new View.OnClickListener() {
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
                        tvEndTime.setText(sdf.format(dateAndTime.getTime()));
                    }
                };
                //生成一个DatePickerDialog对象，并显示。显示的DatePickerDialog控件可以选择年月日，并设置
                new DatePickerDialog(SearchActivity.this,
                        onDateSetListener,
                        dateAndTime.get(Calendar.YEAR),
                        dateAndTime.get(Calendar.MONTH),
                        dateAndTime.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }

    private void initView() {
        setContentView(R.layout.activity_search);

        edConsumer = (EditText) findViewById(R.id.ed_consumer);
        edInstrument = (EditText) findViewById(R.id.ed_instrument);
        edModel = (EditText) findViewById(R.id.ed_model);
        edSerialNumber = (EditText) findViewById(R.id.ed_serialnumber);
        tvStartTime = (TextView) findViewById(R.id.tv_starttime);
        tvEndTime = (TextView) findViewById(R.id.tv_endtime);
        edTmp = (EditText) findViewById(R.id.ed_tmp);
        edHumidity = (EditText) findViewById(R.id.ed_humidity);


        initToolbar();
    }

    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        titleTextview = (TextView) toolbar.findViewById(R.id.toolbar_title);
        titleTextview.setText("输入搜索条件");
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
