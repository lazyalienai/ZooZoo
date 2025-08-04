package com.saayi.network.mapper

import com.saayi.common.models.Post
import com.saayi.network.models.PostsModel

fun PostsModel.toDomain(): Post = Post(id, title, body)