package com.saayi.zoozoo.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Splash : Screen("splash")
    object Player : Screen("player")
}