package com.newzee.tweetify.navigationComp

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.newzee.tweetify.screens.CategoryScreen
import com.newzee.tweetify.screens.DetailScreen

@Composable
fun NavComponent() {
    val  navController: NavHostController = rememberNavController()
    NavHost(navController = navController, startDestination = "category"){

        composable("category"){
            CategoryScreen {
                navController.navigate("detail/${it}")
            }
        }
        composable("detail/{category}",
            arguments = listOf(
                navArgument("category"){
                    type = NavType.StringType
                }
            )
        ){
            DetailScreen()
        }


    }
}