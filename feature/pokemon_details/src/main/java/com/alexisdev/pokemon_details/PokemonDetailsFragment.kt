package com.alexisdev.pokemon_details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.alexisdev.model.PokemonDetails
import com.alexisdev.pokemon_details.databinding.FragmentPokemonDetailsBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class PokemonDetailsFragment : Fragment() {
    private val navArgs: PokemonDetailsFragmentArgs by navArgs()
    private val viewModel by viewModel<PokemonDetailsViewModel>()
    private lateinit var binding: FragmentPokemonDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPokemonDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.fetchPokemonDetails(navArgs.pokemonName)
        subscribeObserver()
        binding.btnBack.setOnClickListener { findNavController().popBackStack() }
    }

    private fun subscribeObserver() {
        viewModel.state.observe(viewLifecycleOwner) { state ->
            when (state) {
                is PokemonDetailsState.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }

                is PokemonDetailsState.Success -> {
                    binding.progressBar.visibility = View.GONE
                    if (state.data != null) {
                        renderUi(state.data)
                    }
                }

                is PokemonDetailsState.Error ->
                    Toast.makeText(context, state.msg, Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun renderUi(pokemonDetails: PokemonDetails) {
        binding.tvPokemonName.text = pokemonDetails.name
        binding.tvHeight.text = pokemonDetails.height.toString()
        binding.tvWeight.text = pokemonDetails.weight.toString()
        binding.tvBaseExperience.text = pokemonDetails.baseExperience.toString()
        binding.tvIsDefault.text =
            if (pokemonDetails.isDefault) getString(R.string.field_is_default_true)
            else getString(R.string.field_is_default_false)
    }
}