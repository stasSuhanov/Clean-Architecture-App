package com.stanislav.data_repository.repository

import com.stanislav.data_repository.data_source.local.LocalPostDataSource
import com.stanislav.data_repository.data_source.remote.RemotePostDataSource
import com.stanislav.domain.entity.Post
import com.stanislav.domain.repository.PostRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEach

class PostRepositoryImpl constructor(
    private val remotePostDataSource: RemotePostDataSource,
    private val localPostDataSource: LocalPostDataSource,
) : PostRepository {

    override fun getPosts(): Flow<List<Post>> =
        remotePostDataSource.getPosts().onEach { localPostDataSource.addPosts(it) }

    override fun getPost(id: Long): Flow<Post> =
        remotePostDataSource.getPost(id).onEach { localPostDataSource.addPosts(listOf(it)) }
}