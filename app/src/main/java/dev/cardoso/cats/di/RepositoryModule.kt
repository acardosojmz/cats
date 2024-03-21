package dev.cardoso.cats.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.cardoso.cats.domain.repositories.CatFactRepository
import dev.cardoso.cats.data.repositories.CatFactRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindCatFactRepository(
        catFactRepositoryImpl: CatFactRepositoryImpl
    ): CatFactRepository
}


