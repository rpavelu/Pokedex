package com.example.siberspoke.screens.pokelist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.siberspoke.R
import com.example.siberspoke.data.Pokemon
import java.util.ArrayList


// TODO Refactor code to make it work with TextView and Image
/*class PokeListAdapter(context: Context, words: ArrayList<Pokemon>) :
    ArrayAdapter<Pokemon>(context, 0, words) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var listItemView = convertView
        if (listItemView == null) {
            listItemView = LayoutInflater.from(context).inflate(
                R.layout.pokeinfo_fragment, parent, false
            )
        }

        val currentPokemon = getItem(position)

        val pokemonNameTextView = listItemView!!.findViewById(R.id.pokemonName)
        pokemonNameTextView.setText(currentPokemon!!))

        val wordImageView = listItemView.findViewById(R.id.imageOfPokemon)
        if (currentPokemon!!.hasImage()) {
            wordImageView.setVisibility(View.VISIBLE)
            wordImageView.setImageResource(currentPokemon!!.getWordImage())
        } else
            wordImageView.setVisibility(View.GONE)

        return listItemView
    }
}*/