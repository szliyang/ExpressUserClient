package com.example.administrator.expressuserclient.http.util;


import com.example.administrator.expressuserclient.http.API;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2018/6/25.
 */

public class RetrofitUtil {
    public static final String BASE_URL = "http://111.230.18.100/";
    public static final String KUAIDINIAO = "http://api.kdniao.cc/";
    private Retrofit retrofit;
    private static RetrofitUtil sInstance;
    public RetrofitUtil(String url) {
        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }
    public static RetrofitUtil getInstance(String url) {
        synchronized (RetrofitUtil.class) {
            if (sInstance == null) {
                sInstance = new RetrofitUtil(url);
            }
        }
        return sInstance;
    }
    public API getServerices() {
        return retrofit.create(API.class);
    }
}