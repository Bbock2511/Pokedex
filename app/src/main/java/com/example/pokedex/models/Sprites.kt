package com.example.pokedex.models

import com.google.gson.annotations.SerializedName

data class Sprites(
    @SerializedName("official-artwork") val officialArtWork: OfficialArtWork
)
