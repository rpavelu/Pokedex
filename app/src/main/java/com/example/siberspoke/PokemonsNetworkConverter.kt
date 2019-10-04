package com.example.siberspoke

import com.example.siberspoke.data.Pokemon
import com.example.siberspoke.data.PokeApiResponse

interface PokemonsNetworkConverter {
    fun convert(response: PokeApiResponse): List<Pokemon>
}

const val IMAGE_URL = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/"
const val URL_DIVIDER = '/'

class PokemonsNetworkConverterImpl : PokemonsNetworkConverter {

    override fun convert(response: PokeApiResponse): List<Pokemon> =
        response.results.map { dto ->
            val imageUrlSuffix = dto.url.takeLastWhile {
                it != URL_DIVIDER
            }
            Pokemon(dto.name, IMAGE_URL + imageUrlSuffix)
        }
}