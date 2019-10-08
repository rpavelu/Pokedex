package com.example.siberspoke

import com.example.siberspoke.screens.pokelist.data.Pokemon
import com.example.siberspoke.screens.pokelist.data.network.PokeListResponse

interface PokemonsNetworkConverter {
    fun convert(response: PokeListResponse): List<Pokemon>
}

private const val IMAGE_URL =
    "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/"
private const val URL_DIVIDER = '/'
private const val IMAGE_SUFFIX = ".png"

class PokemonsNetworkConverterImpl : PokemonsNetworkConverter {

    override fun convert(response: PokeListResponse): List<Pokemon> =
        response.results.map { dto ->
            val pokemonId = dto.url.split(URL_DIVIDER)
                .filterNot {
                    it.isBlank()
                }.last()

            Pokemon(
                dto.name,
                IMAGE_URL + pokemonId + IMAGE_SUFFIX
            )
        }
}