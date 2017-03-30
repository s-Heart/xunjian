package com.lingshikeji.xjapp.net;

import com.lingshikeji.xjapp.model.User;

import java.util.Map;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Author: tony(110618445@qq.com)
 * Date: 2017/3/28
 * Time: 下午9:57
 * Description:
 */
public interface ApiService {
    @POST("auth/local")
    Observable<User> login(@Body Map<String, String> params);
}
