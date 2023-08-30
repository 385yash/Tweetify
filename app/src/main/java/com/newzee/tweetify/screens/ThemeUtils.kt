package com.newzee.tweetify.screens

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun CustomStatusBarColorTheme(
    statusBarColor: Color,
    content: @Composable () -> Unit
) {
    val systemUiController = rememberSystemUiController()

    val useDarkIcons = !isSystemInDarkTheme() // Adjust this based on your design

    systemUiController.setStatusBarColor(
        color = statusBarColor,
        darkIcons = useDarkIcons
    )

    content()
}
