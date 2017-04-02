package com.lingshikeji.xjapp.net;

import com.lingshikeji.xjapp.model.DeviceEntity;
import com.lingshikeji.xjapp.model.User;

import java.util.List;
import java.util.Map;

import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;
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

    /**
     * 第一页数据请求
     *
     * @param param
     * @return
     */
    @GET("device")
    Observable<List<DeviceEntity>> queryDevices(@QueryMap Map<String, String> param);

    /**
     * 分页数据请求
     *
     * @param params
     * @return
     */
    @GET("device")
    Observable<List<DeviceEntity>> queryDeviceForPage(@QueryMap Map<String, String> params);

    //创建被测设备
    @POST("device")
    Observable<DeviceEntity> createDevice(@Body Map<String, String> params);

    @PUT("device/{id}")
    Observable<DeviceEntity> modifyDevice(@Path("id") int id, @Body Map<String, String> params);

    @DELETE("device/{id}")
    Observable<DeviceEntity> deleteDevice(@Path("id") int id);
}
