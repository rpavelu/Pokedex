package com.example.siberspoke.screens.pokelist.data.network

import com.example.siberspoke.screens.pokelist.data.PokemonDto

data class PokeListResponse(
    val results: List<PokemonDto>
)