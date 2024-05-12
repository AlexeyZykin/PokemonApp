package com.alexisdev.datasource

import com.alexisdev.model.Pokemon
import com.alexisdev.network.model.PokemonDTO

fun PokemonDTO.toPokemon() = Pokemon(id, name)