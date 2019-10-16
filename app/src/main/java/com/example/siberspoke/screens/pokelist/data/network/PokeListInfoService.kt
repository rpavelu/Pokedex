package com.example.siberspoke.screens.pokelist.data.network

import com.example.siberspoke.screens.pokelist.listPosition
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface PokeListInfoService {

    @GET(".")
    suspend fun getPokemonListInfoDataService(): PokeListInfoResponse

    companion object Factory {
        fun create(): PokeListInfoService {
            val retrofit = Retrofit.Builder()
                .baseUrl("http://pokeapi.co/api/v2/pokemon/$listPosition/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(PokeListInfoService::class.java)
        }
    }
}