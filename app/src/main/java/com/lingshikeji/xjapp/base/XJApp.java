package com.lingshikeji.xjapp.base;

import android.app.Application;

/**
 * Created by tony on 2017/3/29.
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
