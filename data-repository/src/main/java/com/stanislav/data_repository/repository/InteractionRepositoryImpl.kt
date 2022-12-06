package com.stanislav.data_repository.repository

import com.stanislav.data_repository.data_source.local.LocalInteractionDataSource
import com.stanislav.domain.entity.Interaction
import com.stanislav.domain.repository.InteractionRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow

class InteractionRepositoryImpl constructor(
    private val interactionDataSource: LocalInteractionDataSource,
) : InteractionRepository {

    override fun getInteraction(): Flow<Interaction> = interactionDataSource.getInteraction()

    override fun saveInteraction(interaction: Interaction): Flow<Interaction> = flow {
        interactionDataSource.saveInteraction(interaction)
        this.emit(Unit)
    }.flatMapLatest { getInteraction() }
}