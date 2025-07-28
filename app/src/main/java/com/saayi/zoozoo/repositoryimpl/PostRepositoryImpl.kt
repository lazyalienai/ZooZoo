package com.saayi.zoozoo.repositoryimpl

import com.saayi.zoozoo.client.ApiService
import com.saayi.zoozoo.mapper.toDomain
import com.saayi.zoozoo.models.Post
import com.saayi.zoozoo.repository.PostRepository

class PostRepositoryImpl(private val apiService: ApiService) : PostRepository {
    override suspend fun getPosts(): List<Post> {
        return apiService.getPosts().map { it.toDomain() }
    }
}
