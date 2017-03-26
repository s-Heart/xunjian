package com.lingshikeji.xjapp.util;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lingshikeji.xjapp.R;

/**
 * Created by tony on 2017/3/26.
 */

public class DialogUtil {
    public static Dialog createLoadingDialog(Context context, String msg) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.loading_dialog, null);// 得到加载view
        TextView tipTextView = (TextView) v.findViewById(R.id.tipTextView);// 提示文字
        tipTextView.setText(msg);// 设置加载信息
        final Dialog loadingDialog = new Dialog(context, R.style.loading_dialog);// 创建自定义样式dialog
        loadingDialog.setContentView(v,
                new LinearLayout.LayoutParams(
                        DeviceUtil.getScreenWidth(context) / 2,
                        LinearLayout.LayoutParams.MATCH_PARENT));// 设置布局
        loadingDialog.setCanceledOnTouchOutside(false);
        loadingDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialogInterface) {
                loadingDialog.dismiss();
            }
        });
        return loadingDialog;

    }

    public static Dialog createLoadingDialog(Context context) {
        return createLoadingDialog(context, "请稍候...");
    }
}
