package com.alexisdev.model

data class PokemonDetails(
    val id: Int,
    val name: String,
    val baseExperience: Int,
    val height: Int,
    val weight: Int,
    val isDefault: Boolean
)
