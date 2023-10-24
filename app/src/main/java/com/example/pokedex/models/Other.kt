package com.example.pokedex.models

import com.google.gson.annotations.SerializedName

data class Other(
    @SerializedName("other") val other: Sprites
)
