package com.example.siberspoke.screens.pokelist

import android.util.Log
import com.example.siberspoke.PokemonsNetworkConverter
import com.example.siberspoke.screens.pokelist.data.network.PokeListService
import com.example.siberspoke.screens.pokelist.data.Pokemon

interface PokeListRepository {
    suspend fun getPokemonListData(offset: Int): List<Pokemon>
}

class PokeListRepositoryImpl(private val pokemonsNetworkConverter: PokemonsNetworkConverter) :
    PokeListRepository {
    override
    suspend fun getPokemonListData(offset: Int): List<Pokemon> {
        val service = PokeListService.create()
        val pokemonListResponseCall = service.getPokemonListDataService(30, offset)
        Log.i(
            "PokeListRepository",
            " " + pokemonsNetworkConverter.convertList(pokemonListResponseCall)
        )
        return pokemonsNetworkConverter.convertList(pokemonListResponseCall)
    }
}