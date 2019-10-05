package com.example.siberspoke.screens.pokelist

import com.example.siberspoke.PokemonsNetworkConverter
import com.example.siberspoke.data.PokeApiService
import com.example.siberspoke.data.Pokemon

interface PokeListRepository {
    suspend fun getData(offset: Int) : List<Pokemon>
}

class PokeListRepositoryImpl (private val pokemonsNetworkConverter: PokemonsNetworkConverter) : PokeListRepository {
    override
    suspend fun getData(offset: Int) : List<Pokemon> {
        val service = PokeApiService.create()
        val pokemonResponseCall = service.getPokemonData(30, offset)
        return pokemonsNetworkConverter.convert(pokemonResponseCall)
    }
}