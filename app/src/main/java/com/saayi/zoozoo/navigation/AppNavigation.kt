package com.saayi.zoozoo.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.saayi.zoozoo.composables.HomeScreen
import com.saayi.zoozoo.composables.PlayerScreen
import com.saayi.zoozoo.composables.SplashScreen

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Splash.route) {
        composable(Screen.Splash.route) {
            SplashScreen(navController = navController)
        }
        composable(Screen.Home.route) {
            HomeScreen(navController = navController)
        }

        composable(Screen.Player.route) {
            PlayerScreen(navController = navController)
        }
    }
}