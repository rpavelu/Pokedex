package com.example.siberspoke.screens.pokelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.siberspoke.data.PokeApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class PokeListViewModel : ViewModel() {

    private lateinit var pokeList: MutableList<String>

    // The current word
    private val _pokemonName = MutableLiveData<String>()
    val pokemonName: LiveData<String>
        get() = _pokemonName

    // Retrofit Builder
    private val retrofit = Retrofit.Builder()
        .baseUrl("http://pokeapi.co/api/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val service = retrofit.create(PokeApiService::class.java)

    fun getInfo() {
        val call = service.getPokemonData(20, 20)
    }
}