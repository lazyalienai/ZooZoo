package com.saayi.network.client


import com.saayi.network.models.PostsModel
import com.saayi.network.utils.Constants.POSTS
import retrofit2.http.GET

interface PostsApiService {
    @GET(POSTS)
    suspend fun getPosts(): List<PostsModel>
}