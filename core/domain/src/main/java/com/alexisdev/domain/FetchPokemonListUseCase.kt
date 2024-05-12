package com.alexisdev.domain

import androidx.paging.PagingData
import com.alexisdev.data.PokemonRepository
import com.alexisdev.model.Pokemon
import kotlinx.coroutines.flow.Flow

class FetchPokemonListUseCase(private val pokemonRepository: PokemonRepository) {
    suspend fun invoke(): Flow<PagingData<Pokemon>> {
        return pokemonRepository.fetchPokemonList()
    }
}