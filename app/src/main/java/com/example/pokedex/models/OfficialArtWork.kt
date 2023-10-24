package com.example.pokedex.models

import com.google.gson.annotations.SerializedName

data class OfficialArtWork(
    @SerializedName("front_default") val frontDefault: String?
)
