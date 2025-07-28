package com.saayi.zoozoo.mapper

import com.saayi.zoozoo.models.Post

data class PostDto(val id: Int, val title: String, val body: String)

fun PostDto.toDomain(): Post = Post(id, title, body)