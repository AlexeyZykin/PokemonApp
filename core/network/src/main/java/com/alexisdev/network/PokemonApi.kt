package com.alexisdev.network

import com.alexisdev.network.model.PokemonDetailsDTO
import com.alexisdev.network.model.PokemonListDTO
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonApi {
    @GET("pokemon")
    suspend fun fetchPokemonList(
        @Query("limit") limit: Int = 30,
        @Query("offset") offset: Int = 30
    ) : PokemonListDTO

    @GET("pokemon/{name}/")
    suspend fun fetchPokemonDetails(
        @Path("name") name: String
    ) : PokemonDetailsDTO
}