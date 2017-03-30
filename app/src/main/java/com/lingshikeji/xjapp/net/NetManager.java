package com.lingshikeji.xjapp.net;

import android.util.Log;

import com.lingshikeji.xjapp.model.User;
import com.lingshikeji.xjapp.util.Preferences;

import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Dns;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.HttpException;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

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
    public static final String BASE_URL_DEV = "http://rgzx.lingshikeji.cn:1338/api/";
    public static final String BASE_URL = "http://rgzx.lingshikeji.cn:81/api/";

    private static NetManager instance;
    private Retrofit retrofit;
    private OkHttpClient okHttpClient;
    private Map<String, String> headerMap;

    private NetManager() {
        initHeaderMap();
        initRetrofit();
    }

    private void initHeaderMap() {
        this.headerMap = new HashMap<>();
        headerMap.put("Content-Type", "application/json; charset=UTF-8");
        if (!Preferences.getInstance().getToken().isEmpty()) {
            headerMap.put("Authorization", Preferences.getInstance().getToken());
        }
    }

    private void initRetrofit() {
        this.okHttpClient = (new OkHttpClient.Builder())
                .readTimeout(30000L, TimeUnit.SECONDS)
                .connectTimeout(30000L, TimeUnit.SECONDS)
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        try {
                            Request response1 = chain.request().newBuilder().headers(Headers.of(headerMap)).build();
                            return chain.proceed(response1);
                        } catch (Exception var5) {
                            Response response;
                            try {
                                response = chain.proceed(chain.request());
                            } catch (Exception var4) {
                                var4.printStackTrace();
                                response = (new Response.Builder()).request(chain.request()).protocol(Protocol.HTTP_1_1).code(1).build();
                            }

                            return response;
                        }
                    }
                }).build();

        retrofit = new Retrofit.Builder()
                .baseUrl(NetManager.BASE_URL_DEV)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    public Retrofit getRetrofit() {
        return retrofit;
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

    public <T> void runRxJava(Observable<T> observable, final Subscriber<T> subscriberCallBack) {
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<T>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        ResponseBody body = ((HttpException) throwable).response().errorBody();
                        try {
                            JSONObject response = new JSONObject(body.string());
                            String msg = (String) response.get("message");
                            subscriberCallBack.onError(new Exception(msg));
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }

                    }

                    @Override
                    public void onNext(T t) {
                        subscriberCallBack.onNext(t);
                    }
                });
    }

    public ApiService getApiService() {
        return retrofit.create(ApiService.class);
    }
}
