package com.alexisdev.pokemon_catalog

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.alexisdev.model.Pokemon
import com.alexisdev.pokemon_catalog.databinding.FragmentPokemonCatalogBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class PokemonCatalogFragment : Fragment() {
    private lateinit var binding: FragmentPokemonCatalogBinding
    private val viewModel by viewModel<PokemonCatalogViewModel>()
    private val adapter by lazy {
        PokemonAdapter(object : PokemonAdapter.ClickListener {
            override fun onClick(pokemon: Pokemon) {
                val action =
                    PokemonCatalogFragmentDirections.actionPokemonCatalogFragmentToNavGraphPokemonDetails(pokemon.name)
                findNavController().navigate(action)
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPokemonCatalogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        subscribeObserver()
    }

    private fun subscribeObserver() {
        viewModel.pokemons.observe(viewLifecycleOwner) { pagingData ->
            adapter.submitData(lifecycle, pagingData)
        }
    }

    private fun initRecyclerView() {
        binding.rvPokemons.layoutManager = LinearLayoutManager(context)
        binding.rvPokemons.adapter = adapter
    }
}