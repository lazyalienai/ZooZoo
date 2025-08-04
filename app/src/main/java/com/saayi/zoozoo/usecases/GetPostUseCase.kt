package com.saayi.zoozoo.usecases

import com.saayi.common.models.Post
import com.saayi.data.repository.PostsRepository
import javax.inject.Inject

class GetPostsUseCase @Inject constructor(private val repository: PostsRepository) {
    suspend operator fun invoke(): List<Post> = repository.getPosts()
}
