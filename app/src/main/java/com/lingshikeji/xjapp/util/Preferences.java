package com.lingshikeji.xjapp.util;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.lingshikeji.xjapp.base.XJApp;

/**
 * Created by tony on 2017/3/29.
 */

public class Preferences {

    private static final String PREFERENCE_XUNJIAN = "xunjian";
    private static Preferences mInstance;
    private final Context mContext;
    private SharedPreferences mPrefs;

    public static Preferences getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new Preferences(context);
        }

        return mInstance;
    }

    public static Preferences getInstance() {
        return getInstance(XJApp.getInstance());
    }

    private Preferences(Context context) {
        mContext = context;
        doLoadPrefs();
    }

    public void doLoadPrefs() {
        mPrefs = mContext.getSharedPreferences(PREFERENCE_XUNJIAN,
                Activity.MODE_PRIVATE);

    }


    public void storeToken(String token) {
        if (mPrefs == null) {
            mPrefs = mContext.getSharedPreferences(PREFERENCE_XUNJIAN, 0);
        }
        SharedPreferences.Editor prefEditor = mPrefs.edit();
        prefEditor.putString("token", token);
        prefEditor.commit();
    }

    public String getToken() {
        if (mPrefs == null) {
            mPrefs = mContext.getSharedPreferences(PREFERENCE_XUNJIAN, 0);
        }
        return mPrefs.getString("token", "");

    }

    public void storeEmail(String email) {
        if (mPrefs == null) {
            mPrefs = mContext.getSharedPreferences(PREFERENCE_XUNJIAN, 0);
        }
        SharedPreferences.Editor prefEditor = mPrefs.edit();
        prefEditor.putString("email", email);
        prefEditor.commit();
    }

    public String getEmail() {
        if (mPrefs == null) {
            mPrefs = mContext.getSharedPreferences(PREFERENCE_XUNJIAN, 0);
        }
        return mPrefs.getString("email", "");
    }
}
