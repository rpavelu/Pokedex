package com.example.siberspoke.screens.pokeinfo.data.network

import com.example.siberspoke.jsonInfo.Type


data class PokeInfoResponse(
    val height: Int,
    val weight: Int,
    val types: List<Type>
)