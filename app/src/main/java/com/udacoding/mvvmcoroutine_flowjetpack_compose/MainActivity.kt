package com.udacoding.mvvmcoroutine_flowjetpack_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.udacoding.mvvmcoroutine_flowjetpack_compose.ui.showData
import com.udacoding.mvvmcoroutine_flowjetpack_compose.ui.theme.Mvvmcoroutine_flowjetpack_composeTheme
import com.udacoding.mvvmcoroutine_flowjetpack_compose.viewModel.NewsViewModel

class MainActivity : ComponentActivity() {

    private var viewModel : NewsViewModel? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        setContent {
            viewModel = ViewModelProvider(this).get(NewsViewModel::class.java)
            attachObserver()
        }
    }


    @Composable
    private fun attachObserver(){

          val data =   viewModel?.newsStateFlow?.collectAsState()

        if(data?.value?.dataNews?.size ?: 0 > 0){
            data?.value?.dataNews?.let { showData(it) }
        }



    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Mvvmcoroutine_flowjetpack_composeTheme {
        Greeting("Android")
    }
}