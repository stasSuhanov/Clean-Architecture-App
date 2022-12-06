package com.stanislav.cleanarchitecture.injection

import com.stanislav.data_repository.data_source.local.LocalInteractionDataSource
import com.stanislav.data_repository.data_source.local.LocalPostDataSource
import com.stanislav.data_repository.data_source.local.LocalUserDataSource
import com.stanislav.data_repository.data_source.remote.RemotePostDataSource
import com.stanislav.data_repository.data_source.remote.RemoteUserDataSource
import com.stanislav.data_repository.repository.InteractionRepositoryImpl
import com.stanislav.data_repository.repository.PostRepositoryImpl
import com.stanislav.data_repository.repository.UserRepositoryImpl
import com.stanislav.domain.repository.InteractionRepository
import com.stanislav.domain.repository.PostRepository
import com.stanislav.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    fun providePostRepository(
        remotePostDataSource: RemotePostDataSource,
        localPostDataSource: LocalPostDataSource,
    ): PostRepository = PostRepositoryImpl(
        remotePostDataSource,
        localPostDataSource,
    )

    @Provides
    fun provideUserRepository(
        remoteUserDataSource: RemoteUserDataSource,
        localUserDataSource: LocalUserDataSource,
    ): UserRepository = UserRepositoryImpl(
        remoteUserDataSource,
        localUserDataSource,
    )

    @Provides
    fun provideInteractionRepository(
        interactionDataSource: LocalInteractionDataSource,
    ): InteractionRepository = InteractionRepositoryImpl(interactionDataSource)
}