package com.example.siberspoke.screens.pokelist

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.siberspoke.PokeListAdapter
import com.example.siberspoke.R
import com.example.siberspoke.data.PokeApiResponse
import com.example.siberspoke.data.PokeApiService
import com.example.siberspoke.data.Pokemon
import com.example.siberspoke.databinding.PokelistFragmentBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PokeListFragment : Fragment() {

    private lateinit var viewModel: PokeListViewModel
    private lateinit var binding: PokelistFragmentBinding
    private lateinit var pokeList: List<Pokemon>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View {

        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.pokelist_fragment,
            container,
            false
        )

        val listOfPokemon: List<Pokemon> = getInfo(0)

        val adapter = PokeListAdapter(context!!, listOfPokemon)
        binding.pokemonRecyclerview.adapter = adapter

        viewModel = ViewModelProviders.of(this).get(PokeListViewModel::class.java)

        binding.pokeListViewModel = viewModel
        binding.lifecycleOwner = this

        return binding.root
    }

    var i: Int = 0

    private fun getInfo(offset: Int): List<Pokemon> {
        val service = PokeApiService.create()
        val pokemonResponseCall = service.getPokemonData(30, offset)

        pokemonResponseCall.enqueue(object : Callback<PokeApiResponse> {

            override fun onFailure(call: Call<PokeApiResponse>, t: Throwable) {
                Log.e("PokeListViewModel", " onFailure: " + t.message)
            }

            override fun onResponse(
                call: Call<PokeApiResponse>,
                response: Response<PokeApiResponse>
            ) {
                if (response.isSuccessful) {
                    val pokeApiResponse = response.body()
                    pokeList = pokeApiResponse?.results!!

                    while (i != 29) {
                        Log.i("PokeViewModel", "Pokemon: " + pokeList[i].name)
                        i++
                    }
                } else {
                    Log.e("PokeListViewModel", " onResponse: " + response.errorBody())
                }
            }
        })
        return pokeList
    }
}