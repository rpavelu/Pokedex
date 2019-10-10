package com.example.siberspoke.screens.pokeinfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.siberspoke.PokemonsNetworkConverterImpl
import com.example.siberspoke.R
import com.example.siberspoke.databinding.PokeinfoFragmentBinding
import com.example.siberspoke.pokemonName

class PokeInfoFragment : Fragment() {

    private lateinit var viewModel: PokeInfoViewModel
    private lateinit var binding: PokeinfoFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.pokeinfo_fragment,
            container,
            false
        )

        // Creating ViewModel object
        viewModel = ViewModelProviders.of(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return PokeInfoViewModel(PokeInfoRepositoryImpl(PokemonsNetworkConverterImpl())) as T
            }
        }).get(PokeInfoViewModel::class.java)

        // Binding
        binding.pokeInfoViewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.getData()

        // Add tittle to fragment
        (activity as AppCompatActivity).supportActionBar?.title = pokemonName.capitalize()

        return binding.root
    }
}