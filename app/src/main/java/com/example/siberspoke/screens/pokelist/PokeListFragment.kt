package com.example.siberspoke.screens.pokelist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.siberspoke.PokeListAdapter
import com.example.siberspoke.PokemonsNetworkConverterImpl
import com.example.siberspoke.R
import com.example.siberspoke.data.Pokemon
import com.example.siberspoke.databinding.PokelistFragmentBinding

class PokeListFragment : Fragment() {

    private lateinit var viewModel: PokeListViewModel
    private lateinit var binding: PokelistFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.pokelist_fragment,
            container,
            false
        )

        viewModel = ViewModelProviders.of(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return PokeListViewModel(PokeListRepositoryImpl(PokemonsNetworkConverterImpl())) as T
            }
        }).get(PokeListViewModel::class.java)

        binding.pokeListViewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        viewModel.getData(0)

        val adapter = PokeListAdapter()
        binding.pokemonRecyclerview.adapter = adapter

        viewModel.pokemonList.observe(viewLifecycleOwner, Observer {
            adapter.addPokemonList(viewModel.pokemonList.value.orEmpty())
        })

        return binding.root
    }
}