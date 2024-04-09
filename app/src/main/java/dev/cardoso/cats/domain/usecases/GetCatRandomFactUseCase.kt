package dev.cardoso.cats.domain.usecases

import dev.cardoso.cats.domain.models.CatFactStates
import kotlinx.coroutines.flow.Flow

interface GetCatRandomFactUseCase {
    suspend operator fun invoke(): Flow<CatFactStates>
}