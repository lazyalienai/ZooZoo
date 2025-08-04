package com.saayi.data.repository

import com.saayi.common.models.PopularMovies

interface MoviesRepository {
    suspend fun getPopularMovies(): PopularMovies
}