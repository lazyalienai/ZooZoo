package com.saayi.network.mapper

import com.saayi.common.models.PopularMovies
import com.saayi.common.models.Result
import com.saayi.network.BuildConfig
import com.saayi.network.models.PopularMoviesModel
import com.saayi.network.models.ResultModel

fun PopularMoviesModel.toDomain(): PopularMovies {
    return PopularMovies(
        page = page,
        results = results.map { it.toDomain() },
        totalPages = totalPages,
        totalResults = totalResults
    )
}

fun ResultModel.toDomain(): Result {
    return Result(
        adult = adult,
        backdropPath = backdropPath,
        genreIds = genreIds,
        id = id,
        originalLanguage = originalLanguage,
        originalTitle = originalTitle,
        overview = overview,
        popularity = popularity,
        posterPath = BuildConfig.MOVIES_IMAGE_BASE_URL + posterPath,
        releaseDate = releaseDate,
        title = title,
        video = video,
        voteAverage = voteAverage,
        voteCount = voteCount
    )
}