package dev.cardoso.cats.domain.repositories

import dev.cardoso.cats.domain.models.CatFactStates

interface CatFactRepository {
    suspend fun getCatRandomFact(): CatFactStates
}