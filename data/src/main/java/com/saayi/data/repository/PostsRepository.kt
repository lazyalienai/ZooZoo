package com.saayi.data.repository

import com.saayi.common.models.Post

interface PostsRepository {
    suspend fun getPosts(): List<Post>
}