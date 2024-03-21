package dev.cardoso.cats.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dev.cardoso.cats.domain.repositories.CatFactRepository
import dev.cardoso.cats.domain.usecases.GetCatRandomFactUseCase
import dev.cardoso.cats.domain.usecases.GetCatRandomFactUseCaseImpl


@Module
@InstallIn(ActivityRetainedComponent::class)
class UseCaseModule {

    @Provides
    fun provideGetCatRandomFact(
        catFactRepository: CatFactRepository
    ): GetCatRandomFactUseCase = GetCatRandomFactUseCaseImpl(catFactRepository)
}