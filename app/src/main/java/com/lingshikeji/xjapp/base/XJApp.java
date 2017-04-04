package com.lingshikeji.xjapp.base;

import android.app.Application;


/**
 * Author: tony(110618445@qq.com)
 * Date: 2017/4/4
 * Time: 下午3:38
 * Description:
 */
public class XJApp extends Application {

    private static Application mAppContext;

    public static Application getInstance() {
        return mAppContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mAppContext = this;
    }
}
