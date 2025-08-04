package com.saayi.network.di

import com.saayi.network.BuildConfig
import com.saayi.network.client.MoviesApiService
import com.saayi.network.client.PostsApiService
import com.saayi.network.customQualifiers.MoviesRetrofit
import com.saayi.network.customQualifiers.PostsRetrofit
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    @Provides
    fun provideOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @PostsRetrofit
    @Provides
    fun providePostsRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.POSTS_BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @MoviesRetrofit
    @Provides
    fun provideMoviesRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.MOVIES_BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun providePostsApi(@PostsRetrofit retrofit: Retrofit): PostsApiService =
        retrofit.create(PostsApiService::class.java)

    @Provides
    fun provideMoviesApi(@MoviesRetrofit retrofit: Retrofit): MoviesApiService =
        retrofit.create(MoviesApiService::class.java)
}
