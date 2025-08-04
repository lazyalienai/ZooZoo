package com.saayi.zoozoo.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saayi.common.models.Post
import com.saayi.zoozoo.models.UiState
import com.saayi.zoozoo.usecases.GetPostsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TestViewModel @Inject constructor(
    private val getPostsUseCase: GetPostsUseCase,
) : ViewModel() {
    private val _posts = MutableStateFlow<UiState<List<Post>>>(UiState.Loading)
    val posts: StateFlow<UiState<List<Post>>> = _posts.asStateFlow()

    fun fetchPosts() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _posts.value = UiState.Loading
                val response = getPostsUseCase.invoke()
                _posts.value = UiState.Success(response)
            } catch (e: Exception) {
                _posts.value = UiState.Error(e.localizedMessage ?: "Unknown Error")
            }
        }
    }
}
