package com.stanislav.data_remote

import com.stanislav.data_remote.networking.user.UserApiModel
import com.stanislav.data_remote.networking.user.UserService
import com.stanislav.data_remote.source.RemoteUserDataSourceImpl
import com.stanislav.domain.entity.User
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class RemoteUserDataSourceImplTest {

    private val userService = mock<UserService>()
    private val userDataSource = RemoteUserDataSourceImpl(userService)

    @ExperimentalCoroutinesApi
    @Test
    fun testGetUsers() = runBlockingTest {
        val remoteUsers = listOf(UserApiModel(1, "name", "username", "email"))
        val expectedUsers = listOf(User(1, "name", "username", "email"))
        whenever(userService.getUsers()).thenReturn(remoteUsers)
        val result = userDataSource.getUsers().first()
        Assert.assertEquals(expectedUsers, result)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun testGetUser() = runBlockingTest {
        val id = 1L
        val remoteUser = UserApiModel(id, "name", "username", "email")
        val user = User(id, "name", "username", "email")
        whenever(userService.getUser(id)).thenReturn(remoteUser)
        val result = userDataSource.getUser(id).first()
        Assert.assertEquals(user, result)
    }
}