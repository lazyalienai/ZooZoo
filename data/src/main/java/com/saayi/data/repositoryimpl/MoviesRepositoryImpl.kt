package com.saayi.data.repositoryimpl

import com.saayi.common.models.PopularMovies
import com.saayi.data.repository.MoviesRepository
import com.saayi.network.client.MoviesApiService
import com.saayi.network.mapper.toDomain
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(private val moviesApiService: MoviesApiService) :
    MoviesRepository {

    override suspend fun getPopularMovies(): PopularMovies {
        val response = moviesApiService.getAllPopularMovies()
        return response.toDomain()
    }
}