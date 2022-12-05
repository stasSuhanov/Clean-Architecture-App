package com.stanislav.domain.repository

import com.stanislav.domain.entity.Post
import kotlinx.coroutines.flow.Flow

interface PostRepository {
    fun getPosts(): Flow<List<Post>>
    fun getPost(id: Long): Flow<Post>
}