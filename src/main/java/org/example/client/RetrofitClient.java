package org.example.client;

import org.example.BaseUrl;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitClient extends BaseUrl{

    public static Retrofit getClient() {
        BaseUrl baseUrl = new BaseUrl();
        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
        return new Retrofit.Builder().baseUrl(baseUrl.getBaseUrl())
                .client(okHttpClient)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }
}