package com.example.siberspoke.screens.pokeinfo

import android.util.Log
import com.example.siberspoke.PokemonsNetworkConverter
import com.example.siberspoke.screens.pokeinfo.data.PokemonInfo
import com.example.siberspoke.screens.pokeinfo.data.network.PokeInfoService

interface PokeInfoRepository {
    suspend fun getPokemonInfoData(): PokemonInfo
}

class PokeInfoRepositoryImpl(private val pokemonsNetworkConverter: PokemonsNetworkConverter) :
    PokeInfoRepository {
    override
    suspend fun getPokemonInfoData(): PokemonInfo {
        val service = PokeInfoService.create()
        val pokemonInfoResponseCall = service.getPokemonInfoDataService()
        Log.i(
            "PokeInfoRepository",
            " " + pokemonsNetworkConverter.convertInfo(pokemonInfoResponseCall)
        )
        return pokemonsNetworkConverter.convertInfo(pokemonInfoResponseCall)
    }
}