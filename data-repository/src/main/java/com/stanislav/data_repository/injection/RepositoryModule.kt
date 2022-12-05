package com.stanislav.data_repository.injection

import com.stanislav.data_repository.repository.InteractionRepositoryImpl
import com.stanislav.data_repository.repository.PostRepositoryImpl
import com.stanislav.data_repository.repository.UserRepositoryImpl
import com.stanislav.domain.repository.InteractionRepository
import com.stanislav.domain.repository.PostRepository
import com.stanislav.domain.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindPostRepository(postRepositoryImpl: PostRepositoryImpl): PostRepository

    @Binds
    abstract fun bindUserRepository(userRepositoryImpl: UserRepositoryImpl): UserRepository

    @Binds
    abstract fun bindInteractionRepository(interactionRepositoryImpl: InteractionRepositoryImpl): InteractionRepository
}