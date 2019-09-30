package com.example.siberspoke.screens.pokelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient


class PokeListViewModel : ViewModel() {

    private lateinit var pokeList: MutableList<String>

    // Poke API
    private val pokeApi = PokeApiClient()

    // The current word
    private val _pokemonName = MutableLiveData<String>()
    val pokemonName: LiveData<String>
        get() = _pokemonName

    fun getPokemon() {
        _pokemonName.value = pokeApi.getPokemonSpecies(1).toString()
    }
}