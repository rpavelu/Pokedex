package com.example.siberspoke.screens.pokelist

import androidx.lifecycle.ViewModel
import com.example.siberspoke.data.PokeApiResponse
import com.example.siberspoke.data.PokeApiService
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import android.util.Log
import com.example.siberspoke.data.Pokemon
import retrofit2.Callback
import retrofit2.Response
import android.icu.lang.UCharacter.GraphemeClusterBreak.T


class PokeListViewModel : ViewModel() {

    private lateinit var pokeList: List<Pokemon>
    var i: Int = 0


    fun getInfo(offset: Int) {
        val service = PokeApiService.create()
        val pokemonResponseCall = service.getPokemonData(30, offset)

        pokemonResponseCall.enqueue(object : Callback<PokeApiResponse> {

            override fun onFailure(call: Call<PokeApiResponse>, t: Throwable) {
                Log.e("PokeListViewModel", " onFailure: " + t.message)
            }

            override fun onResponse(
                call: Call<PokeApiResponse>,
                response: Response<PokeApiResponse>
            ) {
                if (response.isSuccessful) {
                    val pokeApiResponse = response.body()
                    Log.i("PokeViewModel", "PokemonBody: ${pokeApiResponse.toString()}")
                    pokeList = pokeApiResponse?.resultOfApiRequest!!

                    while (i != 29) {
                        Log.i("PokeViewModel", "Pokemon: " + pokeList[i].name)
                        i++
                    }
                } else {
                    Log.e("PokeListViewModel", " onResponse: " + response.errorBody())
                }
            }
        })
    }
}