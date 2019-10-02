package com.example.siberspoke.data

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface PokeApiService {

    @GET("pokemon")
    fun getPokemonData(@Query("limit") limit: Int, @Query("offset") offset: Int): Call<PokeApiResponse>
    //fun getPokemon(): Deferred<Response<List<Pokemon>>>

    companion object Factory {
        fun create(): PokeApiService {
            val retrofit = Retrofit.Builder()
                .baseUrl("http://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(PokeApiService::class.java)
        }
    }
}