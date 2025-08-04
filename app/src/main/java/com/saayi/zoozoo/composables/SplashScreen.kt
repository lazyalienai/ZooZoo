package com.saayi.zoozoo.composables

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import com.saayi.composeui.splashScreen.SplashScreenImage
import com.saayi.zoozoo.navigation.Screen
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    LaunchedEffect(Unit) {
        delay(3000)
        navController.navigate(Screen.Home.route)
    }
    SplashScreenImage()
}