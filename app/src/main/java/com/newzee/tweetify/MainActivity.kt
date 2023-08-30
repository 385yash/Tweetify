package com.newzee.tweetify

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.newzee.tweetify.navigationComp.NavComponent
import com.newzee.tweetify.ui.theme.TweetifyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text("Tweetify") },
                            colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = Color(0xFFE6F4FB))
                        )
                    }
                ) {
                    Box(modifier = Modifier.padding(it)){
                        App()
                    }
                }
        }
    }
}

@Composable
fun App() {
    NavComponent()
}

