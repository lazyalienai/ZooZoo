package com.saayi.zoozoo.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.saayi.common.models.PopularMovies
import com.saayi.composeui.common.error.ZooErrorPage
import com.saayi.composeui.common.loader.ZooLoader
import com.saayi.composeui.homeScreen.PopularMoviesRail
import com.saayi.composeui.homeScreen.ZooCarousel
import com.saayi.zoozoo.models.UiState
import com.saayi.zoozoo.navigation.Screen
import com.saayi.zoozoo.viewmodels.HomeViewModel

@Composable
fun HomeScreen(navController: NavController) {
    val viewModel: HomeViewModel = hiltViewModel()
    val state = viewModel.popularMovies.collectAsStateWithLifecycle().value

    LaunchedEffect(Unit) {
        viewModel.fetchPopularMovies()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
    ) {
        when (state) {
            is UiState.Loading -> {
                ZooLoader()
            }

            is UiState.Success -> {
                HomePage(state.data) {
                    navController.navigate(Screen.Player.route)
                }
            }

            is UiState.Error -> {
                ZooErrorPage(state.message) {
                    viewModel.fetchPopularMovies()
                }
            }
        }
    }
}

@Composable
fun HomePage(data: PopularMovies, onClick: (position: Int) -> Unit) {
    val images = data.results.map { it.posterPath }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 48.dp)
            .verticalScroll(rememberScrollState()),
    ) {
        ZooCarousel(images.shuffled(), onClick = onClick)
        PopularMoviesRail(images.shuffled(), onClick)
        PopularMoviesRail(images.shuffled(), onClick)
        PopularMoviesRail(images.shuffled(), onClick)
        PopularMoviesRail(images.shuffled(), onClick)
        PopularMoviesRail(images.shuffled(), onClick)
    }
}