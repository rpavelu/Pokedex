package com.example.siberspoke.screens.pokelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class PokeListViewModel : ViewModel() {

    private lateinit var pokeList: MutableList<String>

    // The current word
    private val _pokemonName = MutableLiveData<String>()
    val pokemonName: LiveData<String>
        get() = _pokemonName
}