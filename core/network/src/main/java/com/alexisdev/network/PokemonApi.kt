package com.alexisdev.network

import com.alexisdev.network.model.PokemonListDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface PokemonApi {
    @GET("pokemon")
    suspend fun fetchPokemonList(
        @Query("limit") limit: Int = 30,
        @Query("offset") offset: Int = 30
    ) : PokemonListDTO
}