package com.example.siberspoke

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.siberspoke.data.Pokemon


class PokeListAdapter(private val context: Context) :
    RecyclerView.Adapter<PokeListAdapter.ViewHolder>() {

    private lateinit var pokemonData: List<Pokemon>

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

        Glide.with(context)
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