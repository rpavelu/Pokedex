package com.example.siberspoke.screens.pokeinfo.data.network

import com.example.siberspoke.screens.pokelist.listPosition
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface PokeInfoService {

    @GET(".")
    suspend fun getPokemonInfoDataService(): PokeInfoResponse

    companion object Factory {
        fun create(): PokeInfoService {
            val retrofit = Retrofit.Builder()
                .baseUrl("http://pokeapi.co/api/v2/pokemon/$listPosition/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(PokeInfoService::class.java)
        }
    }
}