package com.saayi.data.di

import com.saayi.data.repository.MoviesRepository
import com.saayi.data.repository.PostsRepository
import com.saayi.data.repositoryimpl.MoviesRepositoryImpl
import com.saayi.data.repositoryimpl.PostsRepositoryImpl
import com.saayi.network.client.MoviesApiService
import com.saayi.network.client.PostsApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class MainModule {

    @Provides
    @Singleton
    fun providePostsRepository(postsApiService: PostsApiService): PostsRepository {
        return PostsRepositoryImpl(postsApiService)
    }

    @Provides
    @Singleton
    fun provideMoviesRepository(moviesApiService: MoviesApiService): MoviesRepository {
        return MoviesRepositoryImpl(moviesApiService)
    }
}