package com.example.siberspoke.screens.pokelist

import android.app.Application
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.get
import com.example.siberspoke.*
import com.example.siberspoke.databinding.PokelistFragmentBinding
import kotlinx.android.synthetic.main.pokelist_fragment.*

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

        viewModel.getInfo(0)

        val adapter = PokeListAdapter(context!!)
        binding.pokemonRecyclerview.adapter = adapter

        return binding.root
    }
}