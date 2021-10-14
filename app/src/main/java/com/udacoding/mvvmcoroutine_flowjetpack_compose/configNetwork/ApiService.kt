package com.ercode.udacoding.alibabapos.pages.pelanggan.configNetwork

import com.example.newsapimvvm_coroutine_flow.model.ResponseNews
import retrofit2.http.GET


interface ApiService {

//TODO 1 request
    @GET("everything?q=tesla&from=2021-10-12&sortBy=publishedAt&apiKey=d32dd7d06e3b40b8ab47fb94dfbe8ac4")
    suspend fun getNews():ResponseNews


}