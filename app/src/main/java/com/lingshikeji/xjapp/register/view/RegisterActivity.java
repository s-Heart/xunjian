package com.lingshikeji.xjapp.register.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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
import com.lingshikeji.xjapp.model.User;
import com.lingshikeji.xjapp.register.frame.IRegisterPresenter;
import com.lingshikeji.xjapp.register.frame.IRegisterView;
import com.lingshikeji.xjapp.register.presenter.RegisterPresenterImpl;
import com.lingshikeji.xjapp.util.Preferences;

/**
 * <br/>Author: tony(shishaojie@koolearn.com)
 * <br/>Date: 2017/3/22 0022
 * <br/>Time: 13:38
 * <br/>Description:
 * <br/>FIXME
 */

public class RegisterActivity extends BaseActivity implements IRegisterView, View.OnClickListener {

    private IRegisterPresenter iRegisterPresenter;
    private EditText editEmail;
    private EditText editPwd;
    private EditText editPwdConfirm;
    private Button btnRegister;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
        initPresenter();
    }

    private void initView() {
        setContentView(R.layout.activity_register);
        initToolbar();

        editEmail = (EditText) findViewById(R.id.edit_email_address);
        editPwd = (EditText) findViewById(R.id.edit_password_reg);
        editPwdConfirm = (EditText) findViewById(R.id.edit_password_again_reg);
        btnRegister = (Button) findViewById(R.id.btn_register);

        btnRegister.setOnClickListener(this);
    }

    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        TextView title = (TextView) toolbar.findViewById(R.id.toolbar_title);
        title.setText("注册");
        toolbar.setNavigationIcon(R.drawable.ic_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initData() {

    }

    private void initPresenter() {
        iRegisterPresenter = new RegisterPresenterImpl();
        iRegisterPresenter.attachView(this);
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
        Toast.makeText(this, str, Toast.LENGTH_LONG).show();
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
    public void registerSuccess(User user) {
        Preferences.getInstance().storeEmail(user.getUser().getEmail());
        Preferences.getInstance().storeToken(user.getJwt());
        Intent intent = new Intent();
        intent.putExtra("registerSuccess", true);
        setResult(0, intent);
        finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_register:
                if (editEmail.getText().toString().equals("")) {
                    toast("请输入注册邮箱名");
                    return;
                }
                if (editPwd.getText().toString().isEmpty() || editPwdConfirm.getText().toString().isEmpty()) {
                    toast("请输入密码");
                    return;
                }
                if (!editPwd.getText().toString().equals(editPwdConfirm.getText().toString())) {
                    toast("请确认密码是否一致");
                    return;
                }

                String email = editEmail.getText().toString();
                String pwd = editPwd.getText().toString();
                iRegisterPresenter.register(email, pwd);
                break;
            default:
                break;
        }
    }
}
