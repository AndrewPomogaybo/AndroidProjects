package com.example.resyclerview;

import android.util.Log;

import java.net.InetSocketAddress;
import java.net.Proxy;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {

    private APIService apiService;

    public APIService getApiService() {
        if(apiService == null){
            try{
                OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
                httpClientBuilder.proxy(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.207.106.28", 3128)));

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://dummyjson.com/")
                        .client(httpClientBuilder.build())
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                apiService = retrofit.create(APIService.class);
            }
            catch (Exception e){
                Log.d("Debug", e.getMessage());
            }
        }
        return apiService;
    }


}
