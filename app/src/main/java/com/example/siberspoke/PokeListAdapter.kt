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


class PokeListAdapter(
    private val context: Context,
    private var pokemonData: List<Pokemon>
) :
    RecyclerView.Adapter<PokeListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pokemon_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val p = pokemonData[position]
        holder.pokemonTextView?.text = p.name

        Glide.with(context)
            .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/$p.png")
            .into(holder.pokemonImageView)
    }

    override fun getItemCount(): Int {
        return pokemonData.size
    }

    /*fun addPokemonList(pokemonList: List<Pokemon>) {
        pokemonData = pokemonList
        notifyDataSetChanged()
    }*/

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var pokemonImageView: ImageView? = null
        var pokemonTextView: TextView? = null

        init {
            pokemonImageView = itemView.findViewById(R.id.pokemon_image_view) as ImageView
            pokemonTextView = itemView.findViewById(R.id.pokemon_text_view) as TextView
        }
    }
}