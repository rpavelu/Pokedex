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
import com.example.siberspoke.data.PokemonDto


class PokeListViewModel : AndroidViewModel(Application()) {

    private val _pokemonList = MutableLiveData<List<PokemonDto>>()
    val pokemonList: LiveData<List<PokemonDto>>
        get() = _pokemonList

    fun getInfo(offset: Int) {
        val service = PokeApiService.create()
        val pokemonResponseCall = service.getPokemonData(30, offset)

        pokemonResponseCall.enqueue(object : Callback<PokeApiResponse> {

            override fun onResponse(
                call: Call<PokeApiResponse>,
                response: Response<PokeApiResponse>
            ) {
                if (response.isSuccessful) {
                    val pokeApiResponse = response.body()
                    val pokeList = pokeApiResponse?.results

                    _pokemonList.value = pokeList
                    val pokeListToAdd = PokemonsNetworkConverterImpl().convert(pokeApiResponse!!)

                    // Че тут сделать >_<
                    PokeListAdapter(getApplication()).addPokemonList(pokeListToAdd)
                }
            }

            override fun onFailure(call: Call<PokeApiResponse>, t: Throwable) {
                Log.e("PokeListViewModel", " onFailure: " + t.message)
            }
        })
    }
}