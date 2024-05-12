package com.alexisdev.pokemon_details

sealed class PokemonDetailsState<T> {
    data class Loading<T>(val data: T? = null): PokemonDetailsState<T>()
    data class Success<T>(val data: T? = null): PokemonDetailsState<T>()
    data class Error<T>(val msg: String? = null): PokemonDetailsState<T>()
}