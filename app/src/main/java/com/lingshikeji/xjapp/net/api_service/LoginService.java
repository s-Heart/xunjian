package com.lingshikeji.xjapp.net.api_service;

import com.lingshikeji.xjapp.model.User;

import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Author: tony(110618445@qq.com)
 * Date: 2017/3/28
 * Time: 下午9:57
 * Description:
 */
public interface LoginService {
    @Headers("Content-Type: application/json")
    @POST("auth/local")
    Observable<User> login(@Body RequestBody params);
}
