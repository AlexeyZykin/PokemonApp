package com.alexisdev.network.model

import com.google.gson.annotations.SerializedName

data class PokemonDetailsDTO(
    val id: Int,
    val name: String,
    @SerializedName("base_experience") val baseExperience: Int,
    val height: Int,
    val weight: Int,
    @SerializedName("is_default") val isDefault: Boolean
)
