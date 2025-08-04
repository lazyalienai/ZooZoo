package com.saayi.zoozoo.usecases

import com.saayi.data.repository.MoviesRepository
import javax.inject.Inject

class GetPopularMoviesUseCase @Inject constructor(
    private val moviesRepository: MoviesRepository,
) {
    suspend operator fun invoke() = moviesRepository.getPopularMovies()
}