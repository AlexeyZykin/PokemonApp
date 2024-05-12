package com.alexisdev.data

import com.alexisdev.model.PokemonDetails
import com.alexisdev.network.model.PokemonDetailsDTO

fun PokemonDetailsDTO.toPokemonDetails() =
    PokemonDetails(id, name, baseExperience, height, weight, isDefault)