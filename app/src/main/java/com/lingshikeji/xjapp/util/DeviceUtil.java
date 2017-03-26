package com.lingshikeji.xjapp.util;

import android.content.Context;
import android.view.Display;
import android.view.WindowManager;


/**
 * 系统版本信息类
 */
public class DeviceUtil {

    private static final int NETTYPE_NULL = 0;

    @SuppressWarnings("deprecation")
    public static int getScreenHeight(Context context) {
        Display display = ((WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        return display.getHeight();
    }

    /**
     * 获取屏幕宽度
     */
    @SuppressWarnings("deprecation")
    public static int getScreenWidth(Context context) {
        Display display = ((WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        return display.getWidth();

    }

}
