package com.alexisdev.data

import androidx.paging.PagingData
import com.alexisdev.model.Pokemon
import kotlinx.coroutines.flow.Flow

interface PokemonRepository {
    suspend fun fetchPokemonList(): Flow<PagingData<Pokemon>>
    suspend fun fetchPokemonDetails(): Flow<Pokemon>
}