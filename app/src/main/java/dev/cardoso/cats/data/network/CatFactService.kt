package dev.cardoso.cats.data.network

import dev.cardoso.cats.domain.models.Fact
import retrofit2.Response
import retrofit2.http.GET

interface CatFactsService {
    @GET("/facts/random")
    suspend fun getCatRandomFact(): Response<Fact>
}