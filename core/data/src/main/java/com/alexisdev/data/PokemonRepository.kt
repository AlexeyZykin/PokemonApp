package com.alexisdev.data

import androidx.paging.PagingData
import com.alexisdev.common.Response
import com.alexisdev.model.Pokemon
import com.alexisdev.model.PokemonDetails
import kotlinx.coroutines.flow.Flow

interface PokemonRepository {
    suspend fun fetchPokemonList(): Flow<PagingData<Pokemon>>
    suspend fun fetchPokemonDetails(pokemonName: String): Flow<Response<PokemonDetails>>
}