package com.stanislav.data_repository.data_source.local

import com.stanislav.domain.entity.Interaction
import kotlinx.coroutines.flow.Flow

interface LocalInteractionDataSource {
    fun getInteraction(): Flow<Interaction>
    suspend fun saveInteraction(interaction: Interaction)
}