package com.bawei.wangjiangwei.util;

import com.bawei.wangjiangwei.api.API;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * data:2020/3/9
 * author:王江伟(DJ慢羊羊)
 * function:
 */
public class NetUtils {
    private static NetUtils sNetUtils;
    private final Retrofit mRetrofit;

    private NetUtils() {
        //网络拦截器
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));

        //retrofit
        mRetrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(builder.build())
                .baseUrl(API.BASE_URL)
                .build();
    }

    public static NetUtils getInstance() {
        //双重检验锁
        if (sNetUtils == null) {
            synchronized (NetUtils.class){
                if (sNetUtils == null) {
                    sNetUtils = new NetUtils();
                }
            }
        }

        return sNetUtils;
    }

    //为外界提供接口
    public <T>T getCreat(Class<T> tClass){
        return mRetrofit.create(tClass);
    }

}
