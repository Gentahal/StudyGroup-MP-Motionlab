package com.example.jcmotion.network

import com.example.jcmotion.model.CatFact
import retrofit2.http.GET

interface CatFactsApi {
    @GET("fact")
    suspend fun getCatFact(): CatFact
}
