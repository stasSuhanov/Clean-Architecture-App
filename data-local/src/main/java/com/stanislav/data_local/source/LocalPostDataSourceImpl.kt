package com.stanislav.data_local.source

import com.stanislav.data_local.db.post.PostDao
import com.stanislav.data_local.db.post.PostEntity
import com.stanislav.data_repository.data_source.local.LocalPostDataSource
import com.stanislav.domain.entity.Post
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class LocalPostDataSourceImpl @Inject constructor(
    private val postDao: PostDao,
) : LocalPostDataSource {

    override fun getPosts(): Flow<List<Post>> =
        postDao.getPosts().map { posts ->
            posts.map {
                Post(it.id, it.userId, it.title, it.body)
            }
        }

    override suspend fun addPosts(posts: List<Post>) =
        postDao.insertPosts(posts.map {
            PostEntity(
                it.id, it.userId, it.title, it.body
            )
        })
}