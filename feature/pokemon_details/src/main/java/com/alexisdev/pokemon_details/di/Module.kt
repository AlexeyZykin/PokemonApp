package com.alexisdev.pokemon_details.di

import com.alexisdev.pokemon_details.PokemonDetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val pokemonDetailsFeatureModule = module {
    viewModel { PokemonDetailsViewModel(get()) }
}