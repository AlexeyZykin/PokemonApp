package com.alexisdev.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.alexisdev.common.Response
import com.alexisdev.datasource.PokemonPagingDataSource
import com.alexisdev.model.Pokemon
import com.alexisdev.model.PokemonDetails
import com.alexisdev.network.PokemonApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

internal class PokemonRepositoryImpl(private val pokemonApi: PokemonApi) : PokemonRepository {
    override suspend fun fetchPokemonList(): Flow<PagingData<Pokemon>> {
        return Pager(
            config = PagingConfig(pageSize = 20),
            pagingSourceFactory = {
                PokemonPagingDataSource(pokemonApi)
            }
        ).flow
    }

    override suspend fun fetchPokemonDetails(pokemonName: String): Flow<Response<PokemonDetails>> = flow {
        emit(Response.Loading())
        val apiResponse = try {
            pokemonApi.fetchPokemonDetails(pokemonName)
        }
        catch (e: Exception) {
            emit(Response.Error(msg = e.message))
            null
        }
        if (apiResponse != null) {
            val pokemon = apiResponse.toPokemonDetails()
            emit(Response.Success(pokemon))
        }
    }
}