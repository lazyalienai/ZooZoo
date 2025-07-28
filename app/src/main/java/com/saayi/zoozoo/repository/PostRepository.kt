package com.saayi.zoozoo.repository

import com.saayi.zoozoo.models.Post

interface PostRepository {
    suspend fun getPosts(): List<Post>
}