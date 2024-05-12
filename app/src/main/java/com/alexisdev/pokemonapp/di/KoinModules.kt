package com.alexisdev.pokemonapp.di

import com.alexisdev.data.di.dataModule
import com.alexisdev.domain.di.domainModule
import com.alexisdev.network.di.networkModule
import com.alexisdev.pokemon_catalog.di.pokemonCatalogFeatureModule

val koinModules = listOf(
    networkModule,
    dataModule,
    domainModule,
    pokemonCatalogFeatureModule
)