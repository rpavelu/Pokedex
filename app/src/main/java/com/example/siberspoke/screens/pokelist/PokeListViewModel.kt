package com.example.siberspoke.screens.pokelist

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.siberspoke.screens.pokelist.data.Pokemon
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
            Log.i("PokeListViewModel", "getPokemonListData launched")
            _pokemonList.value = pokeListRepository.getPokemonListData(offset)
        }
    }
}