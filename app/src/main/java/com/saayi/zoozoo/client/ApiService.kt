package com.saayi.zoozoo.client

import com.saayi.zoozoo.mapper.PostDto
import com.saayi.zoozoo.models.Post
import retrofit2.http.GET

interface ApiService {
    @GET("posts")
    suspend fun getPosts(): List<PostDto>
}