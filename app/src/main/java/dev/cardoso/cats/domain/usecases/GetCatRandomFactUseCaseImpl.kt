package dev.cardoso.cats.domain.usecases

import dev.cardoso.cats.domain.models.CatFactStates
import dev.cardoso.cats.domain.repositories.CatFactRepository


class GetCatRandomFactUseCaseImpl(
    private val catFactRepository: CatFactRepository
): GetCatRandomFactUseCase {
    override suspend fun invoke(): CatFactStates = catFactRepository.getCatRandomFact()
}