package com.example.siberspoke.screens.pokelist.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface PokeListService {

    @GET("pokemon")
    suspend fun getPokemonListDataService(@Query("limit") limit: Int, @Query("offset") offset: Int): PokeListResponse

    companion object Factory {
        fun create(): PokeListService {
            val retrofit = Retrofit.Builder()
                .baseUrl("http://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(PokeListService::class.java)
        }
    }
}