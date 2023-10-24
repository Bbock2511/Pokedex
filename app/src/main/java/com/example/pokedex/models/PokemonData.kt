package com.example.pokedex.models

import com.google.gson.annotations.SerializedName

data class PokemonData(
    @SerializedName("name") val name: String?,
    @SerializedName("id") val id: Int?,
    @SerializedName("sprites") val sprites: Other,
    @SerializedName("types") val types: List<SlotType>
)

data class PokemonSprites(
    @SerializedName("front_default") val frontDefault: String?
)