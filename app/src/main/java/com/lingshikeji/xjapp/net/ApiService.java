package com.lingshikeji.xjapp.net;

import com.lingshikeji.xjapp.model.DeviceEntity;
import com.lingshikeji.xjapp.model.User;

import java.util.List;
import java.util.Map;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Author: tony(110618445@qq.com)
 * Date: 2017/3/28
 * Time: 下午9:57
 * Description:接口声明处
 */
public interface ApiService {
    /*注册登录*/

    @POST("auth/local")
    Observable<User> login(@Body Map<String, String> params);

    @POST("auth/local/register")
    Observable<User> register(@Body Map<String, String> params);


    /*被测设备*/

    @GET("device")
    Observable<List<DeviceEntity>> queryDevices();

}
