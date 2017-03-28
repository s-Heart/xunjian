package com.lingshikeji.xjapp.net;

import retrofit2.Retrofit;

/**
 * Author: tony(110618445@qq.com)
 * Date: 2017/3/27
 * Time: 下午10:28
 * Description:
 * 网络操作管理类，请求都从此类发出
 * 1.在程序初始化时，先调用init，来初始化retrofit（baseUrl，build（））
 * 2.连续访问网络时使用rxjavaFlat（）
 * 3.单次访问网络时使用rxjava（）
 */
public class NetManager {
    private static final String BASE_URL_DEV = "http://rgzx.lingshikeji.cn:1338/api";
    public static final String BASE_URL = "http://rgzx.lingshikeji.cn:81/api";

    private static NetManager instance;

    private NetManager() {
        initRretrofit();
    }

    private void initRretrofit() {
    }

    public static NetManager getInstance() {
        if (instance == null) {
            synchronized (NetManager.class) {
                if (instance == null) {
                    instance = new NetManager();
                }
            }
        }
        return instance;
    }
}
