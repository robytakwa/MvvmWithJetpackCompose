package com.udacoding.mvvmcoroutine_flowjetpack_compose.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapimvvm_coroutine_flow.model.ArticlesItem
import com.udacoding.mvvmcoroutine_flowjetpack_compose.configNetwork.ApiResult
import com.udacoding.mvvmcoroutine_flowjetpack_compose.repo.RepoNews
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class NewsViewModel : ViewModel() {

    //TODO 3 eksekusi  view model
    private val repo = RepoNews()
    private var _newStateFlow = MutableStateFlow(NewsStateResult.SUCCESS(emptyList()))
    var newsStateFlow : StateFlow<NewsStateResult.SUCCESS>? = _newStateFlow


    private var _stateError = MutableStateFlow(NewsStateResult.ERROR(Throwable()))
    val stateError : StateFlow<NewsStateResult.ERROR>? = _stateError


    init {

        getNews()
    }

    private fun getNews() {

        viewModelScope.launch {
            repo.getNews().onStart {
                //ekseksusi start loading
            }
                .onCompletion {
                    //stop loading
                }

                .collect { apiResult ->

                    when(apiResult){
                        is ApiResult.Success -> _newStateFlow.value =  NewsStateResult.SUCCESS(apiResult.data.articles)
                        is ApiResult.Error -> _stateError.value = NewsStateResult.ERROR(apiResult.throwable)
                    }

                }
        }

    }
}

open class NewsStateResult{
    data class SUCCESS(val dataNews :List<ArticlesItem>? ) : NewsStateResult()
    data class ERROR(val exception : Throwable): NewsStateResult()
}