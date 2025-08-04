package com.saayi.network.client

import com.saayi.network.BuildConfig
import com.saayi.network.models.PopularMoviesModel
import com.saayi.network.utils.Constants.POPULAR_MOVIES_END_POINT
import retrofit2.http.GET
import retrofit2.http.Query


interface MoviesApiService {
    @GET(POPULAR_MOVIES_END_POINT)
    suspend fun getAllPopularMovies(
        @Query("api_key") apiKey: String = BuildConfig.MOVIES_API_KEY,
        @Query("page") page: Int = 1,
    ): PopularMoviesModel
}
