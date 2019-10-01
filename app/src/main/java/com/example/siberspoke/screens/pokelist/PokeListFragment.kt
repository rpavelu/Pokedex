package com.example.siberspoke.screens.pokelist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.siberspoke.R
import com.example.siberspoke.data.Pokemon
import com.example.siberspoke.databinding.PokelistFragmentBinding
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PokeListFragment : Fragment() {

    private lateinit var viewModel: PokeListViewModel
    private lateinit var binding: PokelistFragmentBinding

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

        viewModel = ViewModelProviders.of(this).get(PokeListViewModel::class.java)

        binding.pokeListViewModel = viewModel
        binding.lifecycleOwner = this

        // Retrofit Builder
        val retrofit = Retrofit.Builder()
            .baseUrl("http://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return binding.root
    }
}