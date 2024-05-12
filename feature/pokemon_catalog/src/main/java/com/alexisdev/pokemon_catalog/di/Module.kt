package com.alexisdev.pokemon_catalog.di

import com.alexisdev.pokemon_catalog.PokemonCatalogViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val pokemonCatalogFeatureModule = module {
    viewModel { PokemonCatalogViewModel(get()) }
}