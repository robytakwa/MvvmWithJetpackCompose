package com.ercode.udacoding.alibabapos.pages.pelanggan.configNetwork

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory

object NetworkConfig {

    fun configInterceptor(): OkHttpClient {

        val okhttp = HttpLoggingInterceptor()
        okhttp.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder()
            .addInterceptor(okhttp)
            .build()

        return client
    }

     fun getRetrofit(): Retrofit {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://newsapi.org/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(configInterceptor())
            .build()
        return retrofit
    }

    fun getService()= getRetrofit().create(ApiService::class.java)




}