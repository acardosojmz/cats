package dev.cardoso.cats.domain.usecases

import dev.cardoso.cats.domain.models.CatFactStates

interface GetCatRandomFactUseCase {
    suspend operator fun invoke(): CatFactStates
}