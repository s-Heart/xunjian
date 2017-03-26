package com.lingshikeji.xjapp.base;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.lingshikeji.xjapp.util.DialogUtil;

/**
 * Author: tony(110618445@qq.com)
 * Date: 2017/3/26
 * Time: 下午4:14
 * Description:
 * 用于处理加载框的逻辑，所有activity继承此类，
 * 调用showProgress时，调用showLoadingDialog()
 * 请求完成时，调用hideProgress时，调用dismissLoadingDialog
 */
public class BaseActivity extends AppCompatActivity {


    private Dialog dialog;

    public void showLoadingDialog() {
        dialog = DialogUtil.createLoadingDialog(this);
        dialog.show();
    }

    public void dismissLoadingDialog() {
        dialog.dismiss();
    }
}
