package com.udacoding.mvvmcoroutine_flowjetpack_compose.repo

import com.ercode.udacoding.alibabapos.pages.pelanggan.configNetwork.NetworkConfig
import com.example.newsapimvvm_coroutine_flow.model.ResponseNews
import com.udacoding.mvvmcoroutine_flowjetpack_compose.configNetwork.ApiResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RepoNews {

    //TODO 2 ekseksusi repository
    private var api = NetworkConfig.getService()

    suspend fun getNews():Flow<ApiResult<ResponseNews>>{

        return flow {

            try {
                val dataNews = api.getNews()
                emit(ApiResult.Success(dataNews))
            }catch (exception : Throwable){
                emit(ApiResult.Error(exception))
            }
        }.flowOn(Dispatchers.IO)
    }
}