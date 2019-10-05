package com.example.siberspoke.screens.pokelist

import com.example.siberspoke.data.Pokemon
import com.example.siberspoke.screens.pokelist.pagination.States

class PokeListViewModelDelegate {
    private inner class Empty : States<Pokemon> {
        override fun showNextPage() {

        }
    }

    private inner class EmptyProgress : States<Pokemon> {

    }
}