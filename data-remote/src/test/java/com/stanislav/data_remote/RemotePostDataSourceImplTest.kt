package com.stanislav.data_remote

import com.stanislav.data_remote.networking.post.PostApiModel
import com.stanislav.data_remote.networking.post.PostService
import com.stanislav.data_remote.source.RemotePostDataSourceImpl
import com.stanislav.domain.entity.Post
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class RemotePostDataSourceImplTest {

    private val postService = mock<PostService>()
    private val postDataSource = RemotePostDataSourceImpl(postService)

    @ExperimentalCoroutinesApi
    @Test
    fun testGetPosts() = runBlockingTest {
        val remotePosts = listOf(PostApiModel(1, 1, "title", "body"))
        val expectedPosts = listOf(Post(1, 1, "title", "body"))
        whenever(postService.getPosts()).thenReturn(remotePosts)
        val result = postDataSource.getPosts().first()
        Assert.assertEquals(expectedPosts, result)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun testGetPost() = runBlockingTest {
        val id = 1L
        val remotePost = PostApiModel(id, 1, "title", "body")
        val expectedPost = Post(id, 1, "title", "body")
        whenever(postService.getPost(id)).thenReturn(remotePost)
        val result = postDataSource.getPost(id).first()
        Assert.assertEquals(expectedPost, result)
    }
}