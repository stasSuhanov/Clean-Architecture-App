package com.stanislav.domain.repository

import com.stanislav.domain.entity.Interaction
import kotlinx.coroutines.flow.Flow

interface InteractionRepository {
    fun getInteraction(): Flow<Interaction>
    fun saveInteraction(interaction: Interaction): Flow<Interaction>
}