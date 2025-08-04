package com.saayi.zoozoo.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saayi.common.models.PopularMovies
import com.saayi.zoozoo.models.UiState
import com.saayi.zoozoo.usecases.GetPopularMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase
) : ViewModel() {
    private val _popularMovies = MutableStateFlow<UiState<PopularMovies>>(UiState.Loading)
    val popularMovies: StateFlow<UiState<PopularMovies>> = _popularMovies.asStateFlow()
    fun fetchPopularMovies() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _popularMovies.value = UiState.Loading
                val response = getPopularMoviesUseCase.invoke()
                _popularMovies.value = UiState.Success(response)
            } catch (e: Exception) {
                _popularMovies.value = UiState.Error(e.localizedMessage ?: "Unknown Error")
            }
        }
    }
}