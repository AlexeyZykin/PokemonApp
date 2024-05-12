package com.alexisdev.domain.di

import com.alexisdev.domain.FetchPokemonDetailsUseCase
import com.alexisdev.domain.FetchPokemonListUseCase
import org.koin.dsl.factory
import org.koin.dsl.module

val domainModule = module {
    factory { FetchPokemonListUseCase(get()) }
    factory { FetchPokemonDetailsUseCase(get()) }
}