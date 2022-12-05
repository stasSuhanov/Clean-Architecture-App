package com.stanislav.domain.repository

import com.stanislav.domain.entity.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun getUsers(): Flow<List<User>>
    fun getUser(id: Long): Flow<User>
}