package com.lingshikeji.xjapp.util;

/**
 * Author: tony(110618445@qq.com)
 * Date: 2017/4/4
 * Time: 下午3:39
 * Description:
 */
public class Utils {
    public static boolean isLogin() {
        return !Preferences.getInstance().getToken().isEmpty();
    }
}
