package com.example.siberspoke.screens.pokelist

import android.util.Log
import com.example.siberspoke.PokemonsNetworkConverter
import com.example.siberspoke.screens.pokelist.data.network.PokeListService
import com.example.siberspoke.screens.pokelist.data.Pokemon
import com.example.siberspoke.screens.pokelist.data.PokemonListInfo
import com.example.siberspoke.screens.pokelist.data.network.PokeListInfoService

interface PokeListRepository {
    suspend fun getPokemonListData(offset: Int): MutableList<Pokemon>
    suspend fun getPokemonListInfoData(): MutableList<PokemonListInfo>
}

class PokeListRepositoryImpl(private val pokemonsNetworkConverter: PokemonsNetworkConverter) :
    PokeListRepository {

    override suspend fun getPokemonListInfoData(): MutableList<PokemonListInfo> {
        val service = PokeListInfoService.create()
        val pokemonListInfoResponseCall = service.getPokemonListInfoDataService()
        Log.i(
            "PokeListRepository",
            "Pokemon List Info Data: " + pokemonsNetworkConverter.convertListInfo(pokemonListInfoResponseCall)
        )
        return pokemonsNetworkConverter.convertListInfo(pokemonListInfoResponseCall)
    }

    override
    suspend fun getPokemonListData(offset: Int): MutableList<Pokemon> {
        val service = PokeListService.create()
        val pokemonListResponseCall = service.getPokemonListDataService(30, offset)
        Log.i(
            "PokeListRepository",
            "Pokemon List Data" + pokemonsNetworkConverter.convertList(pokemonListResponseCall)
        )
        return pokemonsNetworkConverter.convertList(pokemonListResponseCall)
    }
}