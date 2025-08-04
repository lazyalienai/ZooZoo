package com.saayi.zoozoo.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.saayi.zoozoo.navigation.AppNavigation
import com.saayi.zoozoo.ui.theme.ZooZooTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ZooZooTheme {
                val navController = rememberNavController()
                AppNavigation(navController)
            }
        }
    }
}