package dev.cardoso.cats.domain.usecases

import dev.cardoso.cats.domain.models.CatFactStates
import dev.cardoso.cats.domain.repositories.CatFactRepository
import kotlinx.coroutines.flow.Flow


class GetCatRandomFactUseCaseImpl(
    private val catFactRepository: CatFactRepository
): GetCatRandomFactUseCase {
    override suspend fun invoke(): Flow<CatFactStates> = catFactRepository.getCatRandomFact()
}