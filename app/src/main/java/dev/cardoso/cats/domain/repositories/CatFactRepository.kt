package dev.cardoso.cats.domain.repositories

import dev.cardoso.cats.domain.models.CatFactStates
import kotlinx.coroutines.flow.Flow

interface CatFactRepository {
    suspend fun getCatRandomFact(): Flow<CatFactStates>
}