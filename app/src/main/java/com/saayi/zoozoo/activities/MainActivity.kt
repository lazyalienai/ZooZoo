package com.saayi.zoozoo.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.saayi.zoozoo.composables.PostScreen
import com.saayi.zoozoo.ui.theme.ZooZooTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ZooZooTheme {
                Box(
                    modifier = Modifier.fillMaxSize()
                ) {
                    PostScreen()
                }
            }
        }
    }
}