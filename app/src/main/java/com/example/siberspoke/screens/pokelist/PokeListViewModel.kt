package com.example.siberspoke.screens.pokelist

import android.app.Application
import androidx.lifecycle.ViewModel
import com.example.siberspoke.data.PokeApiResponse
import com.example.siberspoke.data.PokeApiService
import retrofit2.Call
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import retrofit2.Callback
import retrofit2.Response
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.siberspoke.PokeListAdapter
import com.example.siberspoke.PokemonsNetworkConverterImpl
import com.example.siberspoke.data.Pokemon
import com.example.siberspoke.data.PokemonDto
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext


class PokeListViewModel(
    private val pokeListRepository: PokeListRepository
) : ViewModel(), CoroutineScope {

    private val _pokemonList = MutableLiveData<List<Pokemon>>()
    val pokemonList: LiveData<List<Pokemon>>
        get() = _pokemonList

    private val viewModelJob = SupervisorJob()
    override val coroutineContext: CoroutineContext = Dispatchers.Main + viewModelJob

    override fun onCleared() {
        viewModelJob.cancel()
    }

    fun getData(offset: Int) {
        launch {
            pokeListRepository.getData(offset)
        }
    }
}