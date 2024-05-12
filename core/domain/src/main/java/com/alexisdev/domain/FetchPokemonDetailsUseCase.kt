package com.alexisdev.domain

import com.alexisdev.common.Response
import com.alexisdev.data.PokemonRepository
import com.alexisdev.model.Pokemon
import com.alexisdev.model.PokemonDetails
import kotlinx.coroutines.flow.Flow

class FetchPokemonDetailsUseCase(private val pokemonRepository: PokemonRepository) {
    suspend fun invoke(pokemonName: String): Flow<Response<PokemonDetails>> {
        return pokemonRepository.fetchPokemonDetails(pokemonName)
    }
}