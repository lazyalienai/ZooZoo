package com.saayi.zoozoo.viewmodels

import androidx.lifecycle.ViewModel
import com.saayi.data.repository.PostsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PlayersViewModel @Inject constructor(
    private val repository: PostsRepository
) : ViewModel() {

    fun playAsset() {

    }
}