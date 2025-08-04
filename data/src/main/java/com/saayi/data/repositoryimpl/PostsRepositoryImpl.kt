package com.saayi.data.repositoryimpl

import com.saayi.common.models.Post
import com.saayi.data.repository.PostsRepository
import com.saayi.network.client.PostsApiService
import com.saayi.network.mapper.toDomain
import javax.inject.Inject

class PostsRepositoryImpl @Inject constructor(private val postsApiService: PostsApiService) : PostsRepository {
    override suspend fun getPosts(): List<Post> {
        return postsApiService.getPosts().map { it.toDomain() }
    }
}
