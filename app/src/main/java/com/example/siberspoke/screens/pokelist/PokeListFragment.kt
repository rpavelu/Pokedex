package com.example.siberspoke.screens.pokelist

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.siberspoke.PokeListAdapter
import com.example.siberspoke.PokemonsNetworkConverterImpl
import com.example.siberspoke.R
import com.example.siberspoke.databinding.PokelistFragmentBinding

// It needs to parse exact Pokemon
var listPosition: Int = 0

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

        // Creating ViewModel object
        viewModel = ViewModelProviders.of(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return PokeListViewModel(PokeListRepositoryImpl(PokemonsNetworkConverterImpl())) as T
            }
        }).get(PokeListViewModel::class.java)

        // Binding
        binding.pokeListViewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        // Getting data starting from element at 0
        viewModel.getData(0)

        // Adding a divider to RecyclerView
        binding.pokemonRecyclerview.addItemDecoration(
            DividerItemDecoration(
                context,
                LinearLayoutManager.VERTICAL
            )
        )

        // Implementing adapter for RecyclerView
        val adapter = PokeListAdapter()
        binding.pokemonRecyclerview.adapter = adapter


        // Setting on click listener to adapter
        adapter.setOnItemClickListener(object : PokeListAdapter.ClickListener {
            override fun onClick(pos: Int, aView: View) {
                listPosition = pos + 1
                findNavController().navigate(PokeListFragmentDirections.actionPokelistDestinationToPokeinfoDestination())
            }
        })

        // Adding Pokemons to pokemonList in ViewModel
        viewModel.pokemonList.observe(viewLifecycleOwner, Observer {
            adapter.addPokemonList(viewModel.pokemonList.value.orEmpty())
            Log.i("PokeListFragment", "adapter called")
        })

        return binding.root
    }
}