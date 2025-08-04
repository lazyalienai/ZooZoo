package com.saayi.composeui.splashScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import com.saayi.composeui.R
import com.saayi.composeui.common.image.ZooImage

@Composable
fun SplashScreenImage() {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        ZooImage(
            model = R.drawable.ic_splash,
            modifier = Modifier
                .fillMaxSize(),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
    }
}