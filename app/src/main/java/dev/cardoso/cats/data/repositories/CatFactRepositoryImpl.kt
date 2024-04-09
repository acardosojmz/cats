package dev.cardoso.cats.data.repositories

import dev.cardoso.cats.domain.repositories.CatFactRepository
import dev.cardoso.cats.domain.models.CatFactStates
import dev.cardoso.cats.data.network.CatFactsService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class CatFactRepositoryImpl @Inject constructor (
    private val catFactsService: CatFactsService
): CatFactRepository {
    override suspend fun getCatRandomFact(): Flow<CatFactStates> {
        return try {
            val response = catFactsService.getCatRandomFact()
            val fact = response.body()
            return if (fact != null) flow{ emit (CatFactStates.CatFactData(fact))}
            else  flow{ emit ( CatFactStates.Error(IOException("Data is null")))}
        } catch (exception: Exception) {
            flow{ emit ( CatFactStates.Error(exception))}
        }
    }
}