package com.example.siberspoke

import android.util.Log
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.siberspoke.screens.pokelist.data.Pokemon
import com.example.siberspoke.screens.pokelist.listPosition

var pokemonName: String = ""

class PokeListAdapter :
    RecyclerView.Adapter<PokeListAdapter.ViewHolder>() {
    private var pokemonData: List<Pokemon> = emptyList()
    lateinit var mClickListener: ClickListener


    fun setOnItemClickListener(aClickListener: ClickListener) {
        mClickListener = aClickListener
    }

    interface ClickListener {
        fun onClick(pos: Int, aView: View)
    }

    fun addPokemonList(pokemonList: MutableList<Pokemon>) {
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

    inner class ViewHolder(
        itemView: View,
        val pokemonImageView: ImageView = itemView.findViewById(R.id.pokemon_image_view),
        val pokemonTextView: TextView = itemView.findViewById(R.id.pokemon_text_view)
    ) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        override fun onClick(v: View) {
            mClickListener.onClick(adapterPosition, v)
            pokemonName = pokemonData[listPosition-1].name
            Log.i("PokeListAdapter", "ListPosition: $listPosition")
            Log.i("PokeListAdapter", "adapterPosition: $adapterPosition")
            Log.i("PokeListAdapter", "adapterPokemonName: $pokemonName")
        }

        init {
            itemView.setOnClickListener(this)
        }
    }
}