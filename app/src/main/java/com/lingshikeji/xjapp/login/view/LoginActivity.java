package com.lingshikeji.xjapp.login.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.lingshikeji.xjapp.R;
import com.lingshikeji.xjapp.base.BaseActivity;
import com.lingshikeji.xjapp.login.frame.ILoginPresenter;
import com.lingshikeji.xjapp.login.frame.ILoginView;
import com.lingshikeji.xjapp.login.presenter.LoginPresenterImpl;
import com.lingshikeji.xjapp.main.MainActivity;
import com.lingshikeji.xjapp.model.User;
import com.lingshikeji.xjapp.register.view.RegisterActivity;
import com.lingshikeji.xjapp.util.Preferences;
import com.lingshikeji.xjapp.util.Utils;

/**
 * <br/>Author: tony(shishaojie@koolearn.com)
 * <br/>Date: 2017/3/22 0022
 * <br/>Time: 13:38
 * <br/>Description:
 * <br/>FIXME
 */

public class LoginActivity extends BaseActivity implements ILoginView, View.OnClickListener {

    private ILoginPresenter iLoginPresenter;
    private Button btnRegister;
    private Button btnLogin;
    private EditText editName;
    private EditText editPwd;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
        initPresenter();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
            boolean registerSuccess = data.getBooleanExtra("registerSuccess", false);
            if (registerSuccess) {
                startMainActivity();
            }
        }
    }

    private void initView() {
        setContentView(R.layout.activity_login);
        editName = (EditText) findViewById(R.id.edit_username);
        editPwd = (EditText) findViewById(R.id.edit_password);
        btnLogin = (Button) findViewById(R.id.btn_login);
        btnRegister = (Button) findViewById(R.id.btn_register);

        btnLogin.setOnClickListener(this);
        btnRegister.setOnClickListener(this);
    }

    private void initData() {
        if (Utils.isLogin()) {
            try {
                Intent intent = new Intent();
                intent.setClass(this, MainActivity.class);
                intent.putExtra("email", Preferences.getInstance().getEmail());
                startActivity(intent);
                finish();
            } catch (Exception e) {
            }
        }
    }

    private void initPresenter() {
        iLoginPresenter = new LoginPresenterImpl();
        iLoginPresenter.attachView(this);
//        iLoginPresenter.doSubmit();
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
    public void loginSuccess(User user) {
        Preferences.getInstance().storeEmail(user.getUser().getEmail());
        Preferences.getInstance().storeToken(user.getJwt());
        startMainActivity();
    }

    private void startMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                if (editName.getText().toString().isEmpty()) {
                    toast("用户名不能为空");
                    return;
                }
                if (editPwd.getText().toString().isEmpty()) {
                    toast("密码不能为空");
                    return;
                }
                String userName = editName.getText().toString();
                String pwd = editPwd.getText().toString();
                iLoginPresenter.doLogin(userName, pwd);
                break;
            case R.id.btn_register:
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivityForResult(intent, 0);
                break;
        }
    }
}
