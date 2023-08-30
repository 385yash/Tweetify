package com.newzee.tweetify.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.newzee.tweetify.models.TweetListItem
import com.newzee.tweetify.viewmodels.DetailViewModel


@Composable
fun DetailScreen(){
    val detailViewModel: DetailViewModel = hiltViewModel()
    val tweets: State<List<TweetListItem>> = detailViewModel.tweets.collectAsState()

    val statusBarColor = Color(0xFFE6F4FB) // Your desired status bar color
    val backgroundColor = Color(0xFFE6F4FB) // Your desired background color

    if (tweets.value.isEmpty()) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            Text(text = "Loading....", style = MaterialTheme.typography.bodyMedium)
        }
    } else {
        CustomStatusBarColorTheme(statusBarColor = statusBarColor) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(backgroundColor),
            ) {
                LazyColumn(
                    content = {
                        items(tweets.value) {
                            TweetListItem(tweet = it.content)
                        }
                    }
                )
            }
        }
    }
}

@Composable
fun TweetListItem(tweet: String) {

    Card (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ),
        content = {
            Text(
                text = tweet,
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.bodyLarge
                )

        }
    )
}