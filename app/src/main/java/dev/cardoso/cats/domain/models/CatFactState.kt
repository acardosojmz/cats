package dev.cardoso.cats.domain.models

sealed class CatFactStates {
    object Init: CatFactStates()
    object Loading: CatFactStates()
    data class CatFactData(val fact: Fact): CatFactStates()
    data class Error(val error: Throwable): CatFactStates()
}