package com.alexisdev.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.alexisdev.model.Pokemon
import com.alexisdev.network.ApiConstants
import com.alexisdev.network.PokemonApi

class PokemonPagingDataSource(
    private val pokemonApi: PokemonApi
) : PagingSource<Int, Pokemon>() {
    override fun getRefreshKey(state: PagingState<Int, Pokemon>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Pokemon> {
        try {
            val offset = params.key ?: ApiConstants.START_OFFSET_VALUE
            val pageSize = params.loadSize.coerceAtMost(ApiConstants.MAX_PAGE_SIZE)
            val response = pokemonApi.fetchPokemonList(limit = pageSize, offset = offset)

            val pokemonList = response.results.map { it.toPokemon() }

            val nextPageNumber = if (pokemonList.isEmpty()) null else offset + pageSize
            val prevPageNumber = if (offset == ApiConstants.START_OFFSET_VALUE) null else offset - pageSize
            return LoadResult.Page(pokemonList, prevPageNumber, nextPageNumber)

        } catch (e: Exception) {
            return LoadResult.Error(e)
        }
    }
}