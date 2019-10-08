package com.example.siberspoke.screens.pokeinfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.siberspoke.R
import com.example.siberspoke.databinding.PokeinfoFragmentBinding

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

        viewModel = ViewModelProviders.of(this).get(PokeInfoViewModel::class.java)

        binding.pokeInfoViewModel = viewModel
        binding.lifecycleOwner = this

        return binding.root
    }
}