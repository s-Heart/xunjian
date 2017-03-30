package com.lingshikeji.xjapp.util;

/**
 * <br/>Author: tony(shishaojie@koolearn.com)
 * <br/>Date: 2017/3/30 0030
 * <br/>Time: 13:17
 * <br/>Description:
 * <br/>FIXME
 */

public class Utils {
    public static boolean isLogin() {
        return !Preferences.getInstance().getToken().isEmpty();
    }
}
