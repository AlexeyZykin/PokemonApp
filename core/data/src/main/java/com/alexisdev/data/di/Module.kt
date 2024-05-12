package com.alexisdev.data.di

import com.alexisdev.data.PokemonRepository
import com.alexisdev.data.PokemonRepositoryImpl
import org.koin.dsl.module

val dataModule = module {
    single<PokemonRepository> { PokemonRepositoryImpl(get()) }
}