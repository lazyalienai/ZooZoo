package com.saayi.zoozoo.composables

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.saayi.zoozoo.models.UiState
import com.saayi.zoozoo.viewmodels.MainViewModel

@Composable
fun PostScreen() {
    val viewModel: MainViewModel = hiltViewModel()
    val state = viewModel.posts.collectAsStateWithLifecycle().value

    LaunchedEffect(Unit) {
        viewModel.fetchPosts()
    }

    when (state) {
        is UiState.Loading -> {
            CircularProgressIndicator()
        }

        is UiState.Success -> {
            LazyColumn {
                items(state.data) { post ->
                    Text(post.title)
                }
            }
        }

        is UiState.Error -> {
            Text("Error: ${state.message}")
        }
    }
}