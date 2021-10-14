package com.udacoding.mvvmcoroutine_flowjetpack_compose.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.newsapimvvm_coroutine_flow.model.ArticlesItem

@Composable
fun showData(dataNews: List<ArticlesItem?>) {
    
    LazyColumn{
        items(dataNews){ it ->
            itemNews(item = it)
        }
    }
    
}

@Composable
fun itemNews(item : ArticlesItem?){

    Card(shape = RoundedCornerShape(10.dp),elevation = 5.dp,modifier = Modifier.fillMaxWidth().padding(10.dp)) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp)) {

            Image(painter = rememberImagePainter(data = item?.urlToImage), contentDescription ="",
                modifier = Modifier.size(width = 100.dp,height = 100.dp))

            Spacer(modifier = Modifier.padding(10.dp))

            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)) {
                Text(text = item?.title.toString(),style = TextStyle(fontSize = 18.sp),fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.padding(10.dp))
                Text(text = item?.author.toString(),style = TextStyle(fontSize = 18.sp))
            }



        }
    }

}