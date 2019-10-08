package com.example.siberspoke.screens.pokeinfo

import com.example.siberspoke.screens.pokeinfo.data.PokemonInfo

interface PokeInfoRepository {
    suspend fun getPokemonInfoData(offset: Int) : List<PokemonInfo>

}