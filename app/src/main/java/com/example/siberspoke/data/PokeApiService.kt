package com.example.siberspoke.data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PokeApiService {
    @GET("pokemon")
    fun getPokemonData(@Query("limit") limit: Int, @Query("offset") offset: Int): Call<PokeApiResponse>
}