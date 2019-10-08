package com.example.siberspoke.screens.pokeinfo.data.network

import com.example.siberspoke.screens.pokeinfo.data.PokemonTypes

data class PokeInfoResponse(
    val heights: Int,
    val weight: Int,
    val types: List<PokemonTypes>
)