package com.dzs.mylibrary;



import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2016/5/18.
 *
 * @version 1.0
 * @copyright by ${COMPANY}
 */
public class RetrofitUtils {
    private static OkHttpClient client;

    private static OkHttpClient getClient() {
        if (client == null) {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient.Builder builder =  new OkHttpClient.Builder();
            builder.readTimeout(8,TimeUnit.SECONDS);
            builder.writeTimeout(8,TimeUnit.SECONDS);
            builder.connectTimeout(5, TimeUnit.SECONDS);
            builder.addInterceptor(loggingInterceptor);
            client = builder.build();
        }
        return client;
    }
    public static Retrofit.Builder build(String baseurl) {
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.addCallAdapterFactory(RxJavaCallAdapterFactory.create());
        builder.addConverterFactory(GsonConverterFactory.create());
        builder.baseUrl(baseurl);
        builder.client(getClient());
        return builder;
    }


}
