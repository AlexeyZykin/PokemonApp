package com.alexisdev.network.model

data class PokemonListDTO(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<PokemonDTO>
)
