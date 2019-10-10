package com.example.siberspoke.screens.pokeinfo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.siberspoke.screens.pokeinfo.data.PokemonInfo
import com.example.siberspoke.screens.pokelist.PokeListRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class PokeInfoViewModel(
    private val pokeInfoRepository: PokeInfoRepository
) : ViewModel(), CoroutineScope {

    private val _pokemonInfo = MutableLiveData<PokemonInfo>()
    val pokemonInfo: LiveData<PokemonInfo>
        get() = _pokemonInfo

    private val _pokemonHeight = MutableLiveData<Int>()
    val pokemonHeight: LiveData<Int>
        get() = _pokemonHeight

    private val _pokemonWeight = MutableLiveData<Int>()
    val pokemonWeight: LiveData<Int>
        get() = _pokemonWeight

    private val _pokemonType = MutableLiveData<String>()
    val pokemonType: LiveData<String>
        get() = _pokemonType

    private val viewModelJob = SupervisorJob()
    override val coroutineContext: CoroutineContext = Dispatchers.Main + viewModelJob

    override fun onCleared() {
        viewModelJob.cancel()
    }

    fun getData() {
        launch {
            _pokemonInfo.value = pokeInfoRepository.getPokemonInfoData()
            _pokemonHeight.value = pokemonInfo.value!!.height
            _pokemonWeight.value = pokemonInfo.value!!.weight
            _pokemonType.value = pokemonInfo.value!!.type
            Log.i(
                "PokeInfoViewModel",
                "getPokemonInfoData launched" + _pokemonInfo.value.toString()
            )
        }
    }
}