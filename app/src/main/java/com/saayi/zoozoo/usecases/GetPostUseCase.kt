package com.saayi.zoozoo.usecases

import com.saayi.zoozoo.models.Post
import com.saayi.zoozoo.repository.PostRepository
import javax.inject.Inject

class GetPostsUseCase @Inject constructor(private val repository: PostRepository) {
    suspend operator fun invoke(): List<Post> = repository.getPosts()
}
