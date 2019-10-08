package com.example.siberspoke

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.siberspoke.screens.pokelist.data.Pokemon


class PokeListAdapter :
    RecyclerView.Adapter<PokeListAdapter.ViewHolder>() {

    private var pokemonData: List<Pokemon> = emptyList()

    fun addPokemonList(pokemonList: List<Pokemon>) {
        pokemonData = pokemonList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pokemon_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val poke: Pokemon = pokemonData[position]
        holder.pokemonTextView.text = poke.name

        Glide.with(holder.itemView.context)
            .load(poke.image)
            .into(holder.pokemonImageView)
    }

    override fun getItemCount() = pokemonData.size

    class ViewHolder(
        itemView: View,
        val pokemonImageView: ImageView = itemView.findViewById(R.id.pokemon_image_view),
        val pokemonTextView: TextView = itemView.findViewById(R.id.pokemon_text_view)
    ) : RecyclerView.ViewHolder(itemView)
}